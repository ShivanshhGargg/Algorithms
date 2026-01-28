public class Consecutive {
    public static int findMis(int[] nums) {
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((prev&1) == (nums[i]&1)){
                if ((prev&1) == 0){
                    return prev|1;
                }
                else {
                    return (nums[i] & ~1);
                }
            }
            prev = nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,7};
        int mis = findMis(nums);
        System.out.println("The duplicate number is: " + mis);
    }
}
