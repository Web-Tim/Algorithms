package me.tim.math;

import java.util.ArrayList;

public class Fibonacci {

    private static int fib(int n) {
        if (n < 2) return n;
        return fib(n - 1) + fib(n - 2);
    }

    private static long fastFib(int n) {
        int[] f = new int[n + 2];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++)
        {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        // fib(10);  Exponential
        // fastFib(35);  O(n)
    }
}
