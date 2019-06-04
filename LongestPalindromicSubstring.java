public class LongestPalindromicSubstring {
    public static boolean isPalindrome(String s) {
        if (s.equals("")) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }

        int length = s.length();

        int temp;
        if (length % 2 == 0) {
            temp = length / 2;
        }
        else {
            temp = (length - 1) / 2;
        }

        int i = 0;
        int j = length - 1;
        do {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        } while (i <= temp && j >= temp);

        return true;
    }

    public static String longestPalindrome(String s) {
        if (s.equals("") || s.length() == 1) {
            return s;
        }

        int length = 0;
        int start = 0, end = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length()+1; j++) {
                if (isPalindrome(s.substring(i, j)) && (j - i) >= length) {
                    length = j - i;
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome(args[0]));
    }
}
