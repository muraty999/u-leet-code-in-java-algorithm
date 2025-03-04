package PART03_STRINGS;

public class ReserveString {

    public String reverse(String in) {

        char [] chars = in.toCharArray();

        int i = 0, j = chars.length -1;
        char t;
        while (i <= j) {
            t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            i++;
            j--;
        }

        in = new String(chars);

        return in;
    }

    public static void main(String[] args) {
        System.out.println(new ReserveString().reverse("welcome"));        
    }
    
}

