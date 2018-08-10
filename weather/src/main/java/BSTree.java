import java.util.ArrayList;

/**
 * 描述：Java实现二叉树
 * 5
 * 4       7
 * 3        6    8
 * 2
 */
public class BSTree<T extends Comparable<T>> {
    public BSTNode<T> mRoot; // 根节点

    // 二叉查找树的节点
    public class BSTNode<T extends Comparable<T>> {
        T key; // 关键字(值)
        BSTNode<T> left; // 左节点
        BSTNode<T> right;// 右节点
        BSTNode<T> parent; // 父节点

        public BSTNode(T key, BSTNode<T> left, BSTNode<T> right, BSTNode<T> parent) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "BSTNode{" +
                    "key=" + key +
                    ", left=" + (left != null ? left.key : null) +
                    ", right=" + (right != null ? right.key : null) +
                    ", parent=" + (parent != null ? parent.key : null) +
                    '}';
        }
    }

    // 前序遍历
    public void preOrder(BSTNode<T> node) {
        if (node != null) {
            System.out.print(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 前序遍历
    public void preOrder() {
        preOrder(mRoot);
    }

    // 中序遍历
    public void inOrder(BSTNode<T> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key);
            inOrder(node.right);
        }
    }

    // 中序遍历
    public void inOrder() {
        inOrder(mRoot);
    }

    // 中序遍历（将结果保存到指定集合中）
    public void inOrder(BSTNode<T> node, ArrayList<BSTNode> list) {
        if (node != null) {
            inOrder(node.left, list);
            System.out.print(node.key);
            list.add(node);
            inOrder(node.right, list);
        }
    }

    // 后序遍历
    public void postOrder(BSTNode<T> node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key);
        }
    }

    // 后序遍历
    public void postOrder() {
        postOrder(mRoot);
    }

    // 查找二叉树tree中键值为key的节点
    public BSTNode<T> search(BSTNode<T> node, T key) {
        if (node == null) { // 二叉树为空，返回空
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) { // 要查找的值在二叉树的左边
            return search(node.left, key);
        } else if (cmp > 0) {
            return search(node.right, key);
        } else {
            return node;
        }
    }

    // 查找二叉树tree中键值为key的节点
    public BSTNode<T> search(T key) {
        return search(mRoot, key);
    }

    // 非递归查找
    public BSTNode<T> iterativeSearch(BSTNode<T> node, T key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    // 非递归查找
    public BSTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    // 最大值
    public BSTNode<T> maxNode(BSTNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // 最大值
    public T maxNode() {
        BSTNode<T> node = maxNode(mRoot);
        if (node != null) {
            return node.key;
        }
        return null;
    }

    // 最小值
    public BSTNode<T> minNode(BSTNode<T> tree) {
        if (tree == null) {
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
    public BSTNode<T> preNode(BSTNode<T> node) {
        if (node == null) {
            return null;
        }
        // 如果tree有左节点，返回左节点中最大值
        if (node.left != null) {
            return maxNode(node.left);
        } else {
            /*
             * 如果tree没有左节点,分为两种情况
             * 1.tree是右节点，则前驱为该节点的最低父节点
             * 2.tree是左节点，则前驱为该节点的父节点，并且父节点有右节点
             * */
            BSTNode<T> parentNode = node.parent;
            while (parentNode != null && (node == parentNode.left)) {
                node = parentNode;
                parentNode = parentNode.parent;
            }
            return parentNode;
        }
    }

    // 获取节点的前驱
    public BSTNode<T> preNode() {
        return preNode(mRoot);
    }

    // 获取节点的后继(大于该节点的最小节点):方法一
    public BSTNode<T> postNode(BSTNode<T> node) {
        if (node == null) {
            return null;
        }
        // 有右节点，返回右节点的最小值
        if (node.right != null) {
            return minNode(node.right);
        } else {
            /*
             * 没有右节点，分两种情况：
             *1.该节点是左节点，后继节点为它的最低父节点
             *2.该节点是右节点，后继节点为它的父节点，并且父节点有左节点
             * */
            BSTNode<T> parentNode = node.parent;
            while (parentNode != null && node == parentNode.right) {
                node = parentNode;
                parentNode = parentNode.parent;
            }
            return parentNode;
        }
    }

    // 获取节点的后继
    public BSTNode<T> postNode() {
        return postNode(mRoot);
    }

    // 获取节点的后继:方法二（节点的后继节点是中序遍历的下一个节点）
    public BSTNode postNode2(BSTNode<T> node) {
        ArrayList<BSTNode> list = new ArrayList<>();
        inOrder(mRoot, list);
        System.out.println("size" + list.size());
        return list.get(list.indexOf(node) + 1);
    }

    /*
     * 插入操作：分为两步
     * 1.查找要插入元素的父节点root：插入元素和二叉树的根节点比较，大于，放右边，然后根节点的右节点作为
     * 新的根节点，重复查找，直到最终的根节点没有右节点，小于类似
     *2.要插入的节点和上一步得到得root节点比较，大于插入到右边，小于查到左边
     * */
    public void insert(BSTree<T> tree, BSTNode<T> node) {
        BSTNode<T> y = null;
        BSTNode<T> root = tree.mRoot;
        int cmp;
        while (root != null) {
            y = root;
            // 插入的节点和根节点比较
            cmp = node.key.compareTo(root.key);
            if (cmp > 0) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        // y为要插入节点得parent
        node.parent = y;
        if (y == null) { // 二叉树是空的，当前插入的节点为根节点
            tree.mRoot = node;
        } else {
            cmp = node.key.compareTo(y.key);
            if (cmp > 0) {
                y.right = node;
            } else {
                y.left = node;
            }
        }
    }

    public void insert(T key) {
        BSTNode<T> node = new BSTNode<>(key, null, null, null);
        insert(this, node);
    }

    /*
    * 删除某个节点
    * 1.该节点是叶子节点：把该节点的父引用指向null
    * 2.该节点有一个子节点：把父节点的引用指向该节点的子节点
    * 3.该节点有两个子节点：使用它的后继节点来代替该节点
    * */
    public BSTNode<T> remove(BSTree<T> tree, BSTNode<T> node) {
        // 真正删除节点的子树，左右子树的抽象
        BSTNode<T> x;
        // 真正删除的节点
        BSTNode<T> y;
        if (tree == null) {
            return null;
        }
        if (node.left == null || node.right == null) {
            y = node;
        } else {
            // 获取真正删除的节点
            y = postNode(node);
        }
        if (y.left != null) {
            x = y.left;
        } else {
            x = y.right;
        }
        if (x != null) {
            //
            x.parent = y.parent;
        }
        if (y.parent == null) {
            tree.mRoot = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        if (y != node) {
            node.key = y.key;
        }
        return y;
    }

    // 删除某个节点
    public BSTNode<T> remove(T key) {
        BSTNode<T> z, node;
        if ((z = search(mRoot, key)) != null) {
            if ((node = remove(this, z)) != null) {
                return node;
            }
        }
        return null;
    }

    /* 打印"二叉查找树"
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    public void print(BSTNode<T> tree, T key, int direction) {
        if (tree != null) {
            if (direction == 0) {
                // tree是根节点
                System.out.printf("%d is root\n", tree.key);
            } else {
                // tree是分支节点
                if (tree.key == key) {
                    System.out.printf("%d is root\n", tree.key);
                } else {
                    System.out.printf("%d is %d's %s child\n", tree.key, key, direction == 1 ? "right" : "left");
                }
                print(tree.left, tree.key, -1);
                print(tree.right, tree.key, 1);
            }
        }
    }

    public void print() {
        if (mRoot != null) {
            print(mRoot, mRoot.key, 0);
        }
    }

    // 销毁二叉树
    public void destoryTree(BSTNode<T> tree) {
        if (tree == null) {
            return;
        }
        if (tree.left != null) {
            destoryTree(tree.left);
        }
        if (tree.right != null) {
            destoryTree(tree.right);
        }
        tree = null;
    }

    public void clear() {
        if (mRoot != null) {
            destoryTree(mRoot);
        }
    }
}
