class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if(cc == ')' || cc == ']' || cc == '}') {
            char top = stack.isEmpty() ? '#' : stack.pop();

                if(cc == ')' && top != '(') {
                    return false;
                }
                if(cc == ']' && top != '[') {
                    return false;
                }
                if(cc == '}' && top != '{') {
                    return false;
                }
            } else {   
                stack.push(cc);
            }
            
        }
        return stack.isEmpty();
    }
}