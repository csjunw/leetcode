package src;

import java.time.chrono.MinguoEra;

public class Leetcode875 {
    public int minEatingSpeed(int[] piles, int h) {
        //超时，需要用二分查找
        // int K=0;

        // for(int i =1; i<getMax(piles); i++)
        // {
        //     int sum=0;
        //     for (int pile : piles) {
        //         sum+=pile/i>0 ?(pile%i > 0? pile/i+1 : pile/i) : 1;
        //         if(sum > h)
        //             break;
        //     }
        //     if(sum <= h)
        //         return i;
        // }
        // return getMax(piles);
        int left =1,right = getMax(piles);
        while(left < right){
            int mid = left + (right - left)/2;
            if(canEating(piles,mid,h))
                right = mid;
            else{
                left = mid +1;
            }
        }
        return left;
    }
    boolean canEating(int[] piles, int mid , int h ){
        int sum = 0;
        for(int pile : piles){
            sum += (pile/mid) + ((pile%mid)>0? 1:0);
            if(sum > h)
                break;
        }
        return sum <= h;
    }
    int getMax(int[] piles){
        int max = 0;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr ={30,11,23,4,20};
        new Leetcode875().minEatingSpeed(arr, 5);
    }

}
