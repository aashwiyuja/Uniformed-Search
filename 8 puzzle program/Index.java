import java.util.Scanner;

public class Index {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String START = "283164705";
        final String GOAL = "123804765";
        SearchTree search = new SearchTree(new Node(START), GOAL);
        init(scanner, -1, search);
    }

    public static void init(Scanner scanner, int a, SearchTree searchTree) {
        int input = a;
        boolean shouldLoop = true;
        while (shouldLoop) {
            if (input == 1) {
                searchTree.breadthFirstSearch();
            } else if (input == 2) {
                searchTree.depthFirstSearch();
            } else if (input == 0) {
                System.out.println("EXITING...");
                shouldLoop = false;
                continue;
            }
            System.out.println("Please select an option");
            System.out.println("1. for BFS");
            System.out.println("2. for DFS");
            System.out.println("0. To exit");
            input = scanner.nextInt();
        }
    }
}
