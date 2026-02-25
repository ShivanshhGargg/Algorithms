public class KthSmallest {
    public static int partition(int[] arr, int s, int e) {
        int m = s + (e - s) / 2;
        int pivot = arr[m];
        int index = s;
        for (int i = s; i <= e; i++) {
            if (arr[i] < pivot) index++;
        }
        swapIndex(arr, m, index);
        int l = s, h = e;
        while (l < index && h > index) {
            while (arr[l] < pivot) l++;
            while (arr[h] > pivot) h--;

            if (l < index && h > index) {
                swapIndex(arr, l, h);
                l++;
                h--;
            }
        }
        return index;
    }

    public static int qs(int[] arr,int k,int s,int e) throws Exception{
        if (k <= 0 || k > (e - s + 1)) throw new Exception("k out of bounds");
        if (s == e) return arr[s];

        int j = partition(arr, s, e);
        int count = j - s + 1;

        if (k == count) return arr[j];
        else if (k < count) return qs(arr, k, s, j - 1);
        else return qs(arr, k - count, j + 1, e);
    }

    private static void swapIndex(int[] arr, int l, int h) {
        int t = arr[l];
        arr[l] = arr[h];
        arr[h] = t;
    }

    public static void main(String[] args) throws Exception{
        int[] arr = {6,1,3,4,5,2,7,8};
        int k = 8;
        int i = qs(arr,k,0,arr.length-1);
        System.out.println(i);
    }
}
