package com.example.entries;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor


public class YongestEldestWorker {
    private String type;
    private String name;
    private LocalDate date;

}
