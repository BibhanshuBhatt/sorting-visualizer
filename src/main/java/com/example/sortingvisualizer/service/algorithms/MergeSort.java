package com.example.sortingvisualizer.service.algorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements SortingAlgorithm {

    @Override
    public List<int[]> sort(List<Integer> array) {
        List<int[]> steps = new ArrayList<>();
        int[] currentArray = array.stream().mapToInt(i -> i).toArray();
        mergeSort(currentArray, 0, currentArray.length - 1, steps);
        return steps;
    }

    private void mergeSort(int[] arr, int left, int right, List<int[]> steps) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, steps);
            mergeSort(arr, mid + 1, right, steps);
            merge(arr, left, mid, right, steps);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, List<int[]> steps) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            steps.add(arr.clone());
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            steps.add(arr.clone());
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            steps.add(arr.clone());
        }
    }
}
