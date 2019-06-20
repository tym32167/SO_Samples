package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSolver {
    public static void Solve(String[] input) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) set.add(input[i]);

        ArrayList<String> result = new ArrayList<>();
        String top1 = "";
        String top2 = "";

        for (int i = 0; i < input.length; i++) {
            if (isCombination(set, input[i], 0)) {
                result.add(input[i]);

                if (top2.length() < input[i].length())
                    top2 = input[i];

                if (top1.length() < top2.length()) {
                    String temp = top1;
                    top1 = top2;
                    top2 = temp;
                }
            }
        }

        System.out.println(top1);
        System.out.println(top2);
        System.out.println(result.size());
    }

    public static boolean isCombination(HashSet<String> set, String input, int startIndex) {
        if (startIndex == input.length()) return true;
        for (int i = startIndex; i <= input.length(); i++) {
            if (set.contains(input.substring(startIndex, i))) {
                if (startIndex == 0 && i == input.length()) return false;
                if (isCombination(set, input, i)) return true;
            }
        }
        return false;
    }
}
