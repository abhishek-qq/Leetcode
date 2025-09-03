import java.util.HashMap;
import java.util.Map;

/**
 *  Two Sum is the classic problem from leetcode
 *
 *  Given an array of integers nums and an integer target,
 *  return indices of the two numbers such that they add up to target.
 *
 *  You may assume that each input would have exactly one solution,
 *  and you may not use the same element twice.
 *
 *  You can return the answer in any order
 *
 *  example :
 *  Input: nums = [2,7,11,15], target = 9
 *  Output: [0,1]
 *  Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 *
 *  below you will find out the solution in java. there are two ways :
 *  brute force and hash table
 */


public class TwoSum {

    public static void main(String[] args) {
        int nums[] = {2,12,11,15,7};
        int target = 9 ;

       int result [] =  bruteForceSolution(nums,target);
        System.out.println(result[0]);
        System.out.println(result[1]);


        int resultFromOptimizedFunction [] =  optimizedSoltuion(nums,target);
        System.out.println(resultFromOptimizedFunction[0]);
        System.out.println(resultFromOptimizedFunction[1]);
    }

    /**
     * Due to nested loop in this function its time complexity is more near about 0(N^2)
     * WE CAN TRY OPTIMIZING THIS SOLUTION
     */

    private static int[] bruteForceSolution(int[] nums, int target) {

        int n = nums.length;
        int result [] = {-1,-1};
        for (int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(nums[i] + nums[j] ==  target) {
                    return new int [] {i,j};
                }
            }
        }
        return result;
    }


    private static int [] optimizedSoltuion(int [] nums, int target) {
        int n = nums.length;
        Map<Integer,Integer> comp = new HashMap<>();

        for(int i =0; i<n; i++) {
            int compliment = target - nums[i];
            if(comp.containsKey(compliment)) {
                return new int[] {i, comp.get(compliment)};
            }
            comp.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }
}
