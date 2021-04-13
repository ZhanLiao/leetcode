package isPalindrome;

public class Solution {

    public boolean isPalindrome(String s) {
         int low = 0, hight =s.length() - 1;
        while(low < hight){
            while(low < hight && !Character.isLetterOrDigit(s.charAt(low))){
                ++low;
            }
            while(low <= hight && !Character.isLetterOrDigit(s.charAt(hight))){
                --hight;
            }
            if(low <= hight){
                if(Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(hight))){
                    return false;
                }
                ++low;
                --hight;
            }

        }
        return true;
    }

}
