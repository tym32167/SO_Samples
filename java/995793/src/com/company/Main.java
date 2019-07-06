package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer>[] graph = new ArrayList[9];

        for(int i=0; i<graph.length; i++) graph[i] = new ArrayList<>();

        graph[1].add(2);
        graph[2].add(1);

        graph[1].add(3);
        graph[3].add(1);

        graph[1].add(4);
        graph[4].add(1);

        graph[4].add(5);
        graph[5].add(4);

        graph[4].add(6);
        graph[6].add(4);

        graph[5].add(7);
        graph[7].add(5);

        graph[5].add(8);
        graph[8].add(5);

        int[] p = {2, 5, 6, 7};

        System.out.println(GetMinDist(graph, p));
    }

    public static int GetMinDist(ArrayList<Integer>[] graph, int[] p)
    {
        HashSet<Integer> pset = new HashSet<>();
        for(int i : p) pset.add(i);

        int min = Integer.MAX_VALUE;

        for(int i=1; i<graph.length; i++)
            min = Math.min(min, GetDistSum(graph, pset, i));

        return min;
    }

    public  static int GetDistSum(ArrayList<Integer>[] graph, HashSet<Integer> p, int from)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        int steps = 0;
        int sumSteps = 0;
        int pVisited = 0;

        q.add(from);
        while (q.isEmpty() == false)
        {
            int levelCount = q.size();
            for(int i=0; i<levelCount; i++)
            {
                int v = q.poll();
                if (visited[v]) continue;

                visited[v] = true;
                if (p.contains(v)) {
                    sumSteps+=steps;
                    pVisited++;
                    if (pVisited == p.size()) return sumSteps;
                }

                for(Integer c : graph[v])
                {
                    if (visited[c]) continue;
                    q.add(c);
                }
            }
            steps++;
        }
        return sumSteps;
    }

}
