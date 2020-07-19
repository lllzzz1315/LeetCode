package com.lzk.toutiao.链表和树;

import java.util.*;
/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/7/19 20:59
 * 二叉树的公共祖先
 * https://www.nowcoder.com/questionTerminal/c75deef6d4bf40249c785f240dad4247
 */
public class Tree {
    static HashMap<Integer, Integer[]> hm;
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        String[] st = sa.nextLine().split(" ");
        int n = Integer.parseInt(st[0]); //总结点
        int r = Integer.parseInt(st[1]); //根节点

        Integer[] child;
        hm = new HashMap<>();
        for(int i = 0 ; i < n; i++) {
            String[] tmp = sa.nextLine().split(" ");
            int fa = Integer.parseInt(tmp[0]);
            child = new Integer[2];
            child[0] = Integer.parseInt(tmp[1]);
            child[1] = Integer.parseInt(tmp[2]);
            hm.put(fa, child);
        }
        String[] o = sa.nextLine().split(" "); //2个节点
        int o1 = Integer.parseInt(o[0]);
        int o2 = Integer.parseInt(o[1]);
        Node root = new Node(r);
        Node node1 = new Node(o1);
        Node node2 = new Node(o2);
        buildTree(root);
        Node res = LCA(root, node1, node2);
        System.out.println(res.val);

    }


    public static void buildTree(Node root) {
        if(root == null) return;
        if(hm.containsKey(root.val)) {
            Node lc = null;
            Node rc = null;
            Integer[] sc = hm.get(root.val);
            if(sc[0] != 0) {
                lc = new Node(sc[0]); lc.parent = root;
            }
            if(sc[1] != 0) {
                rc = new Node(sc[1]); rc.parent = root;
            }
            root.left = lc;  root.right = rc;
            buildTree(lc);
            buildTree(rc);
        }

    }

    public static Node LCA(Node root, Node node1, Node node2) {
        if(root == null) return null;
        if(root.val == node1.val) return node1;
        if(root.val == node2.val) return node2;
        Node left = LCA(root.left, node1, node2);
        Node right = LCA(root.right, node1, node2);
        if(left != null && right != null) {
            return root;
        } else {
            return left == null ? right :left;
        }
    }
}

class Node {
    int val;Node parent;Node left;Node right;
    public Node(int val) {
        this.val = val;
    }
}
