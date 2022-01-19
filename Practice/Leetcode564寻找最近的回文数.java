import java.util.Map;

public class Leetcode564寻找最近的回文数{
    //找绝对值最近的回文数
    public String nearestPalindromic(String n) {
        long tp_n = Long.valueOf(n);
        String ans = "";
        if(tp_n<10||tp_n==Math.pow(10,n.length()-1)){//10000 || 9
            ans = new Long(tp_n-1).toString();
        }else if(tp_n+1==Math.pow(10,n.length())){//999
            ans = new Long(tp_n+2).toString();
        }else if(tp_n-1==Math.pow(10,n.length()-1)){//10001
            ans = new Long(tp_n-2).toString();
        }else{
            int list[] = {-1,0,1};
            String tp = n.substring(0,(n.length()-1)/2+1);
            long min = Long.MAX_VALUE;
            for(int x:list){
                String res = new Long(Integer.valueOf(tp) + x).toString();
                if(n.length()%2==1){
                    res += new StringBuilder(res.substring(0,res.length()-1)).reverse();
                }else{
                    res += new StringBuilder(res).reverse();
                }
                long xx = Long.valueOf(res);
                long tpx = Math.abs(xx-tp_n);
                if(tpx==0)continue;
                if(tpx<=min){
                    if(tpx==min){
                        ans = Integer.valueOf(ans) > xx ? res : ans;
                    }else ans = res;
                    min = Math.abs(xx-tp_n);
                }
            }
        }
        return ans;
    }

    //找比它大的回文数（待验证）
    public String nearestPalindromic1(String n) {
        long tp_n = Long.valueOf(n);
        String ans = "";
        if(tp_n<9){//10000 || 9
            ans = new Long(tp_n+1).toString();
        }else if(tp_n+1==Math.pow(10,n.length())){//999
            ans = new Long(tp_n+2).toString();
        }else{
            int list[] = {0,1};
            String tp = n.substring(0,(n.length()-1)/2+1);
            long min = Long.MAX_VALUE;
            for(int x:list){
                String res = new Long(Integer.valueOf(tp) + x).toString();
                if(n.length()%2==1){
                    res += new StringBuilder(res.substring(0,res.length()-1)).reverse();
                }else{
                    res += new StringBuilder(res).reverse();
                }
                long xx = Long.valueOf(res);
                long tpx = xx-tp_n;
                if(tpx<=0)continue;
                if(tpx<=min){
                    if(tpx==min){
                        ans = Integer.valueOf(ans) > xx ? res : ans;
                    }else ans = res;
                    min = Math.abs(xx-tp_n);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode564寻找最近的回文数 A = new Leetcode564寻找最近的回文数();
        System.out.println(A.nearestPalindromic1("1000"));
    }
}