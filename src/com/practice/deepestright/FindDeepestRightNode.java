package com.practice.deepestright;

import com.practice.bst.BSTNode;

/**
 * Created by vitalii.kravets on 26.09.2016.
 */
public class FindDeepestRightNode {

    public BSTNode findDeepestRight(BSTNode root){
        return findDeepestRight(root, 0).node;
    }

    private BSTNodeLevel findDeepestRight(BSTNode node, Integer level){
        if(node.left == null && node.right == null){
            return new BSTNodeLevel(node, level);
        }

        BSTNodeLevel left = null;
        if(node.left != null){
            left = findDeepestRight(node.left, level + 1);
        }

        BSTNodeLevel right = null;
        if (node.right != null) {
            right = findDeepestRight(node.right, level + 1);
        }

        if(left != null && right != null){
            return right.level >= left.level ? right : left;
        } else if(left != null){
            return left;
        } else {
            return right;
        }
    }

    private static class BSTNodeLevel{
        private BSTNodeLevel(BSTNode node, int level) {
            this.node = node;
            this.level = level;
        }

        public BSTNode node;
        public int level;
    }
}
