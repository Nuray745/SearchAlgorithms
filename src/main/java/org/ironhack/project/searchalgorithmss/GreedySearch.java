package org.ironhack.project.searchalgorithmss;


import java.util.*;

public class GreedySearch {

    static Map<String, List<String>> graph = new HashMap<>();
    static Map<String, Integer> heuristic = new HashMap<>();

    static void addEdge(String a, String b) {
        graph.putIfAbsent(a, new ArrayList<>());
        graph.putIfAbsent(b, new ArrayList<>());

        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    static void run() {

        graph.clear();
        heuristic.clear();

        addEdge("A", "B");
        addEdge("A", "C");
        addEdge("B", "D");
        addEdge("B", "E");
        addEdge("C", "F");
        addEdge("C", "G");
        addEdge("E", "G");

        heuristic.put("A", 6);
        heuristic.put("B", 4);
        heuristic.put("C", 1);
        heuristic.put("D", 5);
        heuristic.put("E", 2);
        heuristic.put("F", 2);
        heuristic.put("G", 0);

        greedySearch("A", "G");
    }

    static void greedySearch(String start, String goal) {

        PriorityQueue<String> queue =
                new PriorityQueue<>(
                        Comparator.comparingInt(
                                node -> heuristic.get(node)
                        )
                );

        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.println(
                    "Visited: " + current +
                            " (h=" + heuristic.get(current) + ")"
            );

            if (current.equals(goal)) {
                System.out.println("Goal found!");
                break;
            }

            for (String neighbor : graph.get(current)) {

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        BFS.printPath(parent, start, goal);
    }
}

