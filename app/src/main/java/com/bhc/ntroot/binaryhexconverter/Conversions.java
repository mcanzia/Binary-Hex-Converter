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
        return binary.toString();
    }

    public static String decimalToOctal(int num) {
        StringBuilder octal = new StringBuilder();
        if (num == 0) {
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
        return octal.toString();
    }

    public static String decimalToHex(int num) {
        StringBuilder hex = new StringBuilder();
        if (num == 0) {
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
        return hex.toString();
    }

    public static int binaryToDecimal(String binary) {
        char bitList[] = binary.toCharArray();
        int length = bitList.length;
        int num = 0;
        for (int i = 0; i <= length - 1; i++) {
            if (bitList[i] == '1') {
                num += Math.pow(2, length - 1 - i);
            }
        }
        return num;
    }

    public static int octalToDecimal(int octal) {
        int pow = 0;
        int decimal = 0;
        int size = Integer.toString(octal).length();
        while(pow < size) {
            int temp = (int) (octal % Math.pow(10, pow + 1));
            temp = (int) (temp / Math.pow(10, pow));
            decimal += temp * Math.pow(8, pow);
            octal = octal - temp;
            pow++;
        }
        return decimal;
    }

    public static int hexToDecimal(String hex) {
        char bitList[] = hex.toCharArray();
        int decimal = 0;
        int pow = 0;
        for (int i = bitList.length - 1; i >= 0; i--) {
            //if (Character.isAlphabetic(bitList[i])) {
            decimal += hexHelper(bitList[i]) * Math.pow(16, pow);
            //} else {
            //decimal += Character.getNumericValue(bitList[i]) * Math.pow(16, pow);
            //}
            pow++;
        }
        return decimal;
    }

    private static int hexHelper(char c) {
        if (c == 'A') {
            return 10;
        } else if (c == 'B') {
            return 11;
        } else if (c == 'C') {
            return 12;
        } else if (c == 'D') {
            return 13;
        } else if (c == 'E') {
            return 14;
        } else if (c == 'F') {
            return 15;
        }
        return Character.getNumericValue(c);
    }
}
