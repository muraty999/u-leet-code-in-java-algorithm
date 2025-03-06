package PART03_STRINGS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequence {
          
    public String[] listSequences(String str) {
        Set<String> resultSet = new HashSet<>();

        if (str.length() > 10) {
            Set<String>  set = new HashSet<>();
            
            int n = str.length() - 10;
            for (int i = 0; i <= n; i++) {
                String s = str.substring(i, i + 10);
                if (set.contains(s))
                    resultSet.add(s);
                else
                    set.add(s);
            }
        }

        return (String[]) resultSet.toArray(new String[resultSet.size()]); 
    }
    
    public String[] listSequencesUsingMap(String str) {
        List<String> strList = new ArrayList<>();

        if (str.length() > 10) {
            Map<String, Integer>  mapStrInt = new HashMap<>();
            
            int n = str.length() - 10;
            for (int i = 0; i <= n; i++) {
                String s = str.substring(i, i + 10);
                mapStrInt.put(s, mapStrInt.getOrDefault(s, 0) + 1);
            }

            for (Map.Entry<String,Integer> e: mapStrInt.entrySet()) {
                if (e.getValue() > 1)
                    strList.add(e.getKey());
            }
        }
            
        return (String[]) strList.toArray(new String[strList.size()]); 
    } 

    public static void main(String[] args) {
        System.out.println(List.of(new RepeatedDNASequence().listSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")));
        //System.out.println(List.of(new RepeatedDNASequence().listSequences("AAAAAAAAAAAA")));
        //System.out.println(List.of(new RepeatedDNASequence().listSequencesUsingMap("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")));        
    }    
}

