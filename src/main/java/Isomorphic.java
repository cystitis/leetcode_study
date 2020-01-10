/*
Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
Example 1:
Input: s = "egg", t = "add"
Output: true
Example 2:
Input: s = "foo", t = "bar"
Output: false
Example 3:
Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
*/


import java.util.HashMap;
import java.util.Map;

class Isomorphic {

    public boolean isIsomorphic(String s, String t) {
        //transformation
        String src = transformation(s);
        String target = transformation(t);

        if( src.equals(target) )
            return true;

        return false;
    }

    String transformation(String s){
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char tempChar = s.charAt(i);
            if( map.containsKey(tempChar) )
                continue;
            else {
                map.put(tempChar, i + 1);
            }
        }

        StringBuilder convertedBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if( map.get(s.charAt(i)) != null )
                convertedBuilder.append( String.valueOf( map.get(s.charAt(i)) ) );
            else
                System.out.println("not exist keys... key : " + s.charAt(i));
        }

        return convertedBuilder.toString();
    }

    public static void main(String ... args){
        Isomorphic isomorphic = new Isomorphic();
        isomorphic.isIsomorphic("egg", "add");
    }
}