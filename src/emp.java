package src;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class emp {
    public int[] searchRange(int[] nums, int target) {
        List<Integer> list  =  new ArrayList<Integer>();
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == target)
                list.add(i);
        }
        int[] arr = {-1,-1};
        if(list.size() ==0)
            return arr;
        else{
            arr[0] = list.get(0);
            arr[1] = list.get(list.size()-1);
            return arr;
        }

    }
}
