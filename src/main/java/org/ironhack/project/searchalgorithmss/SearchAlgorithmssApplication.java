package org.ironhack.project.searchalgorithmss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchAlgorithmssApplication {

    public static void main(String[] args) {

        System.out.println("===== BFS =====");
        BFS.run();

        System.out.println("\n===== DFS =====");
        DFS.run();

        System.out.println("\n===== GREEDY BEST-FIRST SEARCH =====");
        GreedySearch.run();
    }
}