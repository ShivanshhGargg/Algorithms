public class Velocity {
    public static int tips(double v,int t){
        if (v>=1){
            t++;
            v = v - (0.425 * v);
            return tips(v,t);
        }
        else return t;
    }

    public static void main(String[] args) {
        System.out.println(tips(40,0));
    }
}
