package DataAccess;

import Models.*;
import Models.Reader;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarySerializer {
    public Library Library;
    private String _filePath;
    private ObjectMapper _mapper;

    public LibrarySerializer(String filePath) throws IOException {
        _filePath = filePath;
        _mapper = new ObjectMapper();
        OpenFile();
    }

    public void SaveChanges() throws IOException {
        File file = new File(_filePath);
        _mapper.writeValue(file, Library);
    }

    private void OpenFile() throws IOException {
        File file = new File(_filePath);
        if(!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        try {
            Library = _mapper.readValue(file, Library.class);
        } catch (Exception e) {
            _mapper.writeValue(file, GetLibrary());
            System.out.println("Cannot map");
        }
    }

    private Library GetLibrary(){
        return new Library(new ArrayList<Administrator>(), new ArrayList<Librarian>(), new ArrayList<>(), new ArrayList<Book>(),  new ArrayList<Magazine>(), new ArrayList<Rent>(), new ArrayList<Reservation>());
    }
}
