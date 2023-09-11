class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) {
            return true;
        }
        Map<Character, Character> mappings = mappings();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if(mappings.containsKey(cc)) {
                char top = stack.isEmpty() ? '#' : stack.pop();
                if(mappings.get(cc) != top) {
                    return false;
                }
            } else {   
                stack.push(cc);
            }
        }
        return stack.isEmpty();
    }

    public Map<Character, Character> mappings() {
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        return map;
    }
}