package SlidingWindowAlgorithm;

import java.util.*;

public class SubstringwithConcatenationAllWords {
    public static void main(String[] args) {

    }
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (String str : words) {
            map.put(str, 1);
        }
        int count = map.size();
        int wordSize = words[0].length();
        int begin = 0, end = wordSize;
        int startp = 0;
        while (end < s.length()) {
            String cur = s.substring(begin, end);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) {
                    count--;
                    if (count == 0 && end - begin == words.length * wordSize) {
                        res.add(begin);
                    }
                    end += wordSize;
                } else {
                    String leadWord = s.substring(begin, begin + wordSize);
                    if (map.containsKey(leadWord)) {
                        map.put(leadWord, map.get(leadWord) + 1);
                        if (map.get(leadWord) == 1) {
                            count++;
                        }
                    }
                    begin += wordSize;
                }

            }

        }
        return res;

    }
}
