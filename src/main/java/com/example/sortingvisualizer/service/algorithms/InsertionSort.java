package com.example.sortingvisualizer.service.algorithms;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort implements SortingAlgorithm {

    @Override
    public List<int[]> sort(List<Integer> array) {
        List<int[]> steps = new ArrayList<>();
        int[] currentArray = array.stream().mapToInt(i -> i).toArray();

        for (int i = 1; i < currentArray.length; i++) {
            int key = currentArray[i];
            int j = i - 1;

            while (j >= 0 && currentArray[j] > key) {
                currentArray[j + 1] = currentArray[j];
                j--;
                steps.add(currentArray.clone());
            }
            currentArray[j + 1] = key;
            steps.add(currentArray.clone());
        }

        return steps;
    }
}
