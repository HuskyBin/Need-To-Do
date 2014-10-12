/*
Given an integer, find the next biggest integer whose digits are in increasing order.

Example:
Input: 118
Output: 123

Input: 127
Output: 234

Input: 987
Output: 1234
*/
public class NextLargerNumber {
    public static void main(String[] args) {
        NextLargerNumber obj = new NextLargerNumber();
        int result = obj.findNextLargetNum(91);
        System.out.println(result);
    }

    public int findNextLargetNum(int num) {
        if (num <= 0) {
            return -1;
        }

        String str = String.valueOf(num);
        int index = 0;
        while (index < str.length() - 1) {
            char curChar = str.charAt(index);
            char nextChar = str.charAt(index + 1);
            if (Character.getNumericValue(curChar) + 1 < Character.getNumericValue(nextChar)) {
                String result =  getResultWithChangeFirstChar(str);
                int nextInt = Integer.parseInt(result);
                return nextInt;
            }
            else if (Character.getNumericValue(curChar) + 1 > Character.getNumericValue(nextChar)) {
                String result = getResultWithoutChangeFirstChar(str);
                int nextInt = Integer.parseInt(result);
                return nextInt;
            }
            index++;
        }
        String result = getResultWithChangeFirstChar(str);
        int nextInt = Integer.parseInt(result);
        return nextInt;
    }


    private String getResultWithoutChangeFirstChar(String str) {
        if (Character.getNumericValue(str.charAt(0)) + str.length() > 9) {
            return getResultWithChangeFirstChar(str);
        }
        StringBuilder sb = new StringBuilder();
        char firstChar = str.charAt(0);
        int length = str.length();
        while (length > 0) {
            sb.append(firstChar);
            firstChar = (char)(firstChar + 1);
            length--;
        }
        return sb.toString();
    }

    private String getResultWithChangeFirstChar(String str) {
        int length = str.length();
        char firstChar = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        if (Character.getNumericValue(str.charAt(0)) + str.length() > 9) {
            length = length + 1;
            firstChar = '1';
        }
        else {
            firstChar = (char)(firstChar + 1);
        }

        while (length > 0) {
            sb.append(firstChar);
            firstChar = (char)(firstChar + 1);
            length--;
        }
        return sb.toString();
    }



}
