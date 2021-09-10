import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        //이진 탐색 트리 구현
        // full 이진 탐색 트리가 아니어도 됨
        //서로 다른 값으로 구성된 노드들이라 가정.

        int nodeCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        List<Node> nodeList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int nodeValue = Integer.parseInt(st.nextToken());
            nodeList.add(new Node(nodeValue));
        }

        Node ROOT = nodeList.get(0);

        for (int i = 1; i < nodeCount; i++) {
            insert(ROOT, nodeList.get(i));
        }

        for (int i = 0; i < nodeCount; i++) {
            Node node = nodeList.get(i);
            System.out.print(node.value + " ");
            System.out.print((node.left == null ? -1 : node.left.value) + " ");
            System.out.println(node.right == null ? -1 : node.right.value);
        }
    }

    private static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    private static void insert(Node parent, Node child) { //insert child to parent
        if (parent.value > child.value) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }
}
