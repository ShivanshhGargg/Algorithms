public class Duplicate {
    public static int dup(int[] arr){
        int k = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-k; j++) {
                if (arr[j] == arr[j+k])return arr[j];
            }
            k++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,3,2,1};
        System.out.println(dup(arr));
    }
}
