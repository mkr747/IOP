package Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.HashSet;
import java.util.Set;

public abstract class Resource extends ModelBase {
	public Resource() {
	}

	public Resource(int id, Set<String> authors, String release, String title) {
		super(id);
		Authors = authors;
		Release = release;
		Title = title;
	}

	public String Release;

	public String Title;

	public Set<String> Authors;

	@JsonGetter("Authors")
	public Set<String> getAuthor() {
		return Authors;
	}

	@JsonSetter("Authors")
	public void setAuthor(Set<String> authors) {
		Authors = authors;
	}

	@JsonGetter("Release")
	public String getRelease() {
		return Release;
	}

	@JsonSetter("Release")
	public void setRelease(String release) {
		Release = release;
	}

	@JsonGetter("Title")
	public String getTitle() {
		return Title;
	}

	@JsonSetter("Title")
	public void setTitle(String title) {
		Title = title;
	}
}