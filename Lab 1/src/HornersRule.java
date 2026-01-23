public class HornersRule {
    public static String HR(int i,int[] arr){
        if (i == arr.length-1)return arr[i] + "";
        else return arr[i] + " + x(" + HR(i+1,arr) + ")";
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(HR(0,arr));
    }
}
