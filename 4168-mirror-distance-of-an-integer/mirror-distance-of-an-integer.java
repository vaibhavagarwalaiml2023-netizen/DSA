class Solution {
    public int mirrorDistance(int n) {
        int original = n;
        int s=0;
        while(n>0){
            int d=n%10;
            s=s*10+d;
            n=n/10;

        }
        
        return(Math.abs(original-s));
        
    }
}