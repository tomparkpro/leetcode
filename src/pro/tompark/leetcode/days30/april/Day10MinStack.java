package pro.tompark.leetcode.days30.april;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 */
public class Day10MinStack {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public static void main(String[] args) {
        int result = 0;

        MinStack obj = new MinStack();
//        obj.push(-2);
//        obj.push(0);
//        obj.push(-3);
//        result = obj.getMin();
//        obj.pop();
//        result = obj.top();
//        result = obj.getMin();

        obj.push(2147483646);
        obj.push(2147483646);
        obj.push(2147483647);
        int top = obj.top();
        obj.pop();
        int min = obj.getMin();
        obj.pop();
        int min1 = obj.getMin();
        obj.pop();
        obj.push(2147483647);
        int top1 = obj.top();
        int min2 = obj.getMin();
        obj.push(-2147483648);
        int top2 = obj.top();
        int min3 = obj.getMin();
        obj.pop();
        int min4 = obj.getMin();
    }

    static class MinStack {
        private Node stack;
        private int min = Integer.MAX_VALUE;

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            Node node = new Node(x);
            if (x < min) {
                min = x;
            } else {
                node.setMin(min);
            }

            if (stack != null) {
                node.setPre(stack);
            }
            stack = node;
        }

        public void pop() {
            if (stack != null) {
                Node pre = stack.getPre();
                if (pre != null) {
                    min = pre.getMin();
                } else {
                    min = Integer.MAX_VALUE;
                }
                stack = pre;
            }
        }

        public int top() {
            if (stack != null) {
                return stack.getValue();
            } else {
                return 0;
            }
        }

        public int getMin() {
            if (stack != null) {
                return min;
            } else {
                return 0;
            }
        }
    }

    static class Node {
        private int value;
        private int min;
        private Node pre;

        public Node(int value) {
            this.value = value;
            this.min = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }
    }
}
