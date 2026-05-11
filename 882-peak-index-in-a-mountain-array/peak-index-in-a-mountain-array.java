class Solution {
    public int peakIndexInMountainArray(int[] arr) {
     int n = arr.length;
     int l = 0, h = n-1;
     while(h>l){
        int mid = ( l+h )/2;
        if(arr[mid]>arr[mid+1]) h = mid;
        else l= mid+1;
     }   
     return h;
}
}