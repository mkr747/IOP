package Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ModelBase {
    public ModelBase() { }

    public ModelBase(int id) {
        Id = id;
    }

    @JsonGetter("Id")
    public int getId() {
        return Id;
    }

    @JsonSetter("Id")
    public void setId(int id) {
        Id = id;
    }

    public int Id;
}
