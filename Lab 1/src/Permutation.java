public class Permutation {
    public static void perm(char[] str, int i){
        if (i == str.length) {
            for (char a : str) System.out.print(a);
            System.out.println();
        }
        else for (int j = i; j < str.length; j++) {
            swapChar(i,j,str);
            perm(str,i+1);
            swapChar(i,j,str);
        }
    }

    private static void swapChar(int i, int j, char[] str) {
        char a = str[i];
        str[i] = str[j];
        str[j] = a;
    }

    public static void main(String[] args) {
        char[] str = {'a','b','c','d'};
        perm(str,0);
    }
}
