import __HELPER_CLASSES__.StrIntArr;

public class MostWaterContainer {
    public static int maxAreaBruteForce(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j])*(j-i));
            }
        }

        return max;
    }

    public static int maxAreaTwoPointers(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left <= right) {
            max = Math.max(max, (right-left)*Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = StrIntArr.strIntArr(args[0]);
        System.out.println(maxAreaBruteForce(arr));
        System.out.println(maxAreaTwoPointers(arr));
    }
}
