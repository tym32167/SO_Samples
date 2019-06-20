package com.company;

public class Main {

    public static void main(String[] args) {

        String[] input = new String[]{
                "cat",
                "cats",
                "catsdogcats",
                "dog",
                "dogcatsdog",
                "hippopotamuses",
                "rat",
                "ratcatdogcat",
        };

        // HashSolver.Solve(input);

        TrieSolver.Solve(input);
    }
}
