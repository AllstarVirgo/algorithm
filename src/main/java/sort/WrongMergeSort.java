package sort;

public class WrongMergeSort {

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(nums, left , mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int pl = left, pr = mid + 1;
        for(int i = 0; i < temp.length; i++){
            if(pl > mid){
                temp[i] = nums[pr];
            } else if ( pr > right){
                temp[i] = nums[pl];
            } else {
                temp[i] = Math.min(nums[pl], nums[pr]);
                if(temp[i] == nums[pl]){
                    pl++;
                } else {
                    pr++;
                }
            }
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
    }

}
