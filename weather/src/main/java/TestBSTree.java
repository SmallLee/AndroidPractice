/**
 * 描述：测试而二叉查找树(二叉搜索树)
 */
public class TestBSTree {
    public static void main(String[] args) {
        int[] arr ={5,4,3,7,2,6,8};
        BSTree<Integer> bsTree = new BSTree<>();
        for (int anArr : arr) {
            bsTree.insert(anArr);
        }
//        System.out.println("======前序遍历");
//        bsTree.preOrder();//5432768
//        System.out.println("======中序遍历");
//        bsTree.inOrder();//2345678
//        System.out.println("======后序遍历");
//        bsTree.postOrder();//2346875
//
//        System.out.println("=====最小值" + bsTree.minNode());//2
//        System.out.println("=====最大值" + bsTree.maxNode());//8
//        System.out.println("search "+ bsTree.iterativeSearch(2));
        // 查找前驱结点
        BSTree<Integer>.BSTNode<Integer> node = bsTree.search(3);
//        System.out.println("前驱节点" + bsTree.preNode(node));
        System.out.println("后继节点" + bsTree.postNode(node));
        System.out.println("后继节点2" + bsTree.postNode2(node));
        bsTree.inOrder();
        System.out.println("=====树的详细信息");
        bsTree.print(bsTree.mRoot,bsTree.mRoot.key,-1);
    }
}
