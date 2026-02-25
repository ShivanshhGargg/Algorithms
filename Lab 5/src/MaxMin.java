public class MaxMin {
    static int max = Integer.MIN_VALUE;
    static int max1 = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int min1 = Integer.MAX_VALUE;

    private static void max_min(int[] arr,int s,int e){
        if (s == e){
            max1 = min1 = arr[s];
            return;
        }
        else if (e == s + 1) {
            if (arr[s] < arr[e]) {
                min = arr[s];
                max = arr[e];
            } else {
                min = arr[e];
                max = arr[s];
            }
            return;
        }

        int mid = s + (e - s) / 2;

        max_min(arr, s, mid);
        int leftMin = min;
        int leftMax = max;

        max_min(arr, mid + 1, e);
        int rightMin = min;
        int rightMax = max;

        min = Math.min(leftMin, rightMin);
        max = Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        max_min(arr,0,arr.length-1);
        System.out.println("Minimum = "+min);
        System.out.println("Maximum = "+max);
    }
}