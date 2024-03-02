package com.example.entries;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor

public class MaxAgeCountProject {
    private int projectId;
    private LocalDate age;

    @Override
    public String toString() {
        return "MaxAgeCountProject{" +
                "projectId=" + projectId +
                ", age=" + age +
                '}';
    }
}

