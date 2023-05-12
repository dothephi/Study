/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;
import java.util.Stack;
/**
 *
 * @author MSI
 * @param <T>
 */
public class BST<T extends Comparable<? super T>> {
    protected BSTNode<T> root = null;
    public BST() {      }
    public void clear() {   root = null;    }
    public boolean isEmpty() {  return root == null;}
    
    public void insert(T el){
        if (root == null){
            root = new BSTNode<>(el);
            return;
        }
        BSTNode<T> p = root, prev = null;
        while (p != null) {
            prev = p;
            if (p.el.compareTo(el) < 0) p = p.right;
            else p = p.left;
        }
        
        if (prev.el.compareTo(el) < 0) prev.right= new BSTNode<T>(el);
        else prev.left = new BSTNode<T>(el);
    }
    
    protected BSTNode<T> recInsert (BSTNode<T> p, T el) {
        if (p == null) p = new BSTNode<T>(el);
        else if (p.el.compareTo(el) < 0) p.right = recInsert(p.right,el);
        else p.left = recInsert(p.left,el);
        return p;
    }
    public void recInsert(T el) {
        root = recInsert(root,el);
    }
    protected T search(T el) {
        BSTNode<T> p = root;
        while (p != null)
            if (el.equals(p.el))return p.el;
            else if (el.compareTo(p.el) < 0) p = p.left;
            else p = p.right;
        return null;
    }
    
    public boolean isInTree(T el) {
        return search(el) !=null;
    }
    
    protected void visit(BSTNode<T> p) {
        System.out.println(p.el + "  ");
    }
    
    protected void inorder (BSTNode<T> p){
        if (p != null) {
            inorder(p.left);
            visit(p);
            inorder(p.right);
        }
    }
    
    protected void preorder (BSTNode<T> p){
        if (p != null) {
            visit(p);
            preorder(p.left);
            preorder(p.right);
        }
    }
    
    protected void postorder (BSTNode<T> p){
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            visit(p);
        }
    }
    
    public void preorder() { preorder(root); }
    public void inorder() { inorder(root);  }
    public void postorder() { postorder(root); }
    
    public void deleteByMerging(T el) {
        BSTNode<T> p = root, prev = null;
        while (p != null && !p.el.equals(el)) {
            prev = p;
            if (p.el.compareTo(el) < 0) p = p.right;
            else p = p.left;
        }
        BSTNode<T> node = p;
        BSTNode<T> tmp;
        if (p != null && p.el.equals(el)) {
            if (node.right == null ) node = node.left;
            else if (node.left == null) node =node.right;
            else {
                tmp = node.left;
                while (tmp.right != null) tmp = tmp.right;
                tmp.right = node.right;
                node = node.left;
            }
            if (p == root) root = node;
            else if (prev.left == p) prev.left = node;
            else prev.right = node;
        }
        else if (root != null)
            System.out.println("Elenment " + el + " is not in the tree");
        else System.out.println("the tree is empty");
    }
    public void deleteByCopying(T el) {
        BSTNode<T> p = root, prev = null;
        while (p != null && !p.el.equals(el)) {
            prev = p;
            if (p.el.compareTo(el) < 0)
                p = p.right;
            else p = p.left;
        }
        BSTNode<T> node = p;
        if (p != null && p.el.equals(el)){
            if (node.right == null) node = node.left;
            else if (node.left == null) node = node.right;
            else {
                BSTNode<T> previous = node;
                BSTNode<T> tmp = node.left;
                while (tmp.right != null ){
                    previous = tmp; 
                    tmp = tmp.right;
                }
                node.el = tmp.el;
                if (previous == node) previous.left = tmp.left;
                else previous.right = tmp.left;
            }
            if (p == root) root = node;
            else if (prev.left == p) prev.left = node;
            else prev.right = node;
        }
        else if (root != null)
            System.out.println("Element " + el + " is not in the tree");
        else System.out.println("the tree is empty");
    }
    
    public void iterativePreorder() {
        BSTNode<T> p = root;
        Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();
        if (p != null) {
            stack.push(p);
            while (!stack.isEmpty()) {
                p = stack.pop();
                visit(p);
                if (p.right != null) stack.push (p.right);
                if (p.left != null) stack.push (p.left);
            }
        }
    }
    
    public void iterativeInorder() {
        BSTNode<T> p = root;
        Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();
        while (p != null) {
            while (p != null) {
                if (p.right != null) stack.push(p.right);
                stack.push(p);
                p = p.left;
            }
            
           p = stack.pop();
           while (!stack.isEmpty() && p.right == null){
               visit(p);
               p = stack.pop();
           }
           visit(p);
           if (!stack.isEmpty()) p = stack.pop();
           else p = null;
        }
    }
    public void iterativePostorder2() {
        BSTNode<T> p =root;
        Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();
        Stack<BSTNode<T>> output = new Stack<BSTNode<T>>();
        if (p != null) {
            stack.push(p);
            while (!stack.isEmpty()) {
                p = stack.pop();
                output.push(p);
                if (p.left != null) stack.push(p.left);
                if (p.right != null) stack.push(p.right);
            }
            while (!output.isEmpty()) {
                p = output.pop();
                visit(p);
            }
        }
    }
    public void iterativePostorder() {
        BSTNode<T> p = root, q = root;
        Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();
        while (p != null){
            for ( ; p.left != null; p = p.left) stack.push(p);
            while (p != null && (p.right == null || p.right == q)) {
               visit(p);
               q = p;
               if (stack.isEmpty())
                   return;
               p = stack.pop();
            }
            stack.push(p);
            p = p.right;
        }
    }
    public void breadthFirst() {
        BSTNode<T> p = root;
        MyQueue<BSTNode<T>> queue = new MyQueue<BSTNode<T>>();
        if (p != null) {
            queue.enqueue(p);
            while (!queue.isEmpty()){
                p = queue.dequeue();
                visit(p);
                if (p.left != null)
                    queue.enqueue(p.left);
                if (p.right != null)
                    queue.enqueue(p.right);
            }
        }
    }
    public void MorrisInorder() {
        BSTNode<T> p = root, tmp;
        while (p != null)
            if (p.left == null) {
                visit(p);
                p =p.right;
            }
            else {
                tmp = p.left;
                while (tmp.right != null && 
                          tmp.right != p)
                          tmp = tmp.right;
                if (tmp.right == null) {
                    tmp.right = p;
                    p = p.left;
            }
        else {
                visit(p);
                tmp.right = null;
                p = p.right;
                }
        }
    }
    public void MorrisPreorder() {
        BSTNode<T> p = root, tmp;
        while (p != null) {
            if (p.left ==null) {
                visit(p);
                p=p.right;
    }
        else {
                tmp = p.left;
                while (tmp.right != null &&
                          tmp.right != p)
                          tmp = tmp.right;
                if (tmp.right == null) {
                    visit(p);
                tmp.right = p;
                p = p.left;
                }
                else {
                    tmp.right = null;
                    p = p.right;
                }
          }
    }

}
    public void MorrisPostorder() {
        BSTNode<T> p = new BSTNode<T>(), tmp, q, r, s;
        p.left = root;
        while (p != null)
            if (p.left == null)
                p = p.right;
            else {
                tmp = p.left;
                while (tmp.right != null &&
                          tmp.right != p)
                          tmp = tmp.right;
                if (tmp.right == null) {
                    tmp.right = p;
                    p = p.left;
                }
                else {
                    for (q = p.left, r = q.right, s = r.right;
                            r != p; q = r, r = s, s = s.right)
                            r.right = q;
                    for (s = q.right; q != p.left;
                            q.right = r , r = q, q = s, s = s.right)
                        visit(q);
                    visit(p.left);
                    tmp.right = null;
                    p = p.right;
                }
            }
    }
    
    private void visit_align(BSTNode p, int level){
        if (p==null) return;
        if (level>0) {
            for (int i=0;i<level-1;i++)System.out.println("     ");
            System.out.println("|__");
            
        }
        System.out.println(p.el);
        visit_align(p.left, level+1);
        visit_align(p.right, level+1);
    }
    public void print_align(){
        visit_align(root,0);
    }
    public void insertBalance(T data[], int first, int last) {
        if (first <= last) {
            int middle = (first + last)/2;
            insert(data[middle]);
            insertBalance(data,first,middle-1);
            insertBalance(data,middle+1,last);
        }
    }
    
    public void insertBalance(T data[]) {
        insertBalance(data,0,data.length-1);
    }
}
