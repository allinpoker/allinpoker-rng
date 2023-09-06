package com.allinpokermaisi.enums;

public enum PokerSuit {
    Spade(10),
    Heart(30),
    Club(50),
    Diamond(70);

    private int begin;

    PokerSuit(int begin) {
        this.begin = begin;
    }

    public int getBegin() {
        return this.begin;
    }
}
