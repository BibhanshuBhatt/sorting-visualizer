package com.example.sortingvisualizer.service.algorithms;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort implements SortingAlgorithm {

    @Override
    public List<int[]> sort(List<Integer> array) {
        List<int[]> steps = new ArrayList<>();
        int n = array.size();
        int[] currentArray = array.stream().mapToInt(i -> i).toArray();

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (currentArray[j] < currentArray[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = currentArray[minIdx];
            currentArray[minIdx] = currentArray[i];
            currentArray[i] = temp;
            steps.add(currentArray.clone());
        }

        return steps;
    }
}
