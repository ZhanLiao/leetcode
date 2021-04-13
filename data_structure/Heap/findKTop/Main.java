package findKTop;

public class Main {
    public static void main(String[] args) {
        System.out.println("查找数组中第K个最大数");

        int k = 4;
//        int[] nums = {3,2,3,1,2,4,5,5,6};
        int[] nums = {3,2,1,5,6,4};
//        Solution solution = new Solution();
        Solution1 solution = new Solution1();
        System.out.println(solution.findKthLargest(nums, k));

//        solution.quicklySortByDec(nums, 0, nums.length-1);
//        System.out.println(Arrays.toString(nums));


    }
}
