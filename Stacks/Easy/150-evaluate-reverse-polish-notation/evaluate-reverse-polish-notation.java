class Solution {
    
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> evaluators = new HashSet<>();
        evaluators.add("+");
        evaluators.add("-");
        evaluators.add("*");
        evaluators.add("/");

        for(String token: tokens) {
            if(evaluators.contains(token)) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                int result = 0;
                if(token.equals("+")) {
                    result = n1 + n2;
                } else if(token.equals("*")) {
                    result = n1 * n2;
                } else if(token.equals("/")) {
                    result = n2 / n1;
                } else if(token.equals("-")) {
                    result = n2 - n1;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}