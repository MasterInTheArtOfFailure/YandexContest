import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    static int maxDepth = 0;
    static int ansIndex = 0;

    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
    }

    static void dfs(Node node, int depth) {
        if (depth > maxDepth) {
            maxDepth = depth;
            ansIndex = node.val;
        }
        for (Node child : node.children) {
            dfs(child, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 1; i < n + 1; i++) {
            int parent = Integer.parseInt(br.readLine());
            nodes[parent].children.add(nodes[i]);
        }
        dfs(nodes[0], 1);
        System.out.println(ansIndex);
    }
}
