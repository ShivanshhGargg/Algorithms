public class Duplicate {
    public static int dup(int[] arr){
        int dup = -1;
        int index = arr.length;
        for (int i = 0; i < index; i++) {
            for (int j = i+1; j < index; j++) {
                if (arr[i] == arr[j]){
                    dup = arr[i];
                    index = j;
                    break;
                }
            }
        }
        return dup;
    }
    public static int dup2(int[] arr){
        int dup = -1;
        int n = arr.length / 2;
        for (int i = 0; i < n; i++) {
            int t = arr[n-i];
            for (int j = 0; j < n-i; j++) {
                if (t == arr[j]){
                    dup = t;
                    break;
                }
            }
        }
        return dup;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,3,1,3,4,4};
        System.out.println(dup(arr));
        System.out.println(dup2(arr));
    }
}
