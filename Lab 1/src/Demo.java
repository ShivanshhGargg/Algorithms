public class Demo {
    public static void main(String[] args) {
        long t1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {

        }
        long t2 = System.nanoTime();
        long t = t2-t1;
        System.out.println(t/1_000_000);
    }
}
