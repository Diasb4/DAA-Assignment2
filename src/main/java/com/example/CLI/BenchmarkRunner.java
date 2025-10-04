package com.example.CLI;

import com.example.algorithms.InsertionSort;
import com.example.algorithms.Sorter;
import com.example.metrics.PerformanceTracker;

import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int size = 100000;
        String type = "random";

        Sorter sorter = new InsertionSort();
        PerformanceTracker metrics = new PerformanceTracker();

        int[] arr = generateArray(size, type);
        sorter.sort(arr, metrics);

        System.out.println("Algorithm: " + sorter.name());
        System.out.println(metrics);
    }

    private static int[] generateArray(int n, String type) {
        int[] arr = new int[n];
        Random rnd = new Random();

        switch (type) {
            case "sorted":
                for (int i = 0; i < n; i++)
                    arr[i] = i;
                break;
            case "reversed":
                for (int i = 0; i < n; i++)
                    arr[i] = n - i;
                break;
            case "nearly":
                for (int i = 0; i < n; i++)
                    arr[i] = i;
                for (int i = 0; i < n / 100; i++) {
                    int a = rnd.nextInt(n), b = rnd.nextInt(n);
                    int tmp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = tmp;
                }
                break;
            default: // random
                for (int i = 0; i < n; i++)
                    arr[i] = rnd.nextInt(n);
        }
        return arr;
    }
}
