// =========================================================
// Do NOT modify this file 
// =========================================================

class Node{
    private Bike info;
    Node next;
    
    // Default constructor (no parameter)
    Node () {}
    
    // Constructor for a typical node
    Node (Bike x, Node p) {
        this.info = x; // data stored inside the node
        this.next = p; // link to the next node
    }
    
    //Copy constructor
    Node (Bike x) {
        this(x,null);
    }

    Node(double xPrice, Node head) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Bike getInfo() {
        return this.info;
    }
    
    public Node getNext() {
        return this.next;
    }
    
    public void setInfo(Bike inBike) {
        this.info = inBike;
    }
    
    public void setNext(Node n) {
        this.next = n;
    }
 }

