package algorithm.HardQuestion;

/**
 * @author kaithy.xu
 * @date 2019-08-23 12:09
 */
public class FindMedianNum {

    private int firstNum;
    private int secondNum;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int medianLocation = (nums1.length+nums2.length) >> 1;
        int nextMedianLocation = medianLocation;
        if((nums1.length+nums2.length)%2 ==0){
            medianLocation = medianLocation-1;
        }
        if(nums1.length == 0){
            return Double.valueOf(nums2[medianLocation]+nums2[nextMedianLocation]) /2;
        }else if(nums2.length == 0){
            return Double.valueOf(nums1[medianLocation]+nums1[nextMedianLocation]) /2;
        }

        return solution4(nums1,nums2);
//        return solution3(nums1,nums2,medianLocation,nextMedianLocation);
//       return sortedArray(nums1,nums2,medianLocation,nextMedianLocation);

    }

    /**
     * 利用一个临时数组求中位数
     * @param nums1
     * @param nums2
     * @param medianLocation
     * @param nextMediaLocation
     * @return
     */
    private double sortedArray(int[] nums1, int[] nums2, int medianLocation, int nextMediaLocation){

        int[] temp = new int[nextMediaLocation];
        int i=0, j=0;
        int index = 0;
        while (index <= nextMediaLocation){
            while ( index <= nextMediaLocation && i < nums1.length && nums1[i] <= nums2[j]){
                temp[index++] = nums1[i++];
            }
            if(i >= nums1.length){
                break;
            }
            while (index <= nextMediaLocation && j < nums2.length && nums2[j] < nums1[i]){
                temp[index++] = nums2[j++];

            }
            if(j >= nums2.length){
                break;
            }
        }
        if(nextMediaLocation < index){
            return Double.valueOf(temp[medianLocation] + temp[nextMediaLocation]) / 2.0;
        }else if(medianLocation < index){
            if( i >= nums1.length){
                return Double.valueOf(temp[medianLocation] + nums2[j]) / 2.0;
            }else {
                return Double.valueOf(temp[medianLocation] + nums1[i]) / 2.0;
            }

        }else {
            if( i >= nums1.length){
                return Double.valueOf(nums2[j + medianLocation - index] + nums2[j + nextMediaLocation - index]) / 2.0;
            }else {
                return Double.valueOf(nums1[i + medianLocation - index] + nums1[i + nextMediaLocation - index]) / 2.0;
            }

        }


    }


    /**
     * 利用两个变量保存中间位置的数值
     * @param nums1
     * @param nums2
     * @param medianLocation
     * @param nextMediaLocation
     * @return
     */
    private double Solution2(int[] nums1, int[] nums2, int medianLocation, int nextMediaLocation){
        int first = -1, next = -1;
        int i = 0,j=0;
        for (; i < nums1.length && j < nums2.length && (i + j) <= nextMediaLocation;) {
            if(nums1[i] < nums2[j]){
                if(i+j == medianLocation){
                    first = nums1[i];
                }
                if(i+j == nextMediaLocation){
                    next = nums1[i];
                }
                i++;

            }else {
                if(i+j == medianLocation){
                    first = nums2[j];
                }
                if(i+j == nextMediaLocation){
                    next = nums2[j];
                }
                j++;

            }

        }
        if(i+j <= medianLocation){
            if( i >= nums1.length){
                first = nums2[medianLocation-i];
                next = nums2[nextMediaLocation-i];
            }else {
                first = nums1[medianLocation-j];
                next = nums1[nextMediaLocation-j];
            }
        }else if(i+j <= nextMediaLocation){
            if( i >= nums1.length){
                next = nums2[nextMediaLocation-i];
            }else {
                next = nums1[nextMediaLocation-j];
            }
        }

        return first+next /2.0;

    }

    /**
     * 利用快排求中位数
     * @param nums1
     * @param nums2
     * @param medianLocation
     * @param nextMediaLocation
     * @return
     */
    private double solution3(int[] nums1, int[] nums2, int medianLocation, int nextMediaLocation){
        int[] merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1,0,merged,0,nums1.length);
        System.arraycopy(nums2,0,merged,nums1.length,nums2.length);
        quickSort(merged,0,merged.length-1);
        return Double.valueOf(merged[medianLocation]+merged[nextMediaLocation]) / 2;
    }
    private void quickSort(int[] merged, int left, int right){

        if(left >= right){
            return;
        }
        int pivot = median(merged, left, right);
        int i = left;
        int j = right-1;
        while (true){

            while ( i < right && merged[++i] < pivot){ }
            while ( j > left && merged[--j] > pivot){ }
            if(i < j){
                swap(merged,i,j);
            }else {
                break;
            }
        }
        if(right-1 != left){
            swap(merged,i,right-1);
        }
        quickSort(merged,left,i-1);
        quickSort(merged,i+1,right);


    }

    private int median(int[] nums, int header, int footer){
        int middle = (header+footer) >> 1;

        if(nums[header] > nums[middle]){
            swap(nums,middle,header);
        }
        if(nums[header] > nums[footer]){
            swap(nums,header,footer);
        }
        if(nums[middle] > nums[footer]){
            swap(nums,footer,middle);
        }
        swap(nums,middle,footer-1);
        return nums[footer-1];
    }

    private void swap(int[] nums, int first, int last){
        int temp = nums[first];
        nums[first] = nums[last];
        nums[last] = temp;
    }

    private double solution4(int[] nums1, int[] nums2){
        int middle1 = 0+nums1.length >> 1;
        int middle2 = 0+nums2.length >> 1;
        int nextMiddle1 = middle1;
        int nextMiddle2 = middle2;
        if((0+nums1.length) % 2 ==0){
            middle1--;
        }
        if((0+nums2.length) % 2 == 0){
            middle2--;
        }
        return (Double.valueOf(nums1[middle1]+nums1[nextMiddle1]) / 4) + (Double.valueOf(nums2[middle2] + nums2[nextMiddle2]) / 4) ;
    }

    public double bestSolution(int[] nums1,int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        if(n > m){
            return bestSolution(nums2,nums1);
        }
        int L1=0,L2=0,R1=0,R2=0,c1=0,c2=0;
        int lo=0;
        int hi = 2*n;
        while (lo <= hi){
            c1 = (lo+hi) >> 1;
            c2 = m+n-c1;
            L1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[(c1-1)/2];
            R1 = (c1 == 2*n) ? Integer.MAX_VALUE : nums1[c1/2];
            L2 = (c2 == 0)? Integer.MIN_VALUE : nums2[(c2-1)/2];
            R2 = (c2 == 2*m) ? Integer.MAX_VALUE : nums2[c2/2];

            if(L1 > R2){
                hi = c1-1;
            }else if(L2 > R1){
                lo = c1+1;
            }else {
                break;
            }

        }

        return (Math.max(L1,L2)+Math.min(R1,R2)) / 2.0;
    }

    public static void main(String[] args) {

        int[] nums1 = {3};
        int[] nums2 = {-2,-1};
        FindMedianNum findMedianNum = new FindMedianNum();

        System.out.println("the result is : "+findMedianNum.bestSolution(nums1,nums2));
    }
}
