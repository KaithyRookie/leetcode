package algorithm.MiddleQuestion;

/**
 * Leetcode 盛最多水的容器
 * @author kaithy.xu
 * @date 2019-08-26 12:22
 */
public class LargestCapacytyCollection {

    /**
     * 头尾指针向中间移动，每次只让最小的元素对应的指针向中间移
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i =0 , j=height.length-1;
        int maxCapacity = -1;
        while (i < j){
            maxCapacity = Math.max(Math.min(height[i],height[j]) * (j-i),maxCapacity);
            if(height[i] < height[j]){
                i++;
            }else {
                j--;
            }
        }

        return maxCapacity;
    }

    /**
     * 暴力方式遍历所有可能找到面积最大值
     * @param height
     * @return
     */
    public int maxArea2(int[] height){
        int maxArea = -1;
        for (int i = 0; i < height.length ; i++) {
            for (int j = height.length -1 ; j > i; j--) {
                int area = (j-i) * Math.min(height[j],height[i]);
                maxArea = Math.max(area,maxArea);
            }
        }
        return maxArea;
    }






    public static void main(String[] args) {
        int[] height = {2,3,4,5,18,17,6};
        LargestCapacytyCollection capacytyCollection = new LargestCapacytyCollection();
        System.out.println("result is "+capacytyCollection.maxArea2(height));
    }
}
