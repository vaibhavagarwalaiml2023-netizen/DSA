class Solution {
    public int digitFrequencyScore(int n) {
        int s =0;
        while(n>0){
            int d=n%10;
            s=s+d*1;
            n=n/10;
        }
       return s; 
    }
}