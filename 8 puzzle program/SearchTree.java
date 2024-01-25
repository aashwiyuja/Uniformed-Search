import java.util.*;

public class SearchTree {
    private Node root;
    private String goalSate;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public String getGoalSate() {
        return goalSate;
    }

    public void setGoalSate(String goalSate) {
        this.goalSate = goalSate;
    }

    public SearchTree(Node root, String goalSate) {
        this.root = root;
        this.goalSate = goalSate;
    }

    // Breadth First Search
    public void breadthFirstSearch() {
        Set<String> stateSets = new HashSet<String>();
        int time = 0;
        Node node = new Node(root.getState());
        Queue<Node> queue = new LinkedList<Node>();
        Node currentNode = node;
        while (!currentNode.getState().equals(goalSate)) {
            stateSets.add(currentNode.getState());
            List<String> nodeSuccessors = Utils.getSuccessors(currentNode.getState());
            for (String n : nodeSuccessors) {
                if (stateSets.contains(n))
                    continue;
                stateSets.add(n);
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setParent(currentNode);
                queue.add(child);
            }
            currentNode = queue.poll();
            time += 1;
        }

        Utils.printSolution(currentNode, stateSets, root, time);

    }

    // Depth First Search
    public void depthFirstSearch() {
        Set<String> stateSets = new HashSet<String>();
        int time = 0;
        Node node = new Node(root.getState());
        SearchQueue<Node> mainQueue = new SearchQueue<>(); 
        SearchQueue<Node> successorsQueue = new SearchQueue<>();
        Node currentNode = node;
        while (!currentNode.getState().equals(goalSate)) {
            stateSets.add(currentNode.getState());
            List<String> nodeSuccessors = Utils.getSuccessors(currentNode.getState());
            for (String n : nodeSuccessors) {
                if (stateSets.contains(n))
                    continue;
                stateSets.add(n);
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setParent(currentNode);
                successorsQueue.enqueue(child);
            }
            mainQueue.addQueue(successorsQueue);
            successorsQueue.clear();
            currentNode = mainQueue.dequeue();
            time += 1;
            nodeSuccessors.clear();
        }
        Utils.printSolution(currentNode, stateSets, root, time);
    }

    // Best First Search
    public void bestFirstSearch() {
        Set<String> stateSets = new HashSet<String>();
        int time = 0;
        Node node = new Node(root.getState());
        node.setCost(0);
        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<Node>(10);
        Node currentNode = node;
        while (!currentNode.getState().equals(goalSate)) {
            stateSets.add(currentNode.getState());
            List<String> nodeSuccessors = Utils.getSuccessors(currentNode.getState());
            for (String n : nodeSuccessors) {
                if (stateSets.contains(n))
                    continue;
                stateSets.add(n);
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setParent(currentNode);

                child.setTotalCost(0, heuristicOne(child.getState(), goalSate));
                nodePriorityQueue.add(child);

            }
            currentNode = nodePriorityQueue.poll();
            time += 1;
        }
        Utils.printSolution(currentNode, stateSets, root, time);
    }

    private int heuristicOne(String currentState, String goalSate) {
        int difference = 0;
        for (int i = 0; i < currentState.length(); i += 1)
            if (currentState.charAt(i) != goalSate.charAt(i))
                difference += 1;
        return difference;
    }
}