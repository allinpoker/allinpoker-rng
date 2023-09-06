package com.allinpokermaisi.codec;

import com.allinpokermaisi.model.PokerValue;
import org.junit.Test;

public class PokerCodecTest {

    @Test
    public void shufflePokerTest() {
        int[] texasCards = PokerCodec.shufflePoker(false);
        assert texasCards.length == 52;
        int[] shortCards = PokerCodec.shufflePoker(true);
        assert shortCards.length == 36;
    }

    @Test
    public void getPokerByCodeTest() {
        PokerValue pokerByCode = PokerCodec.getPokerByCode((byte) 23);
        assert pokerByCode != null;
        assert pokerByCode.getNumber() == 13;
    }
}
