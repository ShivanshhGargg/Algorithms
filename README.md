
# Algorithms — Practical Labs (Regenerated)

This README has been regenerated to present a consistent structure for each practical: Aim, Time Complexity (TC), Space Complexity (SC), Algorithm, Code (only the dedicated function), Use Cases, and Graphs (if present).

Note: code blocks include only the primary function used to demonstrate the algorithm in each lab.

---

## Practical-1: Power of a Number

Aim
- Implement methods to compute x^n using recursion (optimized and simple recursive versions).

TC
- Optimized recursive method: O(log n)
- Simple recursive method: O(n)

SC
- Optimized: O(log n) (call stack)
- Simple: O(n)

Algorithm
- Optimized (divide-and-conquer): compute x^(n/2) and square; multiply by x if n is odd. Handle negative exponents by inversion.
- Simple: multiply x repeatedly n times using recursion.

Code  
```java
// optimized power (divide and conquer)
public static double powerRec(double x, int n) {
    if (n == 0) return 1.0;
    if (n < 0) return 1.0 / powerRec(x, -n);
    double half = powerRec(x, n / 2);
    if (n % 2 == 0) return half * half;
    return x * half * half;
}
```

Use cases
- Fast exponentiation in numerical code, modular exponentiation (with modifications), graphics, simulations.

Graphs
- none

---

## Practical-2: Tower of Hanoi

Aim
- Print sequence of moves to transfer n disks from source to destination using an auxiliary rod.

TC
- O(2^n)

SC
- O(n) (recursion depth)

Algorithm
- Recursive decomposition: move n-1 disks to aux, move largest disk to dest, move n-1 from aux to dest.

Code  
```java
public static void TOH(int n, char src, char dest, char aux) {
    if (n <= 0) return;
    if (n == 1) {
        System.out.println("Move disk 1 from " + src + " to " + dest);
        return;
    }
    TOH(n - 1, src, aux, dest);
    System.out.println("Move disk " + n + " from " + src + " to " + dest);
    TOH(n - 1, aux, dest, src);
}
```

Use cases
- Teaching recursion and algorithmic thinking; puzzle solvers.

Graphs
- none

---

## Practical-3: Permutations of a String

Aim
- Generate all permutations of a string using recursion + backtracking.

TC
- O(n!)

SC
- O(n) (recursion depth)

Algorithm
- Fix char at position i, permute the rest recursively; swap back (backtracking).

Code  
```java
public static void perm(char[] s, int i) {
    if (i == s.length) {
        System.out.println(new String(s));
        return;
    }
    for (int j = i; j < s.length; j++) {
        char tmp = s[i]; s[i] = s[j]; s[j] = tmp;
        perm(s, i + 1);
        tmp = s[i]; s[i] = s[j]; s[j] = tmp;
    }
}
```

Use cases
- Anagrams generation, testing, combinatorial enumeration.

Graphs
- Lab 1/Images: none for this practical

---

## Practical-4: Velocity Reduction Using Recursion

Aim
- Count how many reductions are needed for velocity v to drop below 1 when reducing by a fixed percentage each step.

TC
- O(k) where k is the number of steps until v < 1

SC
- O(k)

Algorithm
- Repeatedly reduce v by a factor (example: reduce by 42.5%) and increment counter until v < 1.

Code  
```java
public static int tips(double v, int t) {
    if (v < 1) return t;
    return tips(v * (1 - 0.425), t + 1);
}
```

Use cases
- Simulations of decay processes, iterative stopping conditions.

Graphs
- none

---

## Practical-5: Horner's Rule Using Recursion

Aim
- Represent/evaluate polynomial using Horner's rule via recursion.

TC
- O(n)

SC
- O(n)

Algorithm
- Build nested expression from coefficients: a0 + x*(a1 + x*(a2 + ...)).

Code  
```java
public static String HR(int i, int[] arr) {
    if (i == arr.length - 1) return Integer.toString(arr[i]);
    return arr[i] + " + x*(" + HR(i + 1, arr) + ")";
}
```

Use cases
- Efficient polynomial evaluation, compiler code generation, numeric libraries.

Graphs
- none

---

## Practical-6: Finding Duplicate in a Consecutive Array

Aim
- Find the duplicate element in an array of consecutive numbers.

TC
- O(n)

SC
- O(1)

Algorithm
- One-pass scan comparing expected value vs actual; return first mismatch/duplicate.

Code  
```java
public static int findDup(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i) return nums[i];
    }
    return -1;
}
```

Use cases
- Data validation in sequences, error detection.

Graphs
- none

---

## Practical-7: Selection Sort Using Recursion

Aim
- Sort an array using recursive selection sort.

TC
- O(n^2)

SC
- O(n) (recursion depth)

Algorithm
- At index i find min from i..n-1, swap with i, recurse for i+1.

Code  
```java
public static void ss(int[] arr, int i) {
    if (i >= arr.length) return;
    int min = i;
    for (int j = i + 1; j < arr.length; j++) if (arr[j] < arr[min]) min = j;
    int tmp = arr[i]; arr[i] = arr[min]; arr[min] = tmp;
    ss(arr, i + 1);
}
```

Use cases
- Educational; small arrays.

Graphs
- Lab 1/Images/graphSS.png

---

## Practical-8: Bubble Sort Using Recursion

Aim
- Sort an array using recursive bubble sort and measure execution time.

TC
- Best: O(n), Average/Worst: O(n^2)

SC
- O(n) (recursion depth)

Algorithm
- Perform one pass swapping adjacent out-of-order elements, then recurse for n-1.

Code  
```java
public static void bb(int[] arr, int n) {
    if (n == 1) return;
    for (int i = 0; i < n - 1; i++) if (arr[i] > arr[i + 1]) {
        int t = arr[i]; arr[i] = arr[i + 1]; arr[i + 1] = t;
    }
    bb(arr, n - 1);
}
```

Use cases
- Teaching basic sorting and algorithm analysis.

Graphs
- Lab 1/Images/graphBB.png

---

## Practical-9: Linear Search Using Recursion

Aim
- Find a target in array using recursive linear search.

TC
- Best: O(1), Average/Worst: O(n)

SC
- O(n)

Algorithm
- Check current index; if not target recurse to next index.

Code  
```java
public static int LS(int[] arr, int target, int i) {
    if (i >= arr.length) return -1;
    if (arr[i] == target) return i;
    return LS(arr, target, i + 1);
}
```

Use cases
- Small data sets, pedagogical examples.

Graphs
- Lab 1/Images/graphLS.png

---

## Practical-10 / Practical-14: Binary Search Using Recursion

Aim
- Search for a target in a sorted array using recursive binary search and measure time.

TC
- Best: O(1), Average/Worst: O(log n)

SC
- O(log n)

Algorithm
- Compare middle element; recurse to left or right half accordingly.

Code  
```java
public static int BS(int[] arr, int t, int s, int e) {
    if (s > e) return -1;
    int m = s + (e - s) / 2;
    if (arr[m] == t) return m;
    if (arr[m] > t) return BS(arr, t, s, m - 1);
    return BS(arr, t, m + 1, e);
}
```

Use cases
- Large sorted datasets, lookups, dictionaries.

Graphs
- Lab 2/Images/BinarySearch.png

---

## Practical-11: Insertion Sort

Aim
- Sort array using insertion sort and measure performance.

TC
- Best: O(n), Average/Worst: O(n^2)

SC
- O(1)

Algorithm
- Insert each element into correct position in sorted prefix.

Code  
```java
public static void IS(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        int key = arr[i]; int j = i - 1;
        while (j >= 0 && arr[j] > key) { arr[j + 1] = arr[j]; j--; }
        arr[j + 1] = key;
    }
}
```

Use cases
- Small nearly-sorted arrays, insertion in online streams.

Graphs
- Lab 2/Images/InsertionSort.png

---

## Practical-12: Merge Sort Using Recursion

Aim
- Sort array using merge sort and measure time for different n.

TC
- O(n log n) all cases

SC
- O(n) (extra array)

Algorithm
- Divide array into halves, sort recursively, merge sorted halves.

Code  
```java
public static void ms(int[] arr, int s, int e) {
    if (s >= e) return;
    int m = s + (e - s) / 2;
    ms(arr, s, m); ms(arr, m + 1, e);
    // merge step (omitted here in full)
}
```

Use cases
- Large datasets, stable sorting needs.

Graphs
- Lab 3/Images/MergeSort.png

---

## Practical-13: Quick Sort Using Recursion

Aim
- Sort using quick sort and observe performance characteristics.

TC
- Best/Average: O(n log n), Worst: O(n^2)

SC
- Average: O(log n) (stack), Worst: O(n)

Algorithm
- Partition around pivot and recurse on partitions.

Code  
```java
public static void qs(int[] arr, int s, int e) {
    if (s >= e) return;
    int pivot = arr[(s + e) / 2];
    int i = s, j = e;
    while (i <= j) {
        while (arr[i] < pivot) i++;
        while (arr[j] > pivot) j--;
        if (i <= j) { int t = arr[i]; arr[i++] = arr[j]; arr[j--] = t; }
    }
    qs(arr, s, j); qs(arr, i, e);
}
```

Use cases
- General-purpose fast in-memory sorting.

Graphs
- Lab 3/Images/QuickSort.png

---

## Practical-15: Permutation (lab 4)

Same as Practical-3 (permutations). Graph: Lab 4/Images/Permutation.png

---

## Practical-16: Iterative Quick Sort

Aim
- Quick sort using an explicit stack instead of recursion.

TC
- O(n log n) average

SC
- O(log n) average for stack

Code  
```java
public static void qsi(int[] arr, int s, int e) {
    java.util.Deque<int[]> stack = new java.util.ArrayDeque<>();
    stack.push(new int[] {s, e});
    while (!stack.isEmpty()) {
        int[] range = stack.pop(); int l = range[0], r = range[1];
        if (l >= r) continue;
        int pivot = arr[(l + r) / 2]; int i = l, j = r;
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) { int t = arr[i]; arr[i++] = arr[j]; arr[j--] = t; }
        }
        if (l < j) stack.push(new int[] {l, j});
        if (i < r) stack.push(new int[] {i, r});
    }
}
```

Graphs
- Lab 4/Images/QuickSort.png

---

## Practical-17: Convex Hull

Aim
- Compute convex hull of planar points (Graham scan / monotone chain style).

TC
- O(n log n)

SC
- O(n)

Code  
```java
public static java.util.List<java.awt.Point> convexHull(java.util.List<java.awt.Point> pts) {
    // sort by x,y then build lower and upper hulls (monotone chain)
    // (implementation omitted for brevity)
    return new java.util.ArrayList<>();
}
```

Graphs
- Lab 5/Images/ConvexHull.png

---

## Practical-18: Fractional Knapsack

Aim
- Maximize value with fractional items (greedy by value/weight ratio).

TC
- O(n log n) (sorting)

SC
- O(1) additional

Code  
```java
public static double knapSack(int W, int[] wt, int[] val) {
    int n = wt.length;
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) idx[i] = i;
    java.util.Arrays.sort(idx, (a,b) -> Double.compare((double)val[b]/wt[b], (double)val[a]/wt[a]));
    double res = 0;
    for (int i : idx) {
        if (W == 0) break;
        int take = Math.min(W, wt[i]);
        res += (double) take * val[i] / wt[i];
        W -= take;
    }
    return res;
}
```

Graphs
- Lab 5/Images/KnapSack.png

---

## Practical-19: K-th Smallest (Quickselect)

Aim
- Find k-th smallest element faster than full sort.

TC
- Average: O(n), Worst: O(n^2)

SC
- O(log n) average

Code  
```java
public static int quickselect(int[] a, int k, int l, int r) {
    if (l == r) return a[l];
    int pivot = a[l + (r - l) / 2];
    int i = l, j = r;
    while (i <= j) {
        while (a[i] < pivot) i++;
        while (a[j] > pivot) j--;
        if (i <= j) { int t = a[i]; a[i++] = a[j]; a[j--] = t; }
    }
    if (k <= j) return quickselect(a, k, l, j);
    if (k >= i) return quickselect(a, k, i, r);
    return a[k];
}
```

Graphs
- Lab 5/Images/KthSmallest.png

---

## Practical-20: Max and Min Using Divide and Conquer

Aim
- Find both min and max in an array using divide-and-conquer.

TC
- O(n)

SC
- O(log n)

Code  
```java
public static int[] max_min(int[] a, int l, int r) {
    if (l == r) return new int[]{a[l], a[l]};
    int m = (l + r) / 2;
    int[] L = max_min(a, l, m);
    int[] R = max_min(a, m+1, r);
    return new int[]{Math.max(L[0], R[0]), Math.min(L[1], R[1])};
}
```

Graphs
- Lab 5/Images/MaxMin.png

---

## Practical-21: Quick Sort on Float Array

Same as Quick Sort but on float[].

Graphs
- Lab 5/Images/QuickSort.png

---

## Practical-22: Dijkstra's Shortest Path

Aim
- Compute shortest paths from single source in weighted graphs with non-negative weights.

TC
- O((V + E) log V) with a priority queue

SC
- O(V)

Code  
```java
public static int[] dijkstra(int[][] graph, int src) {
    int n = graph.length;
    int[] dist = new int[n]; java.util.Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;
    java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<>(java.util.Comparator.comparingInt(a -> a[1]));
    pq.add(new int[]{src, 0});
    while (!pq.isEmpty()) {
        int[] cur = pq.poll(); int u = cur[0], d = cur[1];
        if (d > dist[u]) continue;
        for (int v = 0; v < n; v++) {
            if (graph[u][v] >= 0) {
                int nd = d + graph[u][v];
                if (nd < dist[v]) { dist[v] = nd; pq.add(new int[]{v, nd}); }
            }
        }
    }
    return dist;
}
```

Graphs
- Lab 6/Images/Dijsktra.png

---

## Practical-23: Prim's Algorithm for MST

Aim
- Build MST using Prim's greedy approach.

TC
- O(V^2) (matrix), O(E log V) (with heap)

SC
- O(V)

Code  
```java
public static void prims(int[][] graph) {
    int n = graph.length; boolean[] used = new boolean[n]; int[] dist = new int[n];
    java.util.Arrays.fill(dist, Integer.MAX_VALUE); dist[0] = 0;
    for (int i = 0; i < n; i++) {
        int v = -1;
        for (int j = 0; j < n; j++) if (!used[j] && (v == -1 || dist[j] < dist[v])) v = j;
        used[v] = true;
        for (int to = 0; to < n; to++) if (graph[v][to] >= 0 && graph[v][to] < dist[to]) dist[to] = graph[v][to];
    }
}
```

---

## Practical-24: Kruskal's Algorithm for MST

Aim
- Build MST by sorting edges and using union-find to avoid cycles.

TC
- O(E log E)

SC
- O(V + E)

Code (dedicated function - outline)
```java
public static int kruskal(java.util.List<int[]> edges, int V) {
    edges.sort(java.util.Comparator.comparingInt(a -> a[2]));
    int[] parent = new int[V]; for (int i = 0; i < V; i++) parent[i] = i;
    java.util.function.IntUnaryOperator find = x -> { while (parent[x] != x) x = parent[x]; return x; };
    // union-find steps omitted in README; placeholder return
    return 0;
}
```

---

## Practical-25 / 26 / 27: Multistage Graph — Stage ID, Forward & Backward Methods

Aim
- Identify stages in a directed acyclic multistage graph and compute minimum-cost paths using forward/backward DP.

TC
- O(V^2) for simple matrix-based implementations

SC
- O(V)

Code (dedicated function for forward method outline)
```java
public static int fGraph(int[][] adj, java.util.List<java.util.Set<Integer>> stages) {
    // compute cost[] from rightmost stage to left using dynamic programming
    return 0; // minimal cost
}
```

---

## Practical-28: Matrix Chain Multiplication

Aim
- Find optimal parenthesization minimizing scalar multiplications.

TC
- O(n^3)

SC
- O(n^2)

Code  
```java
public static void matrixChainOrder(int[] p) {
    int n = p.length - 1;
    int[][] m = new int[n+1][n+1];
    for (int L = 2; L <= n; L++) for (int i = 1; i <= n-L+1; i++) {
        int j = i+L-1; m[i][j] = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
            int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
            if (q < m[i][j]) { m[i][j] = q; }
        }
    }
}
```

---

## Practical-29: Floyd-Warshall

Aim
- Compute all-pairs shortest paths.

TC
- O(V^3)

SC
- O(V^2)

Code  
```java
public static void floydWarshall(int[][] dist) {
    int n = dist.length;
    for (int k = 0; k < n; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (dist[i][k] + dist[k][j] < dist[i][j])
                    dist[i][j] = dist[i][k] + dist[k][j];
}
```

Graphs
- Lab 9/Images/FloydWarshall.png

---

## Practical-30 / 31: Traveling Salesman (Backtracking & DP)

Backtracking Code  
```java
public int tspBacktrack(int[][] cost) {
    int n = cost.length; boolean[] vis = new boolean[n]; vis[0] = true; return DFS(vis, cost, 0, 1);
}
private int DFS(boolean[] vis, int[][] cost, int u, int cnt) {
    int n = cost.length; if (cnt == n) return cost[u][0];
    int best = Integer.MAX_VALUE;
    for (int v = 1; v < n; v++) if (!vis[v]) { vis[v]=true; best = Math.min(best, cost[u][v] + DFS(vis, cost, v, cnt+1)); vis[v]=false; }
    return best;
}
```

DP Code  
```java
public static int tspDP(int n, int[][] cost) {
    final int INF = Integer.MAX_VALUE/4;
    int VIS = 1<<n; int[][] dp = new int[VIS][n];
    for (int[] row: dp) java.util.Arrays.fill(row, INF);
    dp[1][0] = 0;
    for (int mask = 1; mask < VIS; mask++) for (int u = 0; u < n; u++) if ((mask & (1<<u))!=0) {
        for (int v = 0; v < n; v++) if ((mask & (1<<v))==0) dp[mask | (1<<v)][v] = Math.min(dp[mask | (1<<v)][v], dp[mask][u] + cost[u][v]);
    }
    int ans = INF; for (int i = 0; i < n; i++) ans = Math.min(ans, dp[VIS-1][i] + cost[i][0]);
    return ans;
}
```

Use cases
- Route planning, logistics, small TSP instances.

---

## Practical-32: Graph Coloring

Code  
```java
static boolean isSafe(int v, int c, int[][] graph, int[] color, int n) {
    for (int i = 0; i < n; i++) if (graph[v][i] == 1 && color[i] == c) return false;
    return true;
}
```

Use cases
- Register allocation, scheduling, frequency assignment.

---

## Practical-33: Hamiltonian Cycle

Code  
```java
static void nextValue(int k, int[][] graph, int[] x, int n) { /* see lab code */ }
static void hamiltonian(int k, int[][] graph, int[] x, int n) { /* see lab code */ }
```

---

## Practical-34: N-Queens

Code  
```java
public static void solveNQueens(int k, int[] x, int n) {
    if (k == n) { /* record solution */ return; }
    for (int i = 0; i < n; i++) if (isSafe(k, i, x)) { x[k] = i; solveNQueens(k+1, x, n); }
}
```

---

## Practical-35: Sum of Subsets

Code  
```java
public static void sumOfSubsets(int s, int k, int r, int[] w, int[] x, int n, int W) {
    if (k < n) {
        x[k] = 1;
        if (s + w[k] == W) { System.out.println("Found subset"); }
        else if (k+1 < n && s + w[k] + w[k+1] <= W) sumOfSubsets(s + w[k], k+1, r - w[k], w, x, n, W);
        if (k+1 < n && s + r - w[k] >= W && s + w[k+1] <= W) { x[k] = 0; sumOfSubsets(s, k+1, r - w[k], w, x, n, W); }
    }
}
```

Graphs
- none for this lab

---

If you'd like, I can:
- Expand any function into a complete, runnable Java class with a main() and sample inputs.
- Generate separate short READMEs per lab folder (e.g., `Lab 1/README.md`) using the same template.
- Produce a table of contents at the top linking to each practical.

Changes applied: full README replaced with the regenerated structured document described above.

