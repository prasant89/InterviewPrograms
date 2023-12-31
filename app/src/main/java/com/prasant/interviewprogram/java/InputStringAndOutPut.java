package com.prasant.interviewprogram.java;

import java.util.Stack;

public class InputStringAndOutPut {
    public static String decodeString(String input) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentCount = 0;

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                currentCount = currentCount * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(currentCount);
                stringStack.push(currentString);
                currentCount = 0;
                currentString = new StringBuilder();
            } else if (c == ']') {
                StringBuilder decodedString = stringStack.pop();
                int repeatCount = countStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        String input = "3[a]2[bc]";
        String decodedString = decodeString(input);
        System.out.println(decodedString); // Output: aaabcbc
    }
}
