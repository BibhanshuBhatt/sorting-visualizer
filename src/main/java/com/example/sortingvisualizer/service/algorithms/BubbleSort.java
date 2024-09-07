package com.example.sortingvisualizer.service.algorithms;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements SortingAlgorithm {

    @Override
    public List<int[]> sort(List<Integer> array) {
        List<int[]> steps = new ArrayList<>();
        int n = array.size();
        int[] currentArray = array.stream().mapToInt(i -> i).toArray();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (currentArray[j] > currentArray[j + 1]) {
                    int temp = currentArray[j];
                    currentArray[j] = currentArray[j + 1];
                    currentArray[j + 1] = temp;
                    steps.add(currentArray.clone());
                }
            }
        }
        return steps;
    }
}
