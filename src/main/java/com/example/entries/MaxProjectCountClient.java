package com.example.entries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter

public class MaxProjectCountClient {
    private String name;
    private int projectCount;


}
