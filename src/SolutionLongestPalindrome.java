public class SolutionLongestPalindrome {
    /**
     * @param s: input string
     * @return: a string as the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        int finalStart = 0;
        int finalEnd = 0;

        for(int i = 0; i < s.length()-1; i++) {
            int currentCenter = i;

            for(int start = currentCenter-1, end = currentCenter+1;
                start >= 0 && end < s.length(); 
                start--, end++) {
                if(!s.substring(start, start+1).equals(s.substring(end, end+1))) {
                    break;
                }
                if(end - start > finalEnd - finalStart) {
                    finalStart = start;
                    finalEnd = end;
                }
            }
            for(int start = currentCenter, end = currentCenter+1;
                start >= 0 && end < s.length();
                start--, end++) {
                if(!s.substring(start, start+1).equals(s.substring(end, end+1))) {
                    break;
                }
                if(end - start > finalEnd - finalStart) {
                    finalStart = start;
                    finalEnd = end;
                }
            }
        }
        if(finalEnd == 0)
            return s.substring(0, 1);
        return s.substring(finalStart, finalEnd+1);
    }
}
