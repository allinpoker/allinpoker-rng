package com.allinpokermaisi.codec;

import com.allinpokermaisi.enums.PokerSuit;
import com.allinpokermaisi.model.PokerValue;
import com.allinpokermaisi.rng.RngUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokerCodec {

// A23456789.10JQK   11...19，20，21，22，23    Spade
// A23456789.10JQK   31...39，40，41，42，43    Heart
// A23456789.10JQK   51...59，60，61，62，63    Club
// A23456789.10JQK   71...79，80，81，82，83    Diamond

    public static List<PokerValue> totalPokerList = new ArrayList<>();
    public static PokerValue[] pokerValues = new PokerValue[84];
    public static int[] pokerCodes = new int[52]; // texas omaha
    public static int[] shortCodes = new int[36]; // short desk

    static {
        int n = 0;
        int shortN = 0;
        for (PokerSuit pokerSuit : PokerSuit.values()) {
            for (int i = 1; i < 14; i++) {
                String label = i + "";
                int number = i;
                int code = (pokerSuit.getBegin() + i);
                pokerCodes[n] = code;
                if (number == 1 || number >= 6) {
                    shortCodes[shortN] = code;
                    shortN++;
                }
                n++;
                switch (i) {
                    case 1:
                        label = "A";
                        number = 14;
                        break;
                    case 11:
                        label = "J";
                        break;
                    case 12:
                        label = "Q";
                        break;
                    case 13:
                        label = "K";
                        break;
                    default:
                        break;
                }
                PokerValue pokerValue = new PokerValue(pokerSuit, label, number, code);
                totalPokerList.add(pokerValue);
                pokerValues[code] = pokerValue;
            }
        }
    }

    public static PokerValue getPokerByCode(byte code) {
        return pokerValues[code];
    }

    public static int[] shufflePoker(boolean isShort) {
        int[] arr = isShort ? Arrays.copyOf(shortCodes, shortCodes.length) : Arrays.copyOf(pokerCodes, pokerCodes.length);
        return shuffle(arr);
    }

    private static int[] shuffle(int[] arr) {
        int[] randomIndexArr = RngUtil.generateRandomNumbers(arr.length);
        int[] resultPokerCodeArr = new int[arr.length];
        for (int i = 0; i < randomIndexArr.length; i++) {
            int index = randomIndexArr[i];
            resultPokerCodeArr[i] = arr[index];
        }
        return resultPokerCodeArr;
    }
}
