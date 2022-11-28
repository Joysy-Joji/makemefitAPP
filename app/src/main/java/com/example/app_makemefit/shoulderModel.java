package com.example.app_makemefit;

public class shoulderModel {

    private String name,description;

    private shoulderModel() {}

    private  shoulderModel(String name, String description){
        this.name = name;
        this.description = description;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
