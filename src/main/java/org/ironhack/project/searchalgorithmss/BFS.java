package org.ironhack.project.searchalgorithmss;


import java.util.*;

public class BFS {

    static Map<String, List<String>> graph = new HashMap<>();

    static void addEdge(String a, String b) {
        graph.putIfAbsent(a, new ArrayList<>());
        graph.putIfAbsent(b, new ArrayList<>());

        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    static void run() {

        graph.clear();

        addEdge("A", "B");
        addEdge("A", "C");
        addEdge("B", "D");
        addEdge("B", "E");
        addEdge("C", "F");
        addEdge("C", "G");
        addEdge("E", "G");

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();

        queue.add("A");
        visited.add("A");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.println("Visited: " + current);

            if (current.equals("G")) {
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

        printPath(parent, "A", "G");
    }

    static void printPath(
            Map<String, String> parent,
            String start,
            String goal) {

        if (!parent.containsKey(goal) && !start.equals(goal)) {
            System.out.println("Path not found");
            return;
        }

        List<String> path = new ArrayList<>();
        String current = goal;

        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);

        System.out.println("Path: " + path);
    }
}

