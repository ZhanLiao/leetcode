package findKTop;

/**
 * 该解法超时
 * 1.创建一个长度为K的数组maxArray
 * 2.遍历原数组，小于K时候将元素添加到新数组，大于K的时候，先将新数组降序
 * 3.判断当前值是否小于maxArray[k-1],继续下一个，大于或者等于，替换为新值。
 * 4.最后遍历结束之后还需要一次降序。
 *
 * 主要是排序废时间。
 */
class Solution {

    public int findKthLargest(int[] nums, int k) {
        int[] maxArray = new int[k];
        for(int i = 0; i < nums.length; i++){
            if(i < k){
                maxArray[i] = nums[i];
            }else {
//                sort(maxArray); //降序
                quicklySortByDec(maxArray, 0, k-1);
                if(nums[i] >= maxArray[k-1]){
                    maxArray[k-1] = nums[i];
                }else{
                    continue;
                }
            }
        }
//        sort(maxArray); //降序
        quicklySortByDec(maxArray, 0, k-1);
        return maxArray[k-1];
    }

    /**
     * 暴利排序
     * @param arr
     */
    private void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public void  quicklySortByDec(int[] arr, int l, int r){
        if (l > r){
            return;
        }
        int temp;
        int i = l;
        int j = r;
        int base = arr[l];
        while (i < j){
            while (base > arr[j] && i < j){
                j--;
            }
            while (base <= arr[i] && i < j){
                i++;
            }
            // q其余情况
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[l] = arr[i];
        arr[i] = base;
        quicklySortByDec(arr, l, j-1);
        quicklySortByDec(arr, j+1, r);
    }
}