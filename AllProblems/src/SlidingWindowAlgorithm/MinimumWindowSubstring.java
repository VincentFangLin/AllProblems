package SlidingWindowAlgorithm;

//Given two strings s and t, return the minimum window in s which will contain all the characters in t.
// If there is no such window in s that covers all characters in t, return the empty string "".
//
//        Note that If there is such a window, it is guaranteed that there will always be only
// one unique minimum window in s.
//
//Example 1:
//
//        Input: s = "ADOBECODEBANC", t = "ABC"
//        Output: "BANC"
//        Example 2:
//
//        Input: s = "a", t = "a"
//        Output: "a"

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String res = minWindow("ADOBECODEBANC","ABC");
        System.out.println(res);
    }
    public static String minWindow(String s, String t) {
        if(t.length()> s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int counter = map.size();

        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        System.out.println("----" + map);

        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            System.out.println(map);
            System.out.println("end : " + end);
            System.out.println("count : " + counter);

            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin < len){
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }

        }
        if(len == Integer.MAX_VALUE) return "";
        return s.substring(head, head+len);
    }


}
