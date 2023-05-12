// =========================================================
// Do NOT modify this file 
// =========================================================

class Node{
    private Bike info;
    Node left,right;
    //int bal,level;
    
    // Default constructor (no parameter)
    Node () {}
    
    // Constructor for a typical node
    Node (Bike x, Node leftChild, Node rightChild) {
        this.info = x; // data stored inside the node
        this.left = leftChild; // link to the left child node
        this.right = rightChild; // link to the right child node
    }
    
    //Copy constructor
    Node (Bike x) {
        this(x,null, null);
    }
    
    public Bike getInfo() {
        return this.info;
    }
    
    public void setInfo(Bike inBike) {
        this.info = inBike;
    }
    
    public Node getLeft() {
        return this.left;
    }
    
    public Node getRight() {
        return this.right;
    }
    
    public void setLeft(Node inLeft) {
        this.left = inLeft;
    }
    
    public void setRight(Node inRight) {
        this.right = inRight;
    }
}

