package src;

public class Leetcode1011 {
    public int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights), right = getSum(weights)+1; //左界也非常重要
        while(left <right){
            int mid = left +(right -left)/2;
            if(canWeight(weights,mid,D))
                right = mid;
            else
                left = mid+1;
        }
        return left;

    }

    private int getMax(int[] weights) {
        int max = 0;
        for (int pile : weights) {
            max = Math.max(pile, max);
        }
        return max;
    }

    boolean canWeight(int[] weights,int mid, int D)
    {
        int time=1;
        int sum = 0;
        for(int weight :weights){
            sum +=weight;
            if(sum>mid){
                time++;//
                sum =weight;
            }
        }
        return time <= D;
    }

    int getSum(int[] weights)
    {
        int sum = 0;
        for(int weight : weights)
        {
            sum +=weight;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1};
        new Leetcode1011().shipWithinDays(arr,4);
    }

}
