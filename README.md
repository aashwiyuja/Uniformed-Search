# Uniformed Search 8-Puzzle Solver

This repository provides a simple puzzle solver for the 8-puzzle problem. The 8-puzzle problem is a sliding puzzle commonly used for algorithmic problem-solving exercises. The goal is to arrange the tiles in the correct order with a blank tile space, typically in a 3x3 grid.

## Contents
1. Index
2. Node
3. SearchQueue
4. SearchTree
5. Utils

## 1. Index

The `Index` class serves as the entry point for the 8-puzzle solver. It initializes the puzzle's starting and goal states, creates a search tree, and provides options for different search algorithms, such as Breadth-First Search (BFS) and Depth-First Search (DFS).

```java
// Example usage in main method
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    final String START = "283164705";
    final String GOAL = "123804765";
    SearchTree search = new SearchTree(new Node(START), GOAL);
    init(scanner, -1, search);
}
```

## 2. Node

The `Node` class represents a state in the puzzle-solving process. It contains information about the state, including the state itself, cost, parent node, depth, and children nodes.

```java
public class Node {
    // Constructor, getters, and setters
    // ...
}
```

## 3. SearchQueue

The `SearchQueue` class implements a simple queue data structure used in the search algorithms. It supports basic operations such as enqueue, dequeue, and iteration.

```java
public class SearchQueue<Item> implements Iterable<Item> {
    // Constructor and methods
    // ...
}
```

## 4. SearchTree

The `SearchTree` class encapsulates the logic for various search algorithms, including Breadth-First Search (BFS), Depth-First Search (DFS), and Best-First Search. It utilizes the `Node` class and the `Utils` class for puzzle-solving.

```java
public class SearchTree {
    // Constructor and search methods
    // ...
}
```

## 5. Utils

The `Utils` class contains utility methods, including generating successors for a given puzzle state, printing the solution path, and finding the transition between states.

```java
public class Utils {
    // Methods for generating successors, printing solutions, and finding transitions
    // ...
}
```
