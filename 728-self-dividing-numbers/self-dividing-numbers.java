class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> ans = new ArrayList<>();

        for(int i = left; i <= right; i++) {
            int num = i;
            boolean flag = true;

            while(num > 0) {
                int div = num % 10;

                if(div == 0 || i % div != 0) {
                    flag = false;
                    break;
                }

                num = num / 10;
            }

            if(flag) {
                ans.add(i);
            }
        }

        return ans;
    }
}
