package org.example;

import java.util.Map;

public class Levels {
    static Map<Integer, String[][]> levels = Map.of(
            26, new String[][]
                    {{"H", "F", "R", "E", "RH"},
                            {"E", "F", "E", "E", "M"},
                            {"M", "R", "H", "M", "E"},
                            {"E", "E", "E", "E", "E"},
                            {"H", "E", "R", "E", "H"}},
            25, new String[][]
                    {{"H", "E", "E", "E", "RH"},
                            {"R", "E", "E", "E", "E"},
                            {"E", "E", "RH", "M", "E"},
                            {"M", "E", "E", "E", "E"},
                            {"H", "E", "E", "E", "RH"}},
            36, new String[][]
                    {{"H", "M", "E", "E", "H"},
                            {"F", "F", "E", "R", "E"},
                            {"E", "E", "RH", "E", "E"},
                            {"E", "M", "E", "E", "E"},
                            {"H", "E", "E", "E", "H"}});

}
