package ru.maritariny;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // accb
        // cab
        // 4

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String c = reader.readLine();

        char[] ch = c.toCharArray();
        Set<Character> set = new HashSet();
        for (char cc: ch) {
            set.add(cc);
        }

        int result = Integer.MAX_VALUE;
        String substr = "";

        int left = 0;
        int right = 0;

        while (right <= s.length()) {
            Set<Character> chars = new HashSet<>();
            for (int i = left; i < right; i++) {
                char cur = s.charAt(i);
                if (!set.contains(cur)) {
                    left = i + 1;
                    break;
                }
                chars.add(cur);
            }

            if (chars.containsAll(set)) {
                if (right - left < result) {
                    result = right - left;
                    //substr = s.substring(left, right);
                }
                left++;
            } else {
                right++;
            }
        }

        if (result == Integer.MAX_VALUE) {
            result = 0;
        }
        //System.out.println(substr);
        System.out.println(result);

    }
}
