package springbootpart3;


import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private long id;
    private String name;
    private String surname;

    public User(long ID,String name, String surname){
        this.name=name;
        this.id = ID;
        this.surname=surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
