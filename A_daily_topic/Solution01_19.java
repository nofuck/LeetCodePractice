import java.util.HashMap;
import java.util.Map;

public class Solution01_19 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        boolean ans = false;
        for(int i = 0;i < nums.length;++i){
            if(mp.get(nums[i])==null){
                mp.put(nums[i],i);
            }else{
                if(i-mp.get(nums[i])<=k)ans = true;
                mp.put(nums[i],i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution01_19 x = new Solution01_19();
        int[]nums = {1,2,3,1,2,3};
        System.out.println(x.containsNearbyDuplicate(nums, 2));
    }
}
