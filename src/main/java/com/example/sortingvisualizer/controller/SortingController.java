package com.example.sortingvisualizer.controller;

import com.example.sortingvisualizer.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sort")
public class SortingController {

    @Autowired
    private SortingService sortingService;

    @PostMapping("/{algorithm}")
    public Map<String, Object> sort(@PathVariable String algorithm, @RequestBody List<Integer> array) {
        return sortingService.sort(algorithm, array);
    }
}
