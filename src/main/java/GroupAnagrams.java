/*
Given an array of strings, group anagrams together.
Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
All inputs will be in lowercase.
The order of your output does not matter.
*/


import java.util.*;

public class GroupAnagrams {

    List<List<String>> run(String[] strs){
        List<List<String>> resultList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for( String str : strs ) {
            char[] tempChar = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                tempChar[i] = str.charAt(i);
            }

            Arrays.sort(tempChar);
            String keyString = Arrays.toString(tempChar);

            if (map.containsKey(keyString)) {
                List<String> newValueList = map.get(keyString);
                newValueList.add(str);
                map.put(keyString, newValueList);
            } else {
                List<String> newValueList = new ArrayList<>();
                newValueList.add(str);
                map.put(keyString, newValueList);
            }
        }

        for( Map.Entry<String, List<String>> entry : map.entrySet() )
            resultList.add(entry.getValue());

        return resultList;
    }


    public static void main(String ... args){
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        groupAnagrams.run(strs);
    }
}