package trees;

public class Binary_Tree_Representation {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(1);
        root.left = new NodeBT(2);
        root.right = new NodeBT(3);
        root.left.right = new NodeBT(5);
    }
}

class NodeBT {

    int data;
    NodeBT left;
    NodeBT right;

    // Constructor1
    public NodeBT(int data, NodeBT left, NodeBT right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // Constructor2
    public NodeBT(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }


}
