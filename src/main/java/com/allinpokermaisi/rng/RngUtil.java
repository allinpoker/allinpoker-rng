package com.allinpokermaisi.rng;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RngUtil {

    private static SecureRandom secureRandom;

    static {
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static int[] generateRandomNumbers(int bound) {
        int[] originArr = new int[bound];
        for (int i = 0; i < bound; i++) {
            originArr[i] = i;
        }
        int[] resultArr = new int[bound];
        for (int i = 0; bound > 0; i++) {
            int randomIndex = generateRandomInt(bound);
            int value = originArr[randomIndex];
            originArr[randomIndex] = originArr[bound - 1];
            originArr[bound - 1] = 0;
            bound--;
            resultArr[i] = value;
        }

        secondShuffle(resultArr);
        return resultArr;
    }

    public static int generateRandomInt(int bound) {
        return secureRandom.nextInt(bound);
    }

    private static void secondShuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = generateRandomInt(arr.length);
            swap(arr, i, randomIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
