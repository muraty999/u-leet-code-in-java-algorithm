package PART02_INTEGERS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SingleNumber {    
    public int findSingleMe(int [] nums) {
        //find smallest
        int s = nums[0];
        for (int i = 0; i < nums.length; i++)
            if (nums[i] < s) s = nums[i];
        
        //constant value not in array
        s--;
                
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != s) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == nums[i]) {
                        nums[j] = s;
                        nums[i] = s;
                        break;                    
                    }
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != s) {
                s = nums[i];
                break;
            }
        }

        return s;
    }

    public int findSingleSolutionOne(int [] nums) {
        if (nums.length == 1)
            return nums[0];

        HashSet<Integer> mySet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (mySet.contains(nums[i]))
                mySet.remove(nums[i]);
            else
                mySet.add(nums[i]);
        }

        return mySet.iterator().next();
    }

    public int findSingleOptimumSolution(int [] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) 
            result = result ^ nums[i];

        return result;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();

        //int [] myIntArray = new int [] {1, 2, 2, 1, 4, 5, 5, 6, 7, 8, 9, 22, 8, 7, 6, 22, 9, 10, 10, 20, 20, 30, 30, 31, 31, 32, 32, 33, 33, 34, 34, 35, 35};

        // large array for comparison
        List<Integer> myList = new ArrayList<>();
        myList.add(7);
        for (int i = 8; i < 1000000; i = i + 10)
            myList.add(i);
        for (int i = 8; i < 1000000; i = i + 10)
            myList.add(i);

        int [] myIntArray = new int[myList.size()];
        for (int i = 0; i < myList.size(); i++)
            myIntArray[i] = myList.get(i);
        
        int result;
        long b, e;
        
        b = System.currentTimeMillis();
        result = singleNumber.findSingleMe(myIntArray);
        e = System.currentTimeMillis();
        System.out.println("Result: " + result+" - Time: " + (e-b));
        System.out.println();

        b = System.currentTimeMillis();
        result = singleNumber.findSingleSolutionOne(myIntArray);
        e = System.currentTimeMillis();
        System.out.println("Result: " + result+" - Time: " + (e-b));
        System.out.println();

        b = System.currentTimeMillis();
        result = singleNumber.findSingleOptimumSolution(myIntArray);
        e = System.currentTimeMillis();
        System.out.println("Result: " + result+" - Time: " + (e-b));
    }

} // TC: O(n), SC: O(n)F
