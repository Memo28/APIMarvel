package com.example.memovaradegante.apimarvel.Models;

/**
 * Created by Memo Vara De Gante on 29/04/2018.
 */

public class Character {
    public String name;
    public String image;
    public String extension;
    public String description;

    public Character(){

    }

    public Character(String name, String image, String extension, String description) {
        this.name = name;
        this.image = image;
        this.extension = extension;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String generateImage(){
        return image+"."+extension;
    }
}
