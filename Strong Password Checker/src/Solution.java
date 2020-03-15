public class Solution {
    /*
    A password is considered strong if below conditions are all met:

    It has at least 6 characters and at most 20 characters.
    It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
    It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
    Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password.
    If s is already strong, return 0.

    Insertion, deletion or replace of any one character are all considered as one change.
     */

    /**
     * Going through the string array and check each character to see if it meets requirement.
     * @param s
     * @return
     */
    public int strongPasswordChecker(String s) {
        int lengthChecker = s.length() > 6 && s.length() < 20 ? 0 : 1;

        int lowerChecker = 0, upperChecker = 0, digChecker = 0, nonDigChecker = 0, repChecker = 0;
        String[] arr = s.split("");
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].matches("[a-z]")) {
                lowerChecker +=1;
            } else if(arr[i].matches("[A-Z]")) {
                upperChecker += 1;
            } else if(arr[i].matches("[0-9]")) {
                digChecker += 1;
            } else {
                nonDigChecker +=1;
            }

            if(i + 2 < arr.length && arr[i].equals(arr[i + 1]) && arr[i].equals(arr[i + 2])) {
                repChecker += 1;
            }
        }
        int charChecker = lowerChecker > 0 && upperChecker > 0 && digChecker > 0 && nonDigChecker > 0 ? 0 : 1;
        repChecker = repChecker > 0 ? 1 : 0;

        return lengthChecker + charChecker + repChecker;
    }
}
