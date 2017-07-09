package com.bhc.ntroot.binaryhexconverter;

/**
 * Created by Michael Canziani on 7/8/2017.
 */

public class Conversions {

    public Conversions() {

    }

    public static String decimalToBinary(int num) {
        StringBuilder binary = new StringBuilder();
        if (num == 0) {
            //System.out.println("0");
            return "0";
        }
        while (num > 0) {
            if (num != 0 && (num % 2) == 0) {
                binary.insert(0, "0");
            } else {
                binary.insert(0, "1");
            }
            num = num / 2;
        }
        //System.out.println(binary.toString());
        return binary.toString();
    }

    public static String decimalToOctal(int num) {
        StringBuilder octal = new StringBuilder();
        if (num == 0) {
            //System.out.println("0");
            return "0";
        }
        while (num > 0) {
            if (num != 0 && (num % 8) == 0) {
                octal.insert(0, "0");
            } else {
                octal.insert(0, "" + num % 8);
            }
            num = num / 8;
        }
        //System.out.println(octal.toString());
        return octal.toString();
    }

    public static String decimalToHex(int num) {
        StringBuilder hex = new StringBuilder();
        if (num == 0) {
            //System.out.println("0");
            return "0";
        }
        while (num > 0) {
            int temp = num % 16;
            if (num != 0 && temp == 0) {
                hex.insert(0, "0");
            } else {
                if (temp <= 9) {
                    hex.insert(0, "" + temp);
                } else {
                    hex.insert(0, (char)('A' + (temp - 10)));
                }
            }
            num = num / 16;
        }
        //System.out.println(hex.toString());
        return hex.toString();
    }
}
