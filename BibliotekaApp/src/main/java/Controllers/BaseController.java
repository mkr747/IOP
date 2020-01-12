package Controllers;

import Models.ModelBase;
import DataAccess.LibraryContext;

import java.io.IOException;
import java.util.List;

public abstract class BaseController<T>{
	private LibraryContext _context;
	private Class<? extends ModelBase> _clazz;

	public BaseController(LibraryContext ctx, Class<? extends ModelBase> clazz){
		_clazz = clazz;
		_context = ctx;
	}

	public T Get(int index){
		var elements =_context.Get(_clazz);
		for(ModelBase element : elements){
			if(element.Id == index) {
				return (T)element;
			}
		}

		return null;
	}

	public List<T> GetAll() {
		return (List<T>)_context.Get(_clazz);
	}


	public boolean Post(ModelBase update) {
		_context.Add(_clazz, update);
		try {
			_context.SaveChanges();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public boolean Delete(int index) {
		_context.Remove(_clazz, index);
		try {
			_context.SaveChanges();
		} catch (IOException e) {
			return false;
		}

		return true;
	}

	public boolean Patch(ModelBase element) {
		_context.Set(_clazz, element);
		try {
			_context.SaveChanges();
		} catch (IOException e) {
			return false;
		}

		return true;
	}
}