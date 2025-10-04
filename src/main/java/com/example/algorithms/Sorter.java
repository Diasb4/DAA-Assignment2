package com.example.algorithms;

import com.example.metrics.PerformanceTracker;

public interface Sorter {
    // sort in-place, fill metrics
    void sort(int[] arr, PerformanceTracker metrics);

    String name();
}
