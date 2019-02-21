public class Solution {
    public int trap(final List<Integer> A) {
        Stack<Integer>s = new Stack();
        int water = 0;
        for(int i = 0; i < A.size(); i++)
        {
            if(s.empty() || A.get(i) <= A.get(s.peek()))
                s.push(i);
            else
            {
                while(!s.empty() && A.get(s.peek()) < A.get(i))
                {
                    int j = s.pop();
                    if(!s.empty())
                    {
                    water+= (Math.min(A.get(i),A.get(s.peek()))*(i - s.peek() - 1)) - ((i-s.peek()-1)*A.get(j));
                    }
                }
               s.push(i); 
            }
        }
        return water;
    }
}
