package leetcode.code_0031_0040;

public class Code_0038_Count_and_Say {

    public static void main(String[] args) {
        System.out.println(Solution.countAndSay(1));
        System.out.println(Solution.countAndSay(2));
        System.out.println(Solution.countAndSay(3));
        System.out.println(Solution.countAndSay(4));
        System.out.println(Solution.countAndSay(5));
        System.out.println(Solution.countAndSay(6));
}

    static class Solution {
        public static String countAndSay(int n) {
            if (n <= 1) {
                return "1";
            }

            String priorString = countAndSay(--n);

            char[] priorCharArray = priorString.toCharArray();
            StringBuilder sb = new StringBuilder();
            int count = 1;
            Character prior = priorCharArray[0];
            for (int i = 1; i < priorCharArray.length; i++) {
                if (priorCharArray[i] == prior) {
                    count++;
                } else {
                    sb.append(count);   // count
                    sb.append(prior);   // char
                    count = 1;
                    prior = priorCharArray[i];
                }
            }

            // last one
            sb.append(count);
            sb.append(prior);

            return sb.toString();
        }
    }
}
