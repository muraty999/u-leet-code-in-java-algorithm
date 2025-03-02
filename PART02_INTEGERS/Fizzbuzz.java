package PART02_INTEGERS;
// url: https://leetcode.com/problems/fizz-buzz/description/

import java.util.List;

public class FizzbuzzMe {
    
    public String[] fizzBuzz(int n) {
        String [] result = new String[n];
        
        for (int i = 0; i++ < n; ) {
            boolean div3 = i % 3 == 0;
            boolean div5 = i % 5 == 0;
            
            if (div3 && div5)
                result[i-1] = "FizzBuzz";
            else if (div3)
                result[i-1] = "Fizz";
            else if (div5)
                result[i-1] = "Buzz";
            else result[i-1] = i + "";
        }
        
        return result;
    }

    public static void main(String[] args) {
        System.out.println(List.of(new FizzbuzzMe().fizzBuzz(20)));
    }
} // TC: O(n), SC: O(n)F

