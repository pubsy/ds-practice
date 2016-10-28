package com.practice.bst;


import java.util.ArrayList;
import java.util.List;

public class BSTNode{
    public Comparable data;
    public BSTNode left;
    public BSTNode right;
    public BSTNode parent;

    public BSTNode(Comparable data) {
        this.data = data;
    }

    public static class BinarySearchTree {

        private BSTNode root;

        public void addNode(Comparable data){
            if(root == null){
                root = new BSTNode(data);
            } else {
                BSTNode parentOrNode = searchNode(data);

                if(parentOrNode.data.compareTo(data) < 0){
                    parentOrNode.right = new BSTNode(data);
                    parentOrNode.right.parent = parentOrNode;
                } else if(parentOrNode.data.compareTo(data) > 0) {
                    parentOrNode.left = new BSTNode(data);
                    parentOrNode.left.parent = parentOrNode;
                }
            }
        }

        public BSTNode searchNode(Comparable data){
            BSTNode prev = root;
            BSTNode curr = root;
            while(curr != null){
                if(curr.data.compareTo(data) < 0){
                    prev = curr;
                    curr = curr.right;
                } else if(curr.data.compareTo(data) > 0){
                    prev = curr;
                    curr = curr.left;
                } else {
                    prev = curr;
                    break;
                }
            }
            return prev;
        }

        public List<Comparable> inOrderList(){
            List<Comparable> list = new ArrayList<Comparable>();
            inOrderTraversal(list, this.root);
            return list;
        }

        public void inOrderTraversal(List<Comparable> list, BSTNode node){
            BSTNode curr = node;
            if( curr.left != null){
                inOrderTraversal(list, curr.left);
            }
            list.add(node.data);
            if(curr.right != null){
                inOrderTraversal(list, curr.right);
            }
        }

        public BSTNode findMaximum() {
            BSTNode curr = root;
            while(curr.right != null) {
                curr = curr.right;
            }
            return curr;
        }

        public BSTNode findMinimum(BSTNode curr) {
            while(curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }

        public void deleteNode(BSTNode node) {
            if(node.left == null && node.right == null){
                node.parent = null;
            } else if(node.left == null && node.right != null){
                node.parent.right = node.right;
            } else if(node.left != null && node.right == null){
                node.parent.left = node.left;
            } else { //node has two children
                BSTNode rightMinimum = findMinimum(node.right);
                rightMinimum.parent.left = null;
                node.data = rightMinimum.data;
            }
        }

        public BSTNode getRoot() {
            return root;
        }
    }
}