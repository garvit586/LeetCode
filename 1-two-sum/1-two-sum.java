class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int size  = nums.length;
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                if(nums[i]+nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }
        return arr;
    }
}