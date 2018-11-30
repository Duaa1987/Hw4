package com.project.duaa.hw4;

public class Card {
    private String name;
    private int imageResourceId;

    public static final Card[] cards = {
            new Card("Snow", R.drawable.snow),
            new Card("Sperow", R.drawable.sperow),
            new Card("Bat",R.drawable.bat),
            new Card("bul",R.drawable.bulbasor),
            new Card("ch",R.drawable.charmander),


    };

    private Card(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }
    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
