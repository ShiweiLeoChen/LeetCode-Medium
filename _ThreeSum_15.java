import __HELPER_CLASSES__.StrIntArr;

import java.util.*;

public class _ThreeSum_15 {
    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = StrIntArr.strIntArr(args[0]);
        List<List<Integer>> ans = threeSum(arr);
        System.out.println("[");
        for (List<Integer> i : ans) {
            System.out.println(" "+ Arrays.toString(i.toArray()));
        }
        System.out.println("]");
    }
}
