class Solution {
    public boolean checkPerfectNumber(int num) {
        float half = num/2;
        int sum=0;
        for(int i =1;i<=half;i++){
            if(num % i == 0){
                sum=sum+ i;
            }
        }
        return(sum==num);
        
    }
}