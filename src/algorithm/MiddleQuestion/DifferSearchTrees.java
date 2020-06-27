package algorithm.MiddleQuestion;

import basic.TreeNode;

/**
 * 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 解题思路：
 * 动态规划，求状态转移方程
 * 设G(n) 为长度为n的二叉搜索树个数 F(i,n) 是根节点为i的二叉搜索树个数
 * 由此可知 G(n) = F(1,n)+F(2,n)+...+F(n,n) 因为根节点不同，所以所有节点都是不同的
 * 对于F(i,n)，是以[1,i-1]构成的左子树个数 与 [i+1, n]构成的右子树个数的乘积,[1,i-1]构成的左子树个数等于 G(i-1), [i+1, n]构成的右子树个数 G(n-i)
 * 所以 F(i,n) = G(i-1) * G(n-i)
 *
 * 因为当n=0时为空树，n=1时只有树根 G(0)=1 G(1)=1
 * 综上 G(n) = G(1-1) * G(n-1) + G(2-1) * G(n-2) + ... + G(n-1) * G(n-n)
 *
 * 所以可以迭代
 * G(0)=1
 * G(1)=1
 * G(2)=G(1-1)*G(2-1) + G(2-1) * G(2-2) = G(0)*G(1) + G(1)*G(0) = 2
 * G(3)=G(1-1)*G(3-1) + G(2-1) * G(3-2) + G(3-1)*G(3-3) =  G(0)*G(2) + G(1)*G(1) + G(2) * G(0) = 5
 *
 * @author kaithy.xu
 * @date 2020-06-09 20:39
 */
public class DifferSearchTrees {


    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;


        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += G[j-1]*G[i-j];
            }
            G[i] = sum;
        }

        return G[n];

    }





    public static void main(String[] args) {
        DifferSearchTrees searchTrees = new DifferSearchTrees();
        int result = searchTrees.numTrees(4);

        System.out.println("result: "+result);
    }

}
