public class Solution01_18 {
    int []num1;
    int []num2;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        num1 = nums1;
        num2 = nums2;
        double ans = 0;
        return ans;
    }

    int dfs(int l1,int r1,int l2,int r2,int k){
        if(l1>r1)return num2[l2+k-1];
        if(l2>r2)return num1[l1+k-1];
        if(k==1)return Math.min(num1[l1],num2[l2]);
        int _k = k/2;
        int ans = -1;
        if(l1+_k-1>r1){
            if(num1[r1]<=num2[l2+_k-1]){
                ans = dfs(r1+1,r1,l2,r2,k-(r1-l1+1));
            }else{
                ans = dfs(l1,r1,l2+_k,r2,k-_k);
            }
        }else if(l2+_k-1>r2){
            if(num2[r2]<=num1[l1+_k-1]){
                ans = dfs(l1,r1,r2+1,r2,k-(r2-l2+1));
            }else{
                ans = dfs(l1+_k,r1,l2,r2,k-_k);
            }
        }else{
            if(num1[l1+_k-1]<=num2[l2+_k-1]){
                ans = dfs(l1+_k,r1,l1,r2,k-_k);
            }else{
                ans = dfs(l1,r1,l2+_k,r2,k-_k);
            }
        }
        return ans;
    }
}
