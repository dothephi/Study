/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author MSI
 */
public class BSTNode<T extends Comparable<? super T>> {
    protected T el;
    protected BSTNode<T> left, right;
    public BSTNode() { left = right = null; }
    public BSTNode(T el) { this(el,null,null); }
    public BSTNode(T el, BSTNode<T> lt, BSTNode<T> rt){
        this.el = el;
        left = lt;
        right = rt;
    }
}
