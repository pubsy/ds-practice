package com.practice;

import com.practice.bst.BSTNode;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class BinarySearchTreeTest {

    @Test
    public void testInOrderTraversal() throws Exception {
        BSTNode.BinarySearchTree tree = initBinarySearchTree();

        List list = tree.inOrderList();
        assertArrayEquals(new int[]{1, 3, 5, 6, 7}, convertToPrimitive(list));
    }

    @Test
    public void testDeletingRootNode() throws Exception {
        BSTNode.BinarySearchTree tree = initBinarySearchTree();

        BSTNode node = tree.searchNode(5);
        tree.deleteNode(node);
        List list = tree.inOrderList();
        assertArrayEquals(new int[]{1, 3, 6, 7}, convertToPrimitive(list));
    }

    @Test
    public void testDeletingSingleLeftChildNode() throws Exception {
        BSTNode.BinarySearchTree tree = initBinarySearchTree();

        BSTNode node = tree.searchNode(7);
        tree.deleteNode(node);
        List list = tree.inOrderList();
        assertArrayEquals(new int[]{1, 3, 5, 6}, convertToPrimitive(list));
    }

    @Test
    public void testDeletingSingleRightChildNode() throws Exception {
        BSTNode.BinarySearchTree tree = initBinarySearchTree();

        BSTNode node = tree.searchNode(7);
        tree.deleteNode(node);
        List list = tree.inOrderList();
        assertArrayEquals(new int[]{1, 3, 5, 6}, convertToPrimitive(list));
    }

    @Test
    public void testFindElement(){
        BSTNode.BinarySearchTree tree = initBinarySearchTree();

        BSTNode node = tree.searchNode(6);
        assertNotNull(node);
        assertEquals(6, node.data);
    }

    @Test
    public void testFindOtherElement(){
        BSTNode.BinarySearchTree tree = initBinarySearchTree();

        BSTNode node = tree.searchNode(5);
        assertNotNull(node);
        assertEquals(5, node.data);
    }

    @Test
    public void testFindElementNotInTree(){
        BSTNode.BinarySearchTree tree = initBinarySearchTree();

        BSTNode notFound = tree.searchNode(8);
        assertNotNull(notFound);
        assertNotEquals(8, notFound.data);
    }

    @Test
    public void testFindMaximum(){
        BSTNode.BinarySearchTree tree = initBinarySearchTree();

        BSTNode notFound = tree.findMaximum();
        assertNotNull(notFound);
        assertEquals(7, notFound.data);
    }

    @Test
    public void testFindMinimum(){
        BSTNode.BinarySearchTree tree = initBinarySearchTree();

        BSTNode notFound = tree.findMinimum(tree.getRoot());
        assertNotNull(notFound);
        assertEquals(1, notFound.data);
    }

    private BSTNode.BinarySearchTree initBinarySearchTree() {
        BSTNode.BinarySearchTree tree = new BSTNode.BinarySearchTree();
        tree.addNode(Integer.valueOf(5));
        tree.addNode(Integer.valueOf(3));
        tree.addNode(Integer.valueOf(7));
        tree.addNode(Integer.valueOf(1));
        tree.addNode(Integer.valueOf(6));
        return tree;
    }

    private int[] convertToPrimitive(List<Integer> list){
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            array[i] = list.get(i);
        return array;
    }
}