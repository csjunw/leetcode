package src;

import java.util.Queue;
import java.util.Stack;

public class Leetcode232 {
    class MyQueue {
        private Stack<Integer> s1,s2;

        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            s2.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            this.peek();
            return s1.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(s1.isEmpty())
                while(!s2.isEmpty())
                    s1.push(s2.pop());
            return s1.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}
