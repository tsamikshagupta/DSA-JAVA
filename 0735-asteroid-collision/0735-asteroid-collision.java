class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int a : asteroids) {
            boolean des = false;
            while (!st.isEmpty() && st.peek() > 0 && a < 0) {
                if (st.peek() < -a) {
                    st.pop(); 
                } else if (st.peek() == -a) {
                    st.pop(); 
                    des = true;
                    break;
                } else {
                    des = true; 
                    break;
                }
            }

            if (!des) {
                st.push(a);
            }
        }
        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;
    }
}