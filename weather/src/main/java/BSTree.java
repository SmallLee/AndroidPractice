/**
 * 描述：Java实现二叉树
 *          3
 *     1        5
 *         2   4   6
 */
public class BSTree<T extends Comparable<T>> {
    private BSTNode<T> mRoot; // 根节点


    // 二叉查找树的节点
    private class BSTNode<T extends Comparable<T>>{
        T key; // 关键字(值)
        BSTNode<T> left; // 左节点
        BSTNode<T> right;// 右节点
        BSTNode<T> parent; // 父节点

        public BSTNode(T key,BSTNode<T> left,BSTNode<T> right,BSTNode<T> parent) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    // 前序遍历
    public void preOrder(BSTNode<T> tree){
        if (tree != null) {
            System.out.println(tree.key);
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }
    // 前序遍历
    public void preOrder(){
        preOrder(mRoot);
    }

    // 中序遍历
    public void inOrder(BSTNode<T> tree){
        if (tree != null) {
            inOrder(tree.left);
            System.out.println(tree.key);
            inOrder(tree.right);
        }
    }

    // 中序遍历
    public void inOrder(){
        inOrder(mRoot);
    }

    // 后序遍历
    public void postOrder(BSTNode<T> tree){
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.println(tree.key);
        }
    }

    // 后序遍历
    public void postOrder(){
        postOrder(mRoot);
    }

    // 查找二叉树tree中键值为key的节点
    public BSTNode<T> search(BSTNode<T> tree,T key) {
        if (tree == null) { // 二叉树为空，返回空
            return null;
        }
        int cmp = key.compareTo(tree.key);
        if (cmp < 0){ // 要查找的值在二叉树的左边
            search(tree.left,key);
        } else if (cmp > 0) {
            search(tree.right,key);
        } else {
            return tree;
        }
        return null;
    }

    // 查找二叉树tree中键值为key的节点
    public BSTNode<T> search(T key) {
       return search(mRoot,key);
    }

    // 非递归查找
    public BSTNode<T> iterativeSearch(BSTNode<T> tree,T key) {
        while (tree != null) {
            int cmp = key.compareTo(tree.key);
            if (cmp < 0) {
                tree = tree.left;
            } else if (cmp > 0) {
                tree = tree.right;
            } else {
                return tree;
            }
        }
        return tree;
    }

    // 非递归查找
    public BSTNode<T> iterativeSearch(T key) {
       return iterativeSearch(mRoot,key);
    }

    // 最大值
    public BSTNode<T> maxNode(BSTNode<T> tree) {
        if(tree == null) {
            return null;
        }
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    // 最大值
    public T maxNode() {
        BSTNode<T> node = maxNode(mRoot);
        if (node != null){
            return node.key;
        }
        return null;
    }

    // 最小值
    public BSTNode<T> minNode(BSTNode<T> tree) {
        if(tree == null) {
            return null;
        }
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }
    // 最小值
    public T minNode() {
        BSTNode<T> node = minNode(mRoot);
        if (node != null) {
            return node.key;
        }
        return null;
    }

    // 获取节点的前驱(左节点最大值)
    public BSTNode<T> preNode(BSTNode<T> tree) {
        if (tree == null) {
            return null;
        }
        // 如果tree有左节点，返回左节点中最大值
        BSTNode<T> node = maxNode(tree.left);
        if(node != null) {
            return node;
        }
        // 如果tree没有左节点
        BSTNode<T> parent = tree.parent;
        while(parent != null && (tree == parent.left)) {
            tree = parent;
            parent = parent.parent;
        }
        return parent;
    }

    // 获取节点的前驱
    public BSTNode<T> preNode() {
       return preNode(mRoot);
    }

    // 获取节点的后继(右节点最小值)
    public BSTNode<T> postNode(BSTNode<T> tree) {
        if (tree == null) {
            return null;
        }
        BSTNode<T> node = minNode(tree.right);
        if(node != null) {
            return node;
        }
        return null;
    }

    // 获取节点的前驱
    public BSTNode<T> postNode() {
        return postNode(mRoot);
    }
}
