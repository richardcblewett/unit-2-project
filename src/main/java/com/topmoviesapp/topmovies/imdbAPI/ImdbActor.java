package com.topmoviesapp.topmovies.imdbAPI;

public class ImdbActor {
    private String name;
    private String id;
    private String image;
    private String asCharacter;

    public ImdbActor() {
    }

    public ImdbActor(String name, String id, String image, String asCharacter) {
        this.name = name;
        this.id = id;
        this.image = image;
        this.asCharacter = asCharacter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAsCharacter() {
        return asCharacter;
    }

    public void setAsCharacter(String asCharacter) {
        this.asCharacter = asCharacter;
    }
}
