# Algorithms — Practical Labs

## Practical-1: Power of a Number

### Aim
Implement methods to compute \( x^n \) using recursion (optimized and simple recursive versions).

---

### Algorithm (Optimized - Divide and Conquer)

**Algorithm: POWER(x, n)**

1. If \( n = 0 \), return 1
2. If \( n < 0 \), return \( 1 / POWER(x, -n) \)
3. Compute \( y = POWER(x, n/2) \)
4. If \( n \) is even, return \( y \times y \)
5. Else return \( x \times y \times y \)

---

### Algorithm (Simple Recursive)

**Algorithm: SIMPLE-POWER(x, n)**

1. If \( n = 0 \), return 1
2. Else return \( x \times SIMPLE\text{-}POWER(x, n-1) \)

---

### Time Complexity (TC)
- Optimized: \( O(\log n) \)
- Simple: \( O(n) \)

---

### Space Complexity (SC)
- Optimized: \( O(\log n) \)
- Simple: \( O(n) \)

---

### Code    

```java
public static double powerRec(double x, int n) {
    if (n == 0) return 1.0;
    if (n < 0) return 1.0 / powerRec(x, -n);
    double half = powerRec(x, n / 2);
    if (n % 2 == 0) return half * half;
    return x * half * half;
}
```

---

### Use Cases
- Fast exponentiation
- Graphics computations
- Simulations
- Modular exponentiation (with modifications)
---

## Practical-2: Tower of Hanoi

### Aim
Print the sequence of moves to transfer `n` disks from source to destination using an auxiliary rod.

---

### Algorithm (Recursive)

**Algorithm: TOH(n, src, dest, aux)**

1. If \( n \leq 0 \), return
2. If \( n = 1 \),
  - Print "Move disk 1 from src to dest"
  - Return
3. Call \( TOH(n-1, src, aux, dest) \)
4. Print "Move disk n from src to dest"
5. Call \( TOH(n-1, aux, dest, src) \)

---

### Time Complexity (TC)
- \( O(2^n) \)

---

### Space Complexity (SC)
- \( O(n) \) (recursion stack)

---

### Code    

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

---

### Use Cases
- Understanding recursion deeply
- Algorithm design using divide-and-conquer
- Puzzle solving and state transitions
---
## Practical-3: Permutations of a String

### Aim
Generate all permutations of a string using recursion and backtracking.

---

### Algorithm (Backtracking)

**Algorithm: PERM(s, i)**

1. If \( i = n \),
  - Output the current permutation of string \( s \)
  - Return
2. For \( j = i \) to \( n-1 \):
  - Swap \( s[i] \) and \( s[j] \)
  - Call \( PERM(s, i+1) \)
  - Swap back \( s[i] \) and \( s[j] \) (backtracking)

---

### Time Complexity (TC)
- \( O(n!) \)

---

### Space Complexity (SC)
- \( O(n) \) (recursion depth)

---

### Code    

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

---

### Use Cases
- Anagram generation
- Combinatorial problems
- Testing all possible arrangements

---
### Graphs
![Permutation Graph](Lab%204/Images/Permutation.png)

---
## Practical-4: Velocity Reduction Using Recursion

### Aim
Count the number of steps required for a velocity \( v \) to drop below 1 when reduced by a fixed percentage at each step.

---

### Algorithm (Recursive Reduction)

**Algorithm: TIPS(v, t)**

1. If \( v < 1 \), return \( t \)
2. Set \( v = v \times (1 - r) \) where \( r \) is reduction rate
3. Return \( TIPS(v, t+1) \)

---

### Time Complexity (TC)
- \( O(k) \), where \( k \) is number of reductions

---

### Space Complexity (SC)
- \( O(k) \)

---

### Code    

```java
public static int tips(double v,int t){
    if (v>=1){
        t++;
        v = v - (0.425 * v);
        return tips(v,t);
    }
    else return t;
}
```

---

### Use Cases
- Decay simulations
- Physics-based modeling
- Iterative threshold problems
---
## Practical-5: Horner's Rule Using Recursion

### Aim
Represent and evaluate a polynomial using Horner's Rule via recursion.

---

### Algorithm (Recursive Horner's Rule)

**Algorithm: HR(i, arr)**

1. If \( i = n-1 \), return \( arr[i] \)
2. Return \( arr[i] + x \times HR(i+1, arr) \)

---

### Time Complexity (TC)
- \( O(n) \)

---

### Space Complexity (SC)
- \( O(n) \)

---

### Code    

```java
public static String HR(int i, int[] arr) {
    if (i == arr.length - 1) return Integer.toString(arr[i]);
    return arr[i] + " + x*(" + HR(i + 1, arr) + ")";
}
```

---

### Use Cases
- Polynomial evaluation
- Compiler optimizations
- Numerical computations

---

## Practical-6: Finding Duplicate in a Consecutive Array

### Aim
Find the duplicate element in an array containing consecutive integers.

---

### Algorithm (Linear Scan)

**Algorithm: FIND-DUP(nums)**

1. For \( i = 0 \) to \( n-1 \):
  - If \( nums[i] \neq i \), return \( nums[i] \)
2. Return -1

---

### Time Complexity (TC)
- \( O(n) \)

---

### Space Complexity (SC)
- \( O(1) \)

---

### Code    

```java
public static int findDup(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i) return nums[i];
    }
    return -1;
}
```

---

### Use Cases
- Data validation
- Detecting anomalies in sequences

---

## Practical-7: Selection Sort Using Recursion

### Aim
Sort an array using recursive selection sort.

---

### Algorithm (Recursive Selection Sort)

**Algorithm: SS(arr, i)**

1. If \( i \geq n \), return
2. Find index of minimum element in \( arr[i \dots n-1] \)
3. Swap \( arr[i] \) with minimum element
4. Call \( SS(arr, i+1) \)

---

### Time Complexity (TC)
- \( O(n^2) \)

---

### Space Complexity (SC)
- \( O(n) \)

---

### Code    

```java
public static void ss(int[] arr, int i) {
    if (i >= arr.length) return;
    int min = i;
    for (int j = i + 1; j < arr.length; j++) 
        if (arr[j] < arr[min]) min = j;

    int tmp = arr[i]; 
    arr[i] = arr[min]; 
    arr[min] = tmp;

    ss(arr, i + 1);
}
```

---

### Use Cases
- Learning sorting fundamentals
- Small datasets where simplicity matters  

Graphs
![Selection Sort Time Complexity Graph](Lab%201/Images/Selection.png)

---
## Practical-8: Bubble Sort Using Recursion

### Aim
Sort an array using recursive bubble sort and measure execution time.

---

### Algorithm (Recursive Bubble Sort)

**Algorithm: BB(arr, n)**

1. If \( n = 1 \), return
2. For \( i = 0 \) to \( n-2 \):
  - If \( arr[i] > arr[i+1] \), swap them
3. Call \( BB(arr, n-1) \)

---

### Time Complexity (TC)
- Best: \( O(n) \)
- Average/Worst: \( O(n^2) \)

---

### Space Complexity (SC)
- \( O(n) \)

---

### Code    

```java
public static void bb(int[] arr, int n) {
    if (n == 1) return;
    for (int i = 0; i < n - 1; i++) 
        if (arr[i] > arr[i + 1]) {
            int t = arr[i]; 
            arr[i] = arr[i + 1]; 
            arr[i + 1] = t;
        }
    bb(arr, n - 1);
}
```

---

### Use Cases
- Teaching sorting basics
- Understanding algorithm complexity

---

### Graphs
![Bubble Sort Time Complexity Graph](Lab%201/Images/Bubble.png)

---

## Practical-9: Linear Search Using Recursion

### Aim
Find a target element in an array using recursive linear search.

---

### Algorithm (Recursive Linear Search)

**Algorithm: LS(arr, target, i)**

1. If \( i \geq n \), return -1
2. If \( arr[i] = target \), return \( i \)
3. Return \( LS(arr, target, i+1) \)

---

### Time Complexity (TC)
- Best: \( O(1) \)
- Average/Worst: \( O(n) \)

---

### Space Complexity (SC)
- \( O(n) \)

---

### Code    

```java
public static int LS(int[] arr, int target, int i) {
    if (i >= arr.length) return -1;
    if (arr[i] == target) return i;
    return LS(arr, target, i + 1);
}
```

---

### Use Cases
- Small datasets
- Basic searching problems

---

### Graphs
![Linear Search Time Complexity Graph](Lab%201/Images/Linear.png)

---

## Practical-10: Binary Search Using Recursion

### Aim
Search for a target in a sorted array using recursive binary search and measure execution time.

---

### Algorithm (Recursive Binary Search)

**Algorithm: BS(arr, t, s, e)**

1. If \( s > e \), return -1
2. Compute \( m = \lfloor (s+e)/2 \rfloor \)
3. If \( arr[m] = t \), return \( m \)
4. If \( arr[m] > t \), return \( BS(arr, t, s, m-1) \)
5. Else return \( BS(arr, t, m+1, e) \)

---

### Time Complexity (TC)
- Best: \( O(1) \)
- Average/Worst: \( O(\log n) \)

---

### Space Complexity (SC)
- \( O(\log n) \)

---

### Code    

```java
public static int BS(int[] arr, int t, int s, int e) {
    if (s > e) return -1;
    int m = s + (e - s) / 2;
    if (arr[m] == t) return m;
    if (arr[m] > t) return BS(arr, t, s, m - 1);
    return BS(arr, t, m + 1, e);
}
```

---

### Use Cases
- Efficient searching in sorted data
- Databases and lookup systems

---

### Graphs
![Binary Search Time Complexity Graph](Lab%202/Images/BinarySearch.png)

---
## Practical-11: Insertion Sort

### Aim
Sort an array using insertion sort and measure performance.

---

### Algorithm (Insertion Sort)

**Algorithm: IS(arr)**

1. For \( i = 1 \) to \( n-1 \):
    - Set \( key = arr[i] \)
    - Set \( j = i-1 \)
    - While \( j \geq 0 \) and \( arr[j] > key \):
        - Shift \( arr[j] \) to \( arr[j+1] \)
        - Decrement \( j \)
    - Insert \( key \) at position \( j+1 \)

---

### Time Complexity (TC)
- Best: \( O(n) \)
- Average/Worst: \( O(n^2) \)

---

### Space Complexity (SC)
- \( O(1) \)

---

### Code    

```java
public static void IS(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        int key = arr[i]; 
        int j = i - 1;
        while (j >= 0 && arr[j] > key) { 
            arr[j + 1] = arr[j]; 
            j--; 
        }
        arr[j + 1] = key;
    }
}
```

---

### Use Cases
- Small datasets
- Nearly sorted arrays
- Online/incremental sorting

---

### Graphs
![Insertion Sort Time Complexity Graph](Lab%202/Images/InsertionSort.png)

---
## Practical-12: Merge Sort Using Recursion

### Aim
Sort an array using merge sort and analyze performance for different input sizes.

---

### Algorithm (Divide and Conquer)

**Algorithm: MS(arr, s, e)**

1. If \( s \geq e \), return
2. Compute \( m = \lfloor (s+e)/2 \rfloor \)
3. Call \( MS(arr, s, m) \)
4. Call \( MS(arr, m+1, e) \)
5. Merge the two sorted halves

---

### Time Complexity (TC)
- \( O(n \log n) \) (all cases)

---

### Space Complexity (SC)
- \( O(n) \)

---

### Code    

```java
public static void ms(int[] arr, int s, int e) {
    if (s >= e) return;
    int m = s + (e - s) / 2;

    ms(arr, s, m); 
    ms(arr, m + 1, e);

    merge(arr, s, m, e);
}

public static void merge(int[] arr, int s, int m, int e) {
    int[] temp = new int[e - s + 1];
    int i = s, j = m + 1, k = 0;

    while (i <= m && j <= e) {
        if (arr[i] <= arr[j]) temp[k++] = arr[i++];
        else temp[k++] = arr[j++];
    }

    while (i <= m) temp[k++] = arr[i++];
    while (j <= e) temp[k++] = arr[j++];

    for (int x = 0; x < temp.length; x++) {
        arr[s + x] = temp[x];
    }
}
```

---

### Use Cases
- Large datasets
- Stable sorting requirements
- External sorting systems

---

Graphs
![Merge Sort Time Complexity Graph](Lab%203/Images/MergeSort.png)

---
## Practical-13: Quick Sort Using Recursion

### Aim
Sort using quick sort and observe performance characteristics.

---

### Algorithm (Divide and Conquer)

**Algorithm: QS(arr, s, e)**

1. If \( s \geq e \), return
2. Choose pivot element
3. Partition array such that:
    - Elements < pivot on left
    - Elements > pivot on right
4. Recursively apply on left and right partitions

---

### Time Complexity (TC)
- Best/Average: \( O(n \log n) \)
- Worst: \( O(n^2) \)

---

### Space Complexity (SC)
- Average: \( O(\log n) \)
- Worst: \( O(n) \)

---

### Code    

```java
public static void qs(int[] arr, int s, int e) {
    if (s >= e) return;

    int pivot = arr[(s + e) / 2];
    int i = s, j = e;

    while (i <= j) {
        while (arr[i] < pivot) i++;
        while (arr[j] > pivot) j--;
        if (i <= j) { 
            int t = arr[i]; 
            arr[i++] = arr[j]; 
            arr[j--] = t; 
        }
    }

    qs(arr, s, j); 
    qs(arr, i, e);
}
```

---

### Use Cases
- General-purpose in-memory sorting
- High-performance applications

---

### Graphs
![Quick Sort Time Complexity Graph](Lab%203/Images/QuickSort.png)

---
## Practical-14: Iterative Quick Sort

### Aim
Implement quick sort using an explicit stack instead of recursion.

---

### Algorithm (Iterative using Stack)

**Algorithm: QSI(arr, s, e)**

1. Initialize stack and push \( (s, e) \)
2. While stack is not empty:
    - Pop range \( (l, r) \)
    - Partition array around pivot
    - Push left and right subarrays onto stack if valid

---

### Time Complexity (TC)
- Average: \( O(n \log n) \)

---

### Space Complexity (SC)
- Average: \( O(\log n) \)

---

### Code    

```java
public static void qsi(int[] arr, int s, int e) {
    java.util.Deque<int[]> stack = new java.util.ArrayDeque<>();
    stack.push(new int[] {s, e});

    while (!stack.isEmpty()) {
        int[] range = stack.pop(); 
        int l = range[0], r = range[1];

        if (l >= r) continue;

        int pivot = arr[(l + r) / 2];
        int i = l, j = r;

        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) { 
                int t = arr[i]; 
                arr[i++] = arr[j]; 
                arr[j--] = t; 
            }
        }

        if (l < j) stack.push(new int[] {l, j});
        if (i < r) stack.push(new int[] {i, r});
    }
}
```
---

### Graphs
![Quick Sort (Iterative) Time Complexity Graph](Lab%204/Images/QuickSort.png)

---
## Practical-15: Convex Hull

### Aim
Compute the convex hull of a set of planar points using monotone chain (or Graham scan style).

---

### Algorithm (Monotone Chain)

**Algorithm: CONVEX-HULL(points)**

1. Sort points by x-coordinate, then by y-coordinate
2. Build lower hull:
    - For each point, remove last point while it makes a non-left turn
3. Build upper hull similarly in reverse order
4. Concatenate lower and upper hulls

---

### Time Complexity (TC)
- \( O(n \log n) \)

---

### Space Complexity (SC)
- \( O(n) \)

---

### Code    

```java
public static List<Point> convexHull(List<Point> points) {
    int n = points.size();
    if (n < 3) return points;

    Point p0 = points.get(0);
    for (Point p : points) {
        if (p.y < p0.y || (p.y == p0.y && p.x < p0.x)) {
            p0 = p;
        }
    }

    Point finalP0 = p0;

    points.sort((a, b) -> {
        double o = orientation(finalP0, a, b);
        if (o == 0)
            return Double.compare(distSq(finalP0, a), distSq(finalP0, b));
        return (o > 0) ? -1 : 1;
    });

    Stack<Point> stack = new Stack<>();
    stack.push(points.get(0));
    stack.push(points.get(1));
    stack.push(points.get(2));

    for (int i = 3; i < n; i++) {
        while (stack.size() > 1 &&
                orientation(nextToTop(stack), stack.peek(), points.get(i)) <= 0) {
            stack.pop();
        }
        stack.push(points.get(i));
    }

    return new ArrayList<>(stack);
}
```

---
### Graphs
![Convex Hull Time Complexity Graph](Lab%205/Images/ConvexHull.png)

---
## Practical-16: Fractional Knapsack

### Aim
Maximize value in a knapsack allowing fractional items using a greedy approach.

---

### Algorithm (Greedy)

**Algorithm: KNAPSACK(W, wt, val)**

1. Compute value/weight ratio for each item
2. Sort items in decreasing order of ratio
3. For each item:
    - Take as much as possible (fully or fractionally)
    - Reduce remaining capacity \( W \)
4. Return total value

---

### Time Complexity (TC)
- \( O(n \log n) \)

---

### Space Complexity (SC)
- \( O(1) \) (excluding input)

---

### Code    

```java
public static double knapSack(int W, int[] wt, int[] val) {
    int n = wt.length;
    Integer[] idx = new Integer[n];

    for (int i = 0; i < n; i++) idx[i] = i;

    java.util.Arrays.sort(idx, 
        (a, b) -> Double.compare((double)val[b]/wt[b], (double)val[a]/wt[a])
    );

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

---

### Graphs
![Fractional Knapsack Time Complexity Graph](Lab%205/Images/KnapSack.png)

---
## Practical-17: K-th Smallest (Quickselect)

### Aim
Find the k-th smallest element in an array more efficiently than full sorting.

---

### Algorithm (Quickselect)

**Algorithm: QUICKSELECT(a, k, l, r)**

1. If \( l = r \), return \( a[l] \)
2. Choose a pivot element
3. Partition the array such that:
    - Elements < pivot on left
    - Elements > pivot on right
4. If \( k \leq j \), recurse on left partition
5. If \( k \geq i \), recurse on right partition
6. Else return \( a[k] \)

---

### Time Complexity (TC)
- Average: \( O(n) \)
- Worst: \( O(n^2) \)

---

### Space Complexity (SC)
- Average: \( O(\log n) \)

---

### Code    

```java
public static int quickselect(int[] a, int k, int l, int r) {
    if (l == r) return a[l];

    int pivot = a[l + (r - l) / 2];
    int i = l, j = r;

    while (i <= j) {
        while (a[i] < pivot) i++;
        while (a[j] > pivot) j--;
        if (i <= j) { 
            int t = a[i]; 
            a[i++] = a[j]; 
            a[j--] = t; 
        }
    }

    if (k <= j) return quickselect(a, k, l, j);
    if (k >= i) return quickselect(a, k, i, r);

    return a[k];
}
```

---

### Graphs
![K-th Smallest Time Complexity Graph](Lab%205/Images/KthSmallest.png)

---
## Practical-18: Max and Min Using Divide and Conquer

### Aim
Find both maximum and minimum elements in an array using divide-and-conquer.

---

### Algorithm (Divide and Conquer)

**Algorithm: MAX-MIN(a, l, r)**

1. If \( l = r \), return \( (a[l], a[l]) \)
2. Compute \( m = \lfloor (l+r)/2 \rfloor \)
3. Find \( (max_1, min_1) = MAX\text{-}MIN(a, l, m) \)
4. Find \( (max_2, min_2) = MAX\text{-}MIN(a, m+1, r) \)
5. Return:
    - \( \max(max_1, max_2) \)
    - \( \min(min_1, min_2) \)

---

### Time Complexity (TC)
- \( O(n) \)

---

### Space Complexity (SC)
- \( O(\log n) \)

---

### Code    

```java
public static int[] max_min(int[] a, int l, int r) {
    if (l == r) return new int[]{a[l], a[l]};

    int m = (l + r) / 2;

    int[] L = max_min(a, l, m);
    int[] R = max_min(a, m + 1, r);

    return new int[]{
        Math.max(L[0], R[0]),
        Math.min(L[1], R[1])
    };
}
```

---

### Graphs
![Max-Min Time Complexity Graph](Lab%205/Images/MaxMin.png)

---
## Practical-19: Dijkstra's Shortest Path

### Aim
Compute shortest paths from a single source in a weighted graph with non-negative weights.

---

### Algorithm (Greedy with Priority Queue)

**Algorithm: DIJKSTRA(graph, src)**

1. Initialize distance array with infinity, set \( dist[src] = 0 \)
2. Use a priority queue to select node with minimum distance
3. For each adjacent vertex:
    - Update distance if a shorter path is found
4. Repeat until all vertices are processed

---

### Time Complexity (TC)
- \( O((V + E) \log V) \)

---

### Space Complexity (SC)
- \( O(V) \)

---

### Code    

```java
public static int[] dijkstra(int[][] graph, int src) {
    int n = graph.length;

    int[] dist = new int[n];
    java.util.Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    java.util.PriorityQueue<int[]> pq = 
        new java.util.PriorityQueue<>(java.util.Comparator.comparingInt(a -> a[1]));

    pq.add(new int[]{src, 0});

    while (!pq.isEmpty()) {
        int[] cur = pq.poll(); 
        int u = cur[0], d = cur[1];

        if (d > dist[u]) continue;

        for (int v = 0; v < n; v++) {
            if (graph[u][v] >= 0) {
                int nd = d + graph[u][v];
                if (nd < dist[v]) { 
                    dist[v] = nd; 
                    pq.add(new int[]{v, nd}); 
                }
            }
        }
    }
    return dist;
}
```

---

### Graphs
![Dijkstra's Shortest Path Time Complexity Graph](Lab%206/Images/Dijsktra.png)

---
## Practical-20: Prim's Algorithm for MST

### Aim
Construct a Minimum Spanning Tree using Prim's greedy approach.

---

### Algorithm (Greedy)

**Algorithm: PRIMS(graph)**

1. Initialize all vertices as not included in MST
2. Start from any vertex (e.g., 0)
3. Select minimum weight edge connecting MST to a new vertex
4. Add selected vertex to MST
5. Repeat until all vertices are included

---

### Time Complexity (TC)
- \( O(V^2) \) (matrix)
- \( O(E \log V) \) (with heap)

---

### Space Complexity (SC)
- \( O(V) \)

---

### Code    

```java
public static void prims(int[][] graph) {
    int n = graph.length;

    boolean[] used = new boolean[n];
    int[] dist = new int[n];

    java.util.Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;

    for (int i = 0; i < n; i++) {
        int v = -1;

        for (int j = 0; j < n; j++) 
            if (!used[j] && (v == -1 || dist[j] < dist[v])) 
                v = j;

        used[v] = true;

        for (int to = 0; to < n; to++) 
            if (graph[v][to] >= 0 && graph[v][to] < dist[to]) 
                dist[to] = graph[v][to];
    }
}
```

---

## Practical-21: Kruskal's Algorithm for MST

### Aim
Construct a Minimum Spanning Tree by sorting edges and avoiding cycles using union-find.

---

### Algorithm (Greedy + Union-Find)

**Algorithm: KRUSKAL(edges, V)**

1. Sort all edges by weight
2. Initialize disjoint sets for all vertices
3. For each edge:
    - If it connects two different sets, include it in MST
    - Union the sets
4. Repeat until MST has \( V-1 \) edges

---

### Time Complexity (TC)
- \( O(E \log E) \)

---

### Space Complexity (SC)
- \( O(V + E) \)

---

### Code    

```java
public static void kruskal(List<Edge> edges, int n) {
    edges.sort((a, b) -> a.w - b.w);

    parent = new int[n];
    Arrays.fill(parent, -1);

    int cost = 0;
    int count = 0;

    for (Edge e : edges) {
        if (find(e.u) != find(e.v)) {
            union(e.u, e.v);
            cost += e.w;
            count++;
        }
    }

    if (count != n - 1) {
        System.out.println("Graph is not connected, MST not possible");
        return;
    }
}
```

**Reference:** See `Lab 6/src/Kruskals.java` for the full implementation.

---
### Graphs
![Kruskal's MST Time Complexity Graph](Lab%206/Images/Kruskal.png)

---
## Practical-22: Stage Construction in Multistage Graph

### Aim
Construct stages of a multistage graph from a given adjacency matrix.

---

### Algorithm

**Algorithm: FIND-STAGE(graph)**

1. Initialize first stage with source vertex (0)
2. Mark it visited
3. For each stage:
    - Explore adjacent unvisited vertices
    - Add them to next stage
4. Repeat until no new vertices are found

---

### Time Complexity (TC)
- \( O(V^2) \)

---

### Space Complexity (SC)
- \( O(V) \)

---

### Code 

```java
static List<Set<Integer>> s;
static int INF = 10000000;

private static void findStage(int[][] g) {
    s = new ArrayList<>();
    boolean[] visited = new boolean[g.length];

    Set<Integer> t = new HashSet<>();
    t.add(0);
    visited[0] = true;
    s.add(t);

    int i = 0;

    while (i < s.size()) {
        Set<Integer> st = new HashSet<>();
        for (int e : s.get(i)) {
            for (int j = 0; j < g.length; j++) {
                if (g[e][j] != 0 && g[e][j] != INF && !visited[j]) {
                    st.add(j);
                    visited[j] = true;
                }
            }
        }
        if (!st.isEmpty()) s.add(st);
        i++;
    }
}
```

---

### Use Cases
- Layered graph construction
- Preprocessing for multistage shortest path
- DAG structuring

---

## Practical-23: Multistage Graph (Backward Approach)

### Aim
Find shortest path in a multistage graph using backward approach.

---

### Algorithm

**Algorithm: BACKWARD-MS(graph)**

1. Construct stages
2. Initialize cost[source] = 0
3. Traverse stage-wise
4. Relax edges between consecutive stages
5. Track parent to reconstruct path

---

### Time Complexity (TC)
- \( O(V^2) \)

---

### Space Complexity (SC)
- \( O(V) \)

---

### Code    

```java
private static void bGraph(int[][] graph) {
    findStage(graph);

    int n = graph.length;
    int stages = s.size();

    int[] cost = new int[n];
    int[] parent = new int[n];

    Arrays.fill(cost, INF);
    cost[0] = 0;

    for (int i = 0; i < stages - 1; i++) {
        List<Integer> curr = new ArrayList<>(s.get(i));
        List<Integer> next = new ArrayList<>(s.get(i + 1));

        for (int u : curr) {
            for (int v : next) {
                if (graph[u][v] != INF) {
                    if (cost[v] > cost[u] + graph[u][v]) {
                        cost[v] = cost[u] + graph[u][v];
                        parent[v] = u;
                    }
                }
            }
        }
    }
}
```

---

### Use Cases
- Shortest path in staged graphs
- Network optimization
- DAG-based DP problems

---

## Practical-24: Multistage Graph (Forward Approach)

### Aim
Find shortest path in a multistage graph using forward dynamic programming.

---

### Algorithm

**Algorithm: FORWARD-MS(graph)**

1. Construct stages
2. Initialize cost[destination] = 0
3. Traverse stages backward
4. Compute minimum cost using next stage
5. Store decisions for path reconstruction

---

### Time Complexity (TC)
- \( O(V^2) \)

---

### Space Complexity (SC)
- \( O(V) \)

---

### Code    

```java
private static void fGraph(int[][] graph) {
    findStage(graph);

    int n = graph.length;
    int stages = s.size();

    int[] cost = new int[n];
    int[] d = new int[n];

    Arrays.fill(cost, INF);
    cost[n - 1] = 0;

    for (int i = stages - 2; i >= 0; i--) {
        List<Integer> curr = new ArrayList<>(s.get(i));
        List<Integer> next = new ArrayList<>(s.get(i + 1));

        for (int u : curr) {
            for (int v : next) {
                if (graph[u][v] != INF) {
                    if (cost[u] > graph[u][v] + cost[v]) {
                        cost[u] = graph[u][v] + cost[v];
                        d[u] = v;
                    }
                }
            }
        }
    }
}
```

---

### Use Cases
- Dynamic programming on DAGs
- Decision optimization problems
- Multistage shortest path

---
## Practical-25: Matrix Chain Multiplication

### Aim
Find the optimal parenthesization of matrices to minimize scalar multiplications.

---

### Algorithm (Dynamic Programming)

**Algorithm: MATRIX-CHAIN(p)**

1. Let \( n = length(p) - 1 \)
2. Initialize \( m[i][i] = 0 \)
3. For chain length \( L = 2 \) to \( n \):
    - For \( i = 1 \) to \( n-L+1 \):
        - Set \( j = i + L - 1 \)
        - Set \( m[i][j] = \infty \)
        - For \( k = i \) to \( j-1 \):
            - Compute cost
            - Update minimum value

---

### Time Complexity (TC)
- \( O(n^3) \)

---

### Space Complexity (SC)
- \( O(n^2) \)

---

### Code    

```java
public static void matrixChainOrder(int[] p) {
    int n = p.length - 1;
    int[][] m = new int[n+1][n+1];

    for (int L = 2; L <= n; L++) 
        for (int i = 1; i <= n - L + 1; i++) {
            int j = i + L - 1;
            m[i][j] = Integer.MAX_VALUE;

            for (int k = i; k <= j - 1; k++) {
                int q = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j];
                if (q < m[i][j]) m[i][j] = q;
            }
        }
}
```

---

### Use Cases
- Optimizing matrix operations in scientific computing
- Compiler optimization (expression evaluation order)
- Graphics transformations

---
### Graphs
![Matrix Chain Multiplication Time Complexity Graph](Lab%208/Images/MCM.png)

---
## Practical-26: Floyd-Warshall

### Aim
Compute shortest paths between all pairs of vertices.

---

### Algorithm (Dynamic Programming)

**Algorithm: FLOYD-WARSHALL(dist)**

1. For each vertex \( k \):
2. For each pair \( (i, j) \):
    - Update \( dist[i][j] = \min(dist[i][j], dist[i][k] + dist[k][j]) \)

---

### Time Complexity (TC)
- \( O(V^3) \)

---

### Space Complexity (SC)
- \( O(V^2) \)

---

### Code    

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

---

### Use Cases
- Network routing protocols
- Shortest path in dense graphs
- Transitive closure (reachability problems)

---

### Graphs
![Floyd-Warshall All-Pairs Shortest Path Graph](Lab%209/Images/FloydWarshall.png)

---

## Practical-27: Traveling Salesman Problem (Dynamic Programming)

### Aim
Solve TSP efficiently using Dynamic Programming (Bitmasking).

---

### Algorithm (DP with Bitmasking)

**Algorithm: TSP-DP(n, cost)**

1. Use bitmask to represent visited cities
2. Initialize DP table
3. Iterate over all subsets of cities
4. Update minimum cost for each subset
5. Return minimum cost including return to source

---

### Time Complexity (TC)
- \( O(n^2 \cdot 2^n) \)

---

### Space Complexity (SC)
- \( O(n \cdot 2^n) \)

---

### Code    

```java
public static int tspDP(int n, int[][] cost) {
    final int INF = Integer.MAX_VALUE / 4;

    int VIS = 1 << n; 
    int[][] dp = new int[VIS][n];

    for (int[] row : dp) java.util.Arrays.fill(row, INF);
    dp[1][0] = 0;

    for (int mask = 1; mask < VIS; mask++) 
        for (int u = 0; u < n; u++) 
            if ((mask & (1 << u)) != 0) {
                for (int v = 0; v < n; v++) 
                    if ((mask & (1 << v)) == 0) 
                        dp[mask | (1 << v)][v] = Math.min(
                            dp[mask | (1 << v)][v], 
                            dp[mask][u] + cost[u][v]
                        );
            }

    int ans = INF; 
    for (int i = 0; i < n; i++) 
        ans = Math.min(ans, dp[VIS - 1][i] + cost[i][0]);

    return ans;
}
```

---

### Use Cases
- Logistics and route planning
- Circuit design
- Optimization problems with constraints

---

## Practical-28: Graph Coloring

### Aim
Assign colors to vertices such that no two adjacent vertices share the same color.

---

### Algorithm (Backtracking)

**Algorithm: GRAPH-COLORING(graph, m)**

1. Assign colors one by one to vertices
2. Check if current color assignment is safe
3. If safe, recurse for next vertex
4. If all vertices are colored, solution found

---

### Time Complexity (TC)
- Exponential in worst case

---

### Space Complexity (SC)
- \( O(n) \)

---

### Code    

```java
static boolean isSafe(int v, int c, int[][] graph, int[] color, int n) {
    for (int i = 0; i < n; i++) 
        if (graph[v][i] == 1 && color[i] == c) 
            return false;
    return true;
}
static void solve(int v, int[][] graph, int[] color, int n, int m) {
    if (v == n) {
        for (int i = 0; i < n; i++) System.out.print(color[i] + " ");
        System.out.println();
        return;
    }

    for (int c = 1; c <= m; c++) {
        if (isSafe(v, c, graph, color, n)) {
            color[v] = c;
            solve(v + 1, graph, color, n, m);
            color[v] = 0;
        }
    }
}
```

---

### Use Cases
- Register allocation in compilers
- Scheduling problems
- Frequency/channel assignment

---

## Practical-29: Hamiltonian Cycle

### Aim
Find a Hamiltonian cycle in a graph using backtracking.

---

### Algorithm (Backtracking)

**Algorithm: HAMILTONIAN(graph)**

1. Start from a vertex
2. Recursively add vertices to path
3. Check if all vertices are visited exactly once
4. Verify if last vertex connects to first

---

### Time Complexity (TC)
- \( O(n!) \)

---

### Space Complexity (SC)
- \( O(n) \)

---

### Code    

```java
static void nextValue(int k, int[][] graph, int[] x, int n) {
    while (true) {
        x[k] = (x[k] + 1) % n;

        if (x[k] == 0) return;

        if (graph[x[k - 1]][x[k]] == 1) {
            int j;
            for (j = 0; j < k; j++) {
                if (x[j] == x[k]) break;
            }

            if (j == k) {
                if (k < n - 1 || (k == n - 1 && graph[x[k]][x[0]] == 1)) {
                    return;
                }
            }
        }
    }
}

static void hamiltonian(int k, int[][] graph, int[] x, int n) {
    while (true) {
        nextValue(k, graph, x, n);

        if (x[k] == 0) return;

        if (k == n - 1) {
            for (int i = 0; i < n; i++) System.out.print(x[i] + " ");
            System.out.println(x[0]);
        } else {
            hamiltonian(k + 1, graph, x, n);
        }
    }
}
```

---
## Practical-30: N-Queens Problem

### Aim
Place N queens on an \( N \times N \) chessboard such that no two queens attack each other.

---

### Algorithm (Backtracking)

**Algorithm: N-QUEENS(k, x, n)**

1. If \( k = n \), a solution is found
2. For each column \( i = 0 \) to \( n-1 \):
    - Check if placing queen at \( (k, i) \) is safe
    - If safe:
        - Place queen
        - Recurse for next row

---

### Time Complexity (TC)
- \( O(n!) \)

---

### Space Complexity (SC)
- \( O(n) \)

---

### Code    

```java
public static void solve(int k, int[] x, int n) {
    if (k == n) {
        solutions++;
        return;
    }

    for (int i = 0; i < n; i++) {
        if (isSafe(k, i, x)) {
            x[k] = i;
            solve(k + 1, x, n);
        }
    }
}

static boolean isSafe(int k, int i, int[] x) {
    for (int j = 0; j < k; j++) {
        if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
            return false;
        }
    }
    return true;
}
```

---

### Use Cases
- Constraint satisfaction problems
- Puzzle solving
- Backtracking optimization techniques

---
### Graphs
![N-Queens Time Complexity Graph](Lab%2011/Images/NQ.png)

---
## Practical-31: Sum of Subsets

### Aim
Find all subsets of a given set whose sum equals a target value.

---

### Algorithm (Backtracking with Bounding)

**Algorithm: SUM-OF-SUBSETS(s, k, r, w, x, n, W)**

1. If \( k < n \):
2. Include current element \( w[k] \):
    - If \( s + w[k] = W \), output solution
    - Else recurse if promising
3. Exclude current element:
    - Recurse if remaining elements can still reach \( W \)

---

### Time Complexity (TC)
- Exponential (worst case)

---

### Space Complexity (SC)
- \( O(n) \)

---

### Code    

```java
public static void sumOfSubsets(int s, int k, int r, int[] w, int[] x, int n, int W) {
    if (k < n) {
        x[k] = 1;

        if (s + w[k] == W) {
            System.out.println("Found subset");
        }
        else if (k + 1 < n && s + w[k] + w[k+1] <= W) {
            sumOfSubsets(s + w[k], k + 1, r - w[k], w, x, n, W);
        }

        if (k + 1 < n && s + r - w[k] >= W && s + w[k+1] <= W) {
            x[k] = 0;
            sumOfSubsets(s, k + 1, r - w[k], w, x, n, W);
        }
    }
}
```

---

### Use Cases
- Subset selection problems
- Resource allocation
- Combinatorial optimization

---
### Graphs
![Sum of Subsets Time Complexity Graph](Lab%2011/Images/SumOfSubsets.png)

---
