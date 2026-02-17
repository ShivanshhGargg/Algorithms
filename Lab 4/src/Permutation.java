public class Permutation {
    public static void perm(char[] arr,int i){
        if (i == arr.length) {
            for (char a : arr) System.out.print(a);
            System.out.println();
        }
        else for (int j = i; j < arr.length; j++) {
            swapChar(i,j,arr);
            perm(arr,i+1);
            swapChar(i,j,arr);
        }
    }

    private static void swapChar(int i, int j, char[] arr) {
        char a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }

    public static void main(String[] args) {
        char[] str = {'a','b','c','d'};
        perm(str,0);
    }
}