package com.example;

import java.util.Arrays;

import org.junit.Test;

import com.example.algorithms.InsertionSort;
import com.example.metrics.PerformanceTracker;
import com.example.algorithms.Sorter;

public class InsSortTest {

    private final Sorter sorter = new InsertionSort();

    @Test
    public void testInsertionSort() {
        int[] arr = { 5, 2, 9, 1, 5, 6 };
        int[] expected = { 1, 2, 5, 5, 6, 9 };
        PerformanceTracker metrics = new PerformanceTracker();
        sorter.sort(arr, metrics);
        assert Arrays.equals(arr, expected) : "Array not sorted correctly";
        System.out.println("Metrics: " + metrics);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullArray() {
        PerformanceTracker metrics = new PerformanceTracker();
        sorter.sort(null, metrics);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        PerformanceTracker metrics = new PerformanceTracker();
        sorter.sort(arr, metrics);
        assert Arrays.equals(arr, expected) : "Empty array should remain empty";
        System.out.println("Metrics for empty array: " + metrics);
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = { 42 };
        int[] expected = { 42 };
        PerformanceTracker metrics = new PerformanceTracker();
        sorter.sort(arr, metrics);
        assert Arrays.equals(arr, expected) : "Single element array should remain unchanged";
        System.out.println("Metrics for single element array: " + metrics);
    }

    @Test
    public void testAlreadySortedArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        PerformanceTracker metrics = new PerformanceTracker();
        sorter.sort(arr, metrics);
        assert Arrays.equals(arr, expected) : "Already sorted array should remain unchanged";
        System.out.println("Metrics for already sorted array: " + metrics);
    }

    @Test
    public void testReverseSortedArray() {
        int[] arr = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };
        PerformanceTracker metrics = new PerformanceTracker();
        sorter.sort(arr, metrics);
        assert Arrays.equals(arr, expected) : "Reverse sorted array not sorted correctly";
        System.out.println("Metrics for reverse sorted array: " + metrics);
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] arr = { 3, 1, 2, 3, 1 };
        int[] expected = { 1, 1, 2, 3, 3 };
        PerformanceTracker metrics = new PerformanceTracker();
        sorter.sort(arr, metrics);
        assert Arrays.equals(arr, expected) : "Array with duplicates not sorted correctly";
        System.out.println("Metrics for array with duplicates: " + metrics);
    }

    @Test
    public void testLargeArray() {
        int size = 1000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i; // Заполняем массив в обратном порядке
        }
        int[] expected = new int[size];
        for (int i = 0; i < size; i++) {
            expected[i] = i + 1; // Ожидаемый отсортированный массив
        }
        PerformanceTracker metrics = new PerformanceTracker();
        sorter.sort(arr, metrics);
        assert Arrays.equals(arr, expected) : "Large array not sorted correctly";
        System.out.println("Metrics for large array: " + metrics);
    }
}
