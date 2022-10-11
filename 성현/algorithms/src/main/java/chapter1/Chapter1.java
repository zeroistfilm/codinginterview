package chapter1;

import java.util.*;

public class Chapter1 {

    public boolean checkDuplicateChar(String str) {
        Set<Character> existingChar = new HashSet<>();
        char[] charArray = str.toCharArray();
        for (char ch: charArray) {
            if (existingChar.contains(ch)) {
                return true;
            }
            existingChar.add(ch);
        }
        return false;
    }

    public String replaceCharacter(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder newString = new StringBuilder();
        String replaceStr = "%20";
        for (char ch: charArray) {
            if (ch == ' ') {
                newString.append(replaceStr);
                continue;
            }
            newString.append(ch);
        }
        return newString.toString();
    }

    public String isOneCharDiff(String str1, String str2) {
        return "";
    }

}
