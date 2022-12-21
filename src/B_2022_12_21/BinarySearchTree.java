package B_2022_12_21;

import java.util.Scanner;

public class BinarySearchTree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

    }

    public Node root;

    //순환적 탐색
    public static Node circularSearch(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key == node.data) {
            return node;
        } else if (key < node.data) {
            return circularSearch(node.left, key);
        } else {
            return circularSearch(node.right, key);
        }
    }

    //반복적인 탐색
    public static Node repetitiveSearch(Node node, int key) {
        while (node != null) {
            if (key == node.data) {
                return node;
            } else if (key < node.data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null; //탐색 실패했을 경우
    }

    //노드 삽입
    public Node insertNode(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        //그렇지 않으면 순환적으로 트리를 내려감
        if (key < node.data) {
            node.left = insertNode(node.left, key);
        } else if (key > node.data) {
            node.right = insertNode(node.right, key);
        }
        // 삽입 완료 후, 루트 노드 반환하며 끝
        return node;
    }

    // 노드 삭제
    public Node deleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.data) { //키가 루트보다 작다면, 왼쪽 서브 트리에 있는 것
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) { // 키가 루트보다 크다면, 오른쪽 서브트리에 있는 것
            root.right = deleteNode(root.right, key);
        } else { // 키가 루트와 같다면 이노드가 바로 삭제할 노드
            // 1번, 2번의 경우
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // 3번의 경우
            Node temp = minValueNode(root.right); // 후계 노드 찾기
            root.data = temp.data; // 후계 노드 값 복사
            root.right = deleteNode(root.right, temp.data); // 후계 노드 삭제
        }
        return root;
    }

    // 후계 노드 찾기 - 오른쪽 서브트리에서 가장 작은 값을 가지는 노드 봔환
    private Node minValueNode(Node node) {
        Node currentNode = node;

        while (currentNode.left != null) {
            currentNode = currentNode.left; // 맨 왼쪽 단말 노드를 찾으러 내려감
        }
        return currentNode;
    }

    //증위 순회
    public void inOrder(Node node) {
        if (node != null) {
            if (node.left != null) {
                inOrder(node.left);
            }
            System.out.print(node.data + " ");
            if (node.right != null) {
                inOrder(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BinarySearchTree t = new BinarySearchTree();
        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            if (circularSearch(t.root, key) == null) {
                t.root = t.insertNode(t.root, key);
            }
        }
        System.out.println("\n이지 탐색 트리 중위 순회");
        t.inOrder(t.root);
        if (repetitiveSearch(t.root, 68) != null) {
            System.out.println("\n\n68 탐색 성공");
        } else {
            System.out.println("\n\n68 탐색 실패");
        }
        System.out.println("\n단말 토드 삭제 - 30 삭제");
        t.deleteNode(t.root, 38);
        t.inOrder(t.root);
        System.out.println("\n\n하나의 서브트리만 가진 노드 삭제 - 68 삭제");
        t.deleteNode(t.root, 68);
        t.inOrder(t.root);
        System.out.println("\n\n두개의 서브트리르 가진 노드 삭제 - 18 삭제");
        t.deleteNode(t.root, 18);
        t.inOrder(t.root);
    }
}
