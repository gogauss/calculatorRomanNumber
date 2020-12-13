package com.test;

public class Counter {
    static String result, exceptionMessage;
    static boolean isArabic;
    static int num1, num2;

    static void count(String s) {
        int operator = getOperator(s);
        if (operator == 4) return;
        String[] nums = s.split(" *\\+ *| *- *| *\\* *| */ *");
        try {
            num1 = Integer.parseInt(nums[0]);
            num2 = Integer.parseInt(nums[1]);
            isArabic = true;
        } catch (Exception e) {
            isArabic = false;
        }
        if (isArabic) {
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                exceptionMessage = "Too big number";
                return;
            }
        } else {
            num1 = romanToArabic(nums[0]);
            num2 = romanToArabic(nums[1]);
            if (num1 == 0 || num2 == 0) {
                exceptionMessage = "Wrong number";
                return;
            }
        }
        switch (operator) {
            case 0: add(num1, num2); break;
            case 1: subtract(num1, num2); break;
            case 2: multiply(num1, num2); break;
            case 3: divide(num1, num2); break;
        }
    }

    static int getOperator(String s) {
        if (s.matches("\\w+ *\\+ *\\w+")) return 0;
        else if (s.matches("\\w+ *- *\\w+")) return 1;
        else if (s.matches("\\w+ *\\* *\\w+")) return 2;
        else if (s.matches("\\w+ */ *\\w+")) return 3;
        exceptionMessage = "Wrong operator";
        return 4;
    }

    static int romanToArabic(String num) {
        switch (num) {
            case "I": return 1;
            case "II": return 2;
            case "III": return 3;
            case "IV": return 4;
            case "V": return 5;
            case "VI": return 6;
            case "VII": return 7;
            case "VIII": return 8;
            case "IX": return 9;
            case "X": return 10;
            default: return 0;
        }
    }

    static String arabicToRoman(int num) {
        if (num == 0) return "0";
        if (num == 10) return "X";
        if (num == 100) return "C";
        StringBuilder sb = new StringBuilder();
        switch (num / 10) {
            case 1: sb.append("X"); break;
            case 2: sb.append("XX"); break;
            case 3: sb.append("XXX"); break;
            case 4: sb.append("XL"); break;
            case 5: sb.append("L"); break;
            case 6: sb.append("LX"); break;
            case 7: sb.append("LXX"); break;
            case 8: sb.append("LXXX"); break;
            case 9: sb.append("XC"); break;
        }
        switch (num % 10) {
            case 1: sb.append("I"); break;
            case 2: sb.append("II"); break;
            case 3: sb.append("III"); break;
            case 4: sb.append("IV"); break;
            case 5: sb.append("V"); break;
            case 6: sb.append("VI"); break;
            case 7: sb.append("VII"); break;
            case 8: sb.append("VIII"); break;
            case 9: sb.append("IX"); break;
        }
        return sb.toString();
    }

    static void add(int num1, int num2) {
        if (isArabic) {
            result = String.valueOf(num1 + num2);
        } else {
            result = arabicToRoman(num1 + num2);
        }
    }

    static void subtract(int num1, int num2) {
        if (isArabic) {
            result = String.valueOf(num1 - num2);
        } else {
            if (num2 > num1) {
                result = "-" + arabicToRoman(num2 - num1);
            } else {
                result = arabicToRoman(num1 - num2);
            }
        }
    }

    static void multiply(int num1, int num2) {
        if (isArabic) {
            result = String.valueOf(num1 * num2);
        } else {
            result = arabicToRoman(num1 * num2);
        }
    }

    static void divide(int num1, int num2) {
        if (isArabic) {
            result = String.valueOf(num1 / num2);
        } else {
            result = arabicToRoman(num1 / num2);
        }
    }
}
