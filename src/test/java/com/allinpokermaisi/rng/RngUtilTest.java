package com.allinpokermaisi.rng;

import org.junit.Test;

import java.util.Arrays;

public class RngUtilTest {

    @Test
    public void generateRandomNumbersTest() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(RngUtil.generateRandomNumbers(52)));
        }
    }
}
