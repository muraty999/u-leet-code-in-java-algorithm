package PART02_INTEGERS;

public class Palindrome {
    public boolean isPalindrome(int i) {
        
        if (i < 0)
            return false;

        if (i != 0 && i % 10 == 0)
            return false;

        int n = 0; //n: new number (half of i)

        do {
            n = n * 10 + (i % 10);
            i = i / 10;

        } while (i > n);

        return (i == n || (n / 10 == i));
    } // TC: O(log x base 10), SC: O(1)

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(12321));
    }
}


