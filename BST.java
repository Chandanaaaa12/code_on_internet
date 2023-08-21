public class BST {

    private BST root;
    private int data;
    private BST left;
    private BST right;

    public BST() {
        root = null;
    }

    public BST(int value, BST left, BST right) {
        this.data = value;
        this.left = left;
        this.right = right;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // initial add method, looking ahead
    public void add(int value) {
        if (isEmpty())
            root = new BST(value, null, null);
        else
            addHelper(root, value);
    }

    private void addHelper(BST rt, int value) {
        if (value <= rt.data)
            if (rt.left == null)
                rt.left = new BST(value, null, null);
            else
                addHelper(rt.left, value);
        else
            if (rt.right == null)
                rt.right = new BST(value, null, null);
            else
                addHelper(rt.right, value);
        
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(BST rt) {
        if (rt != null) {
            inOrder(rt.left);
            System.out.print(rt.data + " ");
            inOrder(rt.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(BST rt) {
        if (rt != null) {
            System.out.print(rt.data + " ");
            preOrder(rt.left);
            preOrder(rt.right);
        }
    }

    public boolean search(int key){
        return searchHelper(root,key);
    }

    private boolean searchHelper(BST root,int key){
        if(root==null){
            return false;
        }
        else{
            if(root.data==key){
                System.out.println("key found "+root.data+" "+key);
                return true;
            }
            if (root.left != null && searchHelper(root.left, key)) {
                return true;
            }
            if (root.right != null && searchHelper(root.right, key)) {
                return true;
            }
            return false;
        }
    }

    // public static void main(String[] args) {
    //     BST tree1=new BST();
    //     // tree1.add(7);
    //     // tree1.add(5);
    //     // tree1.add(4);
    //     // tree1.add(10);
    //     // tree1.add(6);
    //     // tree1.add(8);
    //     // tree1.inOrder();
    //     // System.out.println();
    //     // tree1.preOrder();
        
    // }
}


