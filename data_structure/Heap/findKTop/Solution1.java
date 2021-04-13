package findKTop;

public class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        // 1.将数组构建为一个最大堆
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        // 2. 取出前K值，返回最后一个取出来的值
        for (int i = 0; i < k-1; i++) {
            swap(nums,0, heapSize-1);
            --heapSize;
            heapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, i, heapSize);
        }
    }


    private void heapify(int[] nums, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && nums[l] > nums[largest]){
            largest = l;
        }

        if (r < heapSize && nums[r] > nums[largest]){
            largest = r;
        }

        if (largest != i){
            swap(nums, i, largest);
            heapify(nums, largest, heapSize);
        }
    }



    private void swap(int[] nums, int i, int largest) {
        int temp = nums[i];
        nums[i] = nums[largest];
        nums[largest] = temp;
    }


}
