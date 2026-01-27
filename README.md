# Algorithms

## Practical-1: Power of a Number

### **Aim**
To implement and compare two methods to calculate the value of a number raised to the power **n** using recursion.

### **Theory**
The optimized recursive method calculates the result by dividing the exponent into halves, which reduces the number of recursive calls.

The simple recursive method calculates the result by multiplying the base repeatedly until the exponent becomes zero.

**Time Complexity**
- Optimized recursive method: **O(log n)**
- Simple recursive method: **O(n)**

**Space Complexity**
- Optimized recursive method: **O(log n)**
- Simple recursive method: **O(n)**

### **What the Code Does**
This program calculates the power of a number using two different recursive approaches.

The **powerRec(x, n)** method uses a divide and conquer approach.  
If the exponent is zero, it returns **1**.  
If the exponent is negative, it converts it into a positive exponent.

The method recursively computes **x^(n/2)** and stores it in a variable.  
If the exponent is even, it multiplies the half result with itself.  
If the exponent is odd, it multiplies the result with **x** once more.

This approach is efficient and works well for large values of **n**.

The **powerRec2(x, n)** method is a simple recursive approach.  
It multiplies **x** with the result of the function called with **n − 1**.  
This process continues until the exponent becomes zero.

This method is easier to understand but slower for large values of **n**.

### **Conclusion**
Both methods correctly calculate the power of a number.  
The optimized recursive method is more efficient due to fewer recursive calls.
