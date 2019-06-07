package __HELPER_CLASSES__;

import java.util.Arrays;

public class StrIntArr {
    public static int[] strIntArr(String str) {
        int[] arr = Arrays.stream(str.substring(1, str.length()-1).split(","))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();

        return arr;
    }

    public static int[] strIntToIntArr(String str) {
        int[] arr = new int[str.length()];
        for (int i = 0, j = 1; i < str.length(); i++, j++) {
            arr[i] = Integer.parseInt(str.substring(i, j));
        }

        return arr;
    }
}
