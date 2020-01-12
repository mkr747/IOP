package Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.HashSet;
import java.util.Set;

public class Magazine extends Resource {
	@JsonGetter("InUse")
	public boolean isInUse() {
		return InUse;
	}

	@JsonSetter("InUse")
	public void setInUse(boolean inUse) {
		InUse = inUse;
	}

	private boolean InUse;

	public Magazine() {
		Authors = new HashSet<>();
	}

	public Magazine(int id, Set<String> author, String release, String title) {
		super(id, author, release, title);
		InUse = false;
	}
}