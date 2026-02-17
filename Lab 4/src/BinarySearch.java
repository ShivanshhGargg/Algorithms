public class BinarySearch {
    public static int bs(int[] arr,int target,int s,int e){
        int m = s + (e-s)/3;
        if (arr[m] == target)return m;
        else if (arr[m]<target)return bs(arr,target,m+1,e);
        else return bs(arr, target, s, m-1);
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(bs(arr,3,0, arr.length-1));
    }
}
