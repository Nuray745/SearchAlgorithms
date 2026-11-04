package org.ironhack.project.searchalgorithmss;


import java.util.*;

public class DFS {

    static Map<String, List<String>> graph = new HashMap<>();
    static Set<String> visited = new HashSet<>();
    static List<String> path = new ArrayList<>();

    static void addEdge(String a, String b) {
        graph.putIfAbsent(a, new ArrayList<>());
        graph.putIfAbsent(b, new ArrayList<>());

        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    static void run() {

        graph.clear();
        visited.clear();
        path.clear();

        addEdge("A", "B");
        addEdge("A", "C");
        addEdge("B", "D");
        addEdge("B", "E");
        addEdge("C", "F");
        addEdge("C", "G");
        addEdge("E", "G");

        if (dfs("A", "G")) {
            System.out.println("Goal found!");
            System.out.println("Path: " + path);
        } else {
            System.out.println("Path not found");
        }
    }

    static boolean dfs(String current, String goal) {

        visited.add(current);
        path.add(current);

        System.out.println("Visited: " + current);

        if (current.equals(goal)) {
            return true;
        }

        for (String neighbor : graph.get(current)) {

            if (!visited.contains(neighbor)) {

                if (dfs(neighbor, goal)) {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);

        return false;
    }
}

