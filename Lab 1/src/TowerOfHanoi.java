import java.util.Scanner;

public class TowerOfHanoi {
    public static void TOH(int n, int src, int dest, int ex){
        if (n <= 0) return;
        if (n == 1) {
            System.out.printf("Move disk from %d to %d\n", src, dest);
            return;
        }
        TOH(n-1,src,ex,dest);
        System.out.printf("Move disk from %d to %d\n",src,dest);
        TOH(n-1,ex,dest,src);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Disc = ");
        int n = sc.nextInt();
        TOH(n,1,3,2);
    }
}