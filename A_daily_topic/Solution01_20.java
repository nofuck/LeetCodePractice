public class Solution01_20 {
    public boolean stoneGameIX(int[] stones) {
        int num[] = new int[3];
        int n = stones.length;
        for(int i = 0;i < stones.length;i++){
            num[stones[i]%3]++;
        }
        boolean flag = false;
        if(num[0]%2==0){
            if(num[1]>=1&&num[2]>=1)flag = true;
        }else if(Math.abs(num[1]-num[2])>2)flag = true;
        return flag;
    }
}
