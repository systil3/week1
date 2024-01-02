package com.example.a1230;

import java.util.HashMap;
import java.util.Map;

public class DeptIdMap {
    public Map<Integer, String> map;

    public DeptIdMap() {
        map = Map.of(
                0, "Management",
                1, "General Affairs",
                2, "Accounting",
                3, "Machinary",
                4, "Technical Research",
                5, "Human Resources",
                6, "System Management",
                7, "Facility Management");
    }
}
