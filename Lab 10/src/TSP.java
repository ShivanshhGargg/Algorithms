public class TSP {
    public int tsp(int[][] cost) {
        int n = cost.length;
        boolean[] city = new boolean[n];
        city[0] = true;
        return DFS(city,cost,0,1);
    }

    public int DFS(boolean[] vis,int[][] cost, int start, int count) {
        int n = cost.length;
        if (n == count)return cost[start][0];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (!vis[i]){
                vis[i] = true;
                min = Math.min(min,cost[start][i] + DFS(vis,cost,i,count+1));
                vis[i] = false;
            }
        }
        return min;
    }
    public static void main(String[] args) {

    }
}
