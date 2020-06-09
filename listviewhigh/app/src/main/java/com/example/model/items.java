package com.example.model;

public class items {
    String birdListName;
    int birdListImage;

    public String getBirdListName() {
        return birdListName;
    }

    public void setBirdListName(String birdListName) {
        this.birdListName = birdListName;
    }

    public int getBirdListImage() {
        return birdListImage;
    }

    public void setBirdListImage(int birdListImage) {
        this.birdListImage = birdListImage;
    }

    public items() {
    }

    public items(String birdListName, int birdListImage) {
        this.birdListName = birdListName;
        this.birdListImage = birdListImage;
    }
}
