package implementation;

/**
 * 이분 탐색
 * <a href="https://www.javatpoint.com/binary-search-tree">참고</a>
 */
public class BinarySearchTree {

    private TreeNode root;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {35, 34, 23, 56, 81};
        for (int i = 0; i < values.length; i++) {
            bst.insert(values[i], (i+1 + "번째 순서"), 0);
        }

        boolean search = bst.search(bst.root, 23);
        System.out.println("search = " + search);

        bst.inorder(bst.root);
    }

    public void insert(int value, String name, int depth) {
        root = insertRec(root, value, name, depth);
    }

    private TreeNode insertRec(TreeNode root, int value, String name, int depth) {
        if (root == null) {
            root = new TreeNode(value, name, depth);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value, name, depth+1);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value, name, depth+1);
        }

        return root;
    }

    public boolean search(TreeNode root, int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (value == root.value) {
            return true;
        }

        if (value > root.value) {
            return searchRec(root.right, value);
        }

        return searchRec(root.left, value);
    }

    public void inorder(TreeNode root) {
        inorderRec(root);
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.printf("값: %d / 이름: %s / 레벨: %d\n", root.value, root.name, root.depth);
            inorderRec(root.right);
        }
    }
}

class TreeNode {
    int value;
    String name;
    TreeNode left, right;
    int depth;

    public TreeNode(int value, String name, int depth) {
        this.value = value;
        this.name = name;
        this.depth = depth;
        this.left = this.right = null;
    }
}