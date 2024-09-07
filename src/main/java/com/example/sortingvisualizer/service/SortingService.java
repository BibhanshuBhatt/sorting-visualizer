package com.example.sortingvisualizer.service;

import com.example.sortingvisualizer.service.algorithms.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SortingService {

    public Map<String, Object> sort(String algorithm, List<Integer> array) {
        SortingAlgorithm sortingAlgorithm;
        switch (algorithm.toLowerCase()) {
            case "bubble":
                sortingAlgorithm = new BubbleSort();
                break;
            case "quick":
                sortingAlgorithm = new QuickSort();
                break;
            case "merge":
                sortingAlgorithm = new MergeSort();
                break;
            case "selection":
                sortingAlgorithm = new SelectionSort();
                break;
            case "insertion":
                sortingAlgorithm = new InsertionSort();
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting algorithm");
        }

        List<int[]> steps = sortingAlgorithm.sort(array);
        Map<String, Object> response = new HashMap<>();
        response.put("sortedArray", array);
        response.put("steps", steps);

        return response;
    }
}
