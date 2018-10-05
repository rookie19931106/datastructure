package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 * 不包含重复元素
 * @author jay
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> {
    /**
     * 构造节点
     */
    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e =e ;
            left =null;
            right=null;
        }
    }
    /**
     * 构造树
     */

    /**
     * 树包含根节点
     */
    private Node root;

    /**
     * 树的大小
     */
    private int size;

    public BinarySearchTree(){
        root =null;
        size=0;
    }

    /**
     * 获取树的大小
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 树是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 采用递归的方法实现add方法
     */

    public void add(E e){
        if(root==null){
            root=new Node(e);
        }else {
            add(root,e);
        }
    }

    //构造一个私有的方法
    private void add(Node node, E e) {
        //程序出口
        if(node.e.equals(e)){
            return;
        }
        //左边
        else if(e.compareTo(node.e)<0&&node.left==null){
            node.left=new Node(e);
            size++;
            return;
        }
        //右边
        else if(e.compareTo(node.e)>0&&node.right==null){
            node.right=new Node(e);
            size++;
            return;
        }

        //递归主体
        if(e.compareTo(node.e)<0){
            add(node.left,e);
        }else {
            add(node.right,e);
        }
    }
    /**
     * 更少代码的实现
     *
     */
//    public void add(E e){
//        root =add(root,e);
//    }
//
//    //向以node为根的二分搜索树插入元素e
//    //返回新插入的二分搜索树的根
//    private Node add(Node node,E e){
//        if(node==null){
//            return new Node(e);
//        }
//
//        if(e.compareTo(node.e)<0){
//           node.left = add(node.left,e);
//        }else if(e.compareTo(node.e)>0){
//            node.right=add(node.right,e);
//        }
//
//        return node;
//    }

    public boolean contains(E e){
        return contains(root,e);
    }

    //把以node为根的二分搜索树看为一个整体
    private boolean contains(Node node,E e){
        if(node==null){
            return false;
        }
        if(e.compareTo(node.e)==0){
            return true;
        }else if (e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }

    }

    /**
     * 深度优先遍历
     * 前序遍历，先访问节点，再访问左右孩子
     */
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.right);
        postOrder(node.left);
        System.out.println(node.e);
    }

    /**
     * 非递归的前序遍历
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur =  stack.pop();
            System.out.println(cur.e);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
    }

    /**
     * 广度优先遍历
     * 层序遍历
     * 把每个节点放到队列
     */
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur =queue.remove();
            System.out.println(cur.e);
            if(cur.left!=null){
                ((LinkedList<Node>) queue).add(cur.left);
            }
            if(cur.right!=null){
                ((LinkedList<Node>) queue).add(cur.right);
            }
        }
    }
    /**
     * 寻找最小的元素
     */

    public E findMin(){
        if(size==0){
            throw new IllegalArgumentException("empty!");
        }
        return findMin(root).e;
    }

    private Node findMin(Node node){
        if(node.left==null){
            return node;
        }
        return findMin(node.left);
    }

    /**
     * 寻找最大的元素
     */
    public E findMax(){
        if(size==0){
            throw new IllegalArgumentException("empty");
        }
        return findMax(root).e;
    }

    private Node findMax(Node node) {
        if(node.right==null){
            return node;
        }
        return findMax(node.right);
    }
    /**
     * 从二分搜索树删除最小值,返回最小值
     */
    public E removeMin(){
        E ret = findMin();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if(node.left==null){
            Node rightNode = node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树删除最大值,返回最大值
     */
    public E removeMax(){
        E ret = findMax();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if(node.right==null){
            Node leftNode = node.left;
            node.left=null;
            size--;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return node;
    }


}

