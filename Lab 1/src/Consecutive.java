public class Consecutive {
    public static int findDup(int[] nums) {
        int xor = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i]^i) != 0) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,4,6};
        int duplicate = findDup(nums);
        System.out.println("The duplicate number is: " + duplicate);
    }
}
