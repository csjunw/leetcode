package src;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode225 {
        class MyStack {
            private Queue<Integer> s1;
            int temp= 0; //栈顶元素

            /** Initialize your data structure here. */
            public MyStack() {

                s1 = new LinkedList<>();
            }

            /** Push element x onto stack. */
            public void push(int x) {
                s1.offer(x);
                temp =x;
            }

            /** Removes the element on top of the stack and returns that element. */
            public int pop() {
                int size = s1.size();
                while(size >2){
                    s1.offer(s1.poll());
                    size--;
                }
                temp = s1.peek();
                s1.offer(s1.poll());
                return s1.poll();
            }

            /** Get the top element. */
            public int top() {
                return temp;

            }

            /** Returns whether the stack is empty. */
            public boolean empty() {
                return s1.isEmpty();
            }
        }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
