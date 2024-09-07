package com.example.sortingvisualizer.service.algorithms;

import java.util.ArrayList;
import java.util.List;

public class QuickSort implements SortingAlgorithm {

    @Override
    public List<int[]> sort(List<Integer> array) {
        List<int[]> steps = new ArrayList<>();
        int[] currentArray = array.stream().mapToInt(i -> i).toArray();
        quickSort(currentArray, 0, currentArray.length - 1, steps);
        return steps;
    }

    private void quickSort(int[] arr, int low, int high, List<int[]> steps) {
        if (low < high) {
            int pi = partition(arr, low, high, steps);
            quickSort(arr, low, pi - 1, steps);
            quickSort(arr, pi + 1, high, steps);
        }
    }

    private int partition(int[] arr, int low, int high, List<int[]> steps) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                steps.add(arr.clone());
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        steps.add(arr.clone());

        return i + 1;
    }
}
