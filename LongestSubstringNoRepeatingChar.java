import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(args[0]));
    }
}
