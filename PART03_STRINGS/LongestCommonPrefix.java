package PART03_STRINGS;

public class LongestCommonPrefix {

    public String findLongestMe(String[] array) {

        String pre = ""; //prefix
        char c = 0;

        boolean go = true;
        int p = 0; //position
        while (go) {
            c = 0;
            for (String str : array) {
                if (p > str.length() - 1) {
                    go = false;
                    break;    
                }
                
                char cat = str.charAt(p); 
                if (c != 0 && (c != cat)) {
                    go = false;
                    break;    
                }
                c = cat;
            }
            if (go)
                pre = pre + c; 

            p++;
        }
        
        return pre;
    }

    public String findLongest(String[] array) {

        if (array.length == 0)
            return "";
        
        String pre = array[0]; //prefix
        
        for (int i = 1; i < array.length; i++) {
            String next = array[i];
            while (!pre.isEmpty() && !next.startsWith(pre))
                pre = pre.substring(0, pre.length() - 1);
            
            if (pre.isEmpty())
                break;
        }
        
        return pre;

    } // TC: O(m*n) SC: O(1)

    public static void main(String[] args) {
        //System.out.println(new LongestCommonPrefix().findLongestMe(new String[] {"welcome","well","wellington"}));        
        System.out.println(new LongestCommonPrefix().findLongest(new String[] {"welcome","well","wellington"}));        
    }
    
}

