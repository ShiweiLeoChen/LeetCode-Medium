import java.util.*;

public class LongestSubstringNoRepeatingChar {
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.equals(" ")) {
            return 1;
        }

        int index = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();

        while(index < arr.length) {
            for (char i : Arrays.copyOfRange(arr, index, arr.length)) {
                if (set.contains(i)) {
                    int size = set.size();
                    max = size > max? size : max;
                    set.clear();
                    index++;
                    break;
                }
                else {
                    set.add(i);
                }
            }
        }

        return max;
    }

    public static int lengthOfLongestSubstring1(String s) {
        char[] str = s.toCharArray();
        List<Character> res = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            if (!res.contains(str[i])) {
                res.add(str[i]);
            }
            else {
                while (res.contains(str[i])) {
                    res.remove(0);
                }
                res.add(str[i]);
            }

            if (res.size() > max) {
                max = res.size();
            }
        }

        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int start = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start) {
                start = map.get(s.charAt(i)) + 1;
            }

            map.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(args[0]));
        System.out.println(lengthOfLongestSubstring1(args[0]));
        System.out.println(lengthOfLongestSubstring2(args[0]));
    }
}
