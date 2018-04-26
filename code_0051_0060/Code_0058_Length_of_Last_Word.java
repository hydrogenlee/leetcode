package leetcode.code_0051_0060;

public class Code_0058_Length_of_Last_Word {
    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLastWord(""));                  // 0
        System.out.println(Solution.lengthOfLastWord(" "));                 // 0
        System.out.println(Solution.lengthOfLastWord("Hello World"));       // 5
        System.out.println(Solution.lengthOfLastWord(" Hello World"));      // 5
        System.out.println(Solution.lengthOfLastWord("Hello World "));      // 5
        System.out.println(Solution.lengthOfLastWord("Hello  World"));      // 5
        System.out.println(Solution.lengthOfLastWord("Hello    World"));    // 5
        System.out.println(Solution.lengthOfLastWord("Hello World III"));   // 3
    }
    static class Solution {
        public static int lengthOfLastWord(String s) {
            if (s == null || "".equals(s.trim())) {
                return 0;
            }
            String trimmedString = s.trim();
            int lastWordLen = 0;
            for (int i = 0; i < trimmedString.length(); i++) {
                if (trimmedString.charAt(i) == ' ') {
                    lastWordLen = 0;
                } else {
                    lastWordLen++;
                }
            }
            return lastWordLen;
        }
    }
}
