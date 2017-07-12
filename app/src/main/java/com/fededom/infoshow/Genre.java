package com.fededom.infoshow;

public enum Genre {

    TODOS(0),
    MUSICA(1),
    CINE(2),
    TEATRO(3),
    EVENTOS(4);

    private int value;

    Genre(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
