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
                switch(token) {
                    case "+":
                        result = n1 + n2;
                        break;
                    case "*":
                        result = n1 * n2;
                        break;
                    case "/":
                        result = n2 / n1;
                        break;
                    case "-":
                        result = n2 - n1;
                        break;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}