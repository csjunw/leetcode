package src;

import java.util.ArrayList;
import java.util.List;

public class Leetcode34 {

    public int[] searchRange(int[] nums, int target)
    {

        ////暴力解法
        // List<Integer> list  =  new ArrayList<Integer>();
        // for(int i = 0; i< nums.length; i++){
        //     if(nums[i] == target)
        //         list.add(i);
        // }
        // int[] arr = {-1,-1};
        // if(list.size() ==0)
        //     return arr;
        // else{
        //     arr[0] = list.get(0);
        //     arr[1] = list.get(list.size()-1);
        //     return arr;
        // }

//        //这种方式比较好，找到左界，然后向后找
//        int[] arr ={-1,-1};
//        int left = 0, right = nums.length-1;
//        while(left <= right)
//        {
//            int mid = left + (right - left)/2;
//            if(nums[mid] < target)
//                left = mid +1;
//            else if(nums[mid] > target)
//                right = mid-1;
//            else if(nums[mid] == target)
//                right = mid-1;
//        }
//        if(left > nums.length -1 || nums[left]!=target)
//            return arr;
//        arr[0] = left;
//        for(int i = left+1; i< nums.length; i++)
//        {
//            if(nums[i]!=target)
//            {
//                arr[1]=i-1;
//                return arr;
//            }
//        }
//        arr[1] = nums.length-1;
//        return arr;

        //都可以
        int[] arr ={-1,-1};
        int left = 0, right = nums.length-1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] < target)
                left = mid +1;
            else if(nums[mid] > target)
                right = mid-1;
            else if(nums[mid] == target)
                right = mid-1;
        }
        if(left > nums.length -1 || nums[left]!=target)
            return arr;
        arr[0] = left;
        int left1 = 0, right1 = nums.length-1;
        while(left1 <= right1)
        {
            int mid1 = left1 + (right1 - left1)/2;
            if(nums[mid1] < target)
                left1 = mid1 +1;
            else if(nums[mid1] > target)
                right1 = mid1-1;
            else if(nums[mid1] == target)
                left = mid1+1;
        }
        arr[1] = right1;
        return arr;
    }
}
