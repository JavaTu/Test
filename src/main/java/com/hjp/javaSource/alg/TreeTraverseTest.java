package com.hjp.javaSource.alg;

/**
 * @ClassName: TreeTraverseTest
 * @Description: 前中后序遍历
 * 参考：https://blog.csdn.net/My_Jobs/article/details/43451187
 * https://www.jianshu.com/p/456af5480cee
 * @Author: huangjp
 * @Date: 2020/8/13 13:37
 */
public class TreeTraverseTest {

    public static void main(String[] args) {

        TreeNode root = new TreeNode("根节点");
        TreeNode left1 = new TreeNode("左一");
        TreeNode left2 = new TreeNode("左二");
        TreeNode right = new TreeNode("右一");
        left1.left = left2;
        root.left = left1;
        root.right = right;

        System.out.println("先序：");
        first(root);

        System.out.println();
        System.out.println("中序：");
        middle(root);

        System.out.println();
        System.out.println("后序：");
        after(root);

    }

    // 先序：根左右
    static void first(TreeNode root){
        System.out.print(root.val + " ");
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null){
            first(root.left);
        }

        if (right != null){
            first(root.right);
        }
    }

    // 中序：左根右
    static void middle(TreeNode root){
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null){
            middle(left);
        }
        System.out.print(root.val + " ");
        if (right != null){
            middle(right);
        }
    }

    // 后序：左右根
    static void after(TreeNode root){
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null){
            middle(left);
        }
        if (right != null){
            middle(right);
        }
        System.out.print(root.val + " ");
    }
}

class TreeNode{
    String val;

    TreeNode left;

    TreeNode right;

    public TreeNode(String val) {
        this.val = val;
    }
}
