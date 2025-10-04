package com.example.algorithms;

import com.example.metrics.PerformanceTracker;

public class InsertionSort implements Sorter {
    @Override
    public void sort(int[] arr, PerformanceTracker metrics) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        metrics.startTimer();
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            metrics.addAccess(1); // чтение arr[i]

            int j = binarySearch(arr, x, 0, i, metrics);

            // Сдвигаем вручную
            for (int k = i; k > j; k--) {
                arr[k] = arr[k - 1];
                metrics.addAccess(2); // чтение arr[k-1] + запись arr[k]
                metrics.addSwap(); // считаем как один "сдвиг"
            }

            arr[j] = x;
            metrics.addAccess(1); // запись arr[j]
        }
        metrics.stopTimer();
    }

    private int binarySearch(int[] arr, int key, int low, int high, PerformanceTracker metrics) {
        while (low < high) {
            int mid = (low + high) / 2;
            metrics.addAccess(1); // чтение arr[mid]
            metrics.addComparison();

            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    @Override
    public String name() {
        return "InsertionSort (binary)";
    }
}
