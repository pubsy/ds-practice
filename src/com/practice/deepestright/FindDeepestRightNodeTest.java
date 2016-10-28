package com.practice.deepestright;

import com.practice.bst.BSTNode;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by vitalii.kravets on 26.09.2016.
 */
public class FindDeepestRightNodeTest {

    @Test
    public void testDeepestRight(){
        BSTNode.BinarySearchTree tree = initBinarySearchTree();
        BSTNode result = new FindDeepestRightNode().findDeepestRight(tree.getRoot());
        assertEquals(76, result.data);
    }

    private BSTNode.BinarySearchTree initBinarySearchTree() {
        BSTNode.BinarySearchTree tree = new BSTNode.BinarySearchTree();
        tree.addNode(Integer.valueOf(100));
        tree.addNode(Integer.valueOf(50));
        tree.addNode(Integer.valueOf(150));
        tree.addNode(Integer.valueOf(30));
        tree.addNode(Integer.valueOf(70));
        tree.addNode(Integer.valueOf(60));
        tree.addNode(Integer.valueOf(80));
        tree.addNode(Integer.valueOf(55));
        tree.addNode(Integer.valueOf(53));
        tree.addNode(Integer.valueOf(56));
        tree.addNode(Integer.valueOf(80));
        tree.addNode(Integer.valueOf(75));
        tree.addNode(Integer.valueOf(85));
        tree.addNode(Integer.valueOf(76));
        tree.addNode(Integer.valueOf(170));
        return tree;
    }
}
