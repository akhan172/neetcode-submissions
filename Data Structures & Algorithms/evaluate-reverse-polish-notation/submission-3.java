class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String s : tokens) {
            char ch = s.charAt(0);

            if (ch == '+' && s.length() == 1) {
                int a = st.peek();
                st.pop();
                int b = st.peek();
                st.pop();
                st.push(a + b);

            } else if (ch == '-' && s.length() == 1) {
                int a = (int) st.peek();
                st.pop();
                int b = (int) st.peek();
                st.pop();
                st.push(b - a);
            } else if (ch == '/' && s.length() == 1) {
                int a = st.peek();
                st.pop();
                int b = st.peek();
                st.pop();
                st.push(b / a);
            } else if (ch == '*' && s.length() == 1) {
                int a = (int) st.peek();
                st.pop();
                int b = (int) st.peek();
                st.pop();
                st.push(a * b);
            } else {
                int n = Integer.parseInt(s);
                st.push(n);
            }
        }
        return st.peek();
    }
}
