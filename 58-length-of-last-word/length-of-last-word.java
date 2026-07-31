class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();               // Remove leading and trailing spaces
        int asp = s.lastIndexOf(' ');
        return s.length() - asp - 1;
    }
}