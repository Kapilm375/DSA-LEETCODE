class Solution {
    public int findPeakElement(int[] nums) {
     for(int i=0; i<nums.length-1; i=i+1 ){
        if(nums[i]>nums[i+1]){
            return i;
        }
        
     }
     return nums.length-1;
     }
}