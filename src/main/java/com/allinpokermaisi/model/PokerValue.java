package com.allinpokermaisi.model;

import com.allinpokermaisi.enums.PokerSuit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PokerValue implements Comparable<PokerValue> {
    private PokerSuit suit;
    private String label;
    private int number;
    private int code;

    @Override
    public int compareTo(PokerValue o) {
        return number > o.getNumber() ? 1 : (number < o.getNumber() ? -1 :
                (suit.ordinal() < o.getSuit().ordinal() ? -1 : (suit.ordinal() > o.getSuit().ordinal() ? 1 : 0)));
    }

    public int compareToBiz(PokerValue o) {
        return this.cop(o);
    }

    private int cop(PokerValue o) {
        return number > o.getNumber() ? 1 : (number < o.getNumber() ? -1 : 0);
    }
}
