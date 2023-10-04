class Solution {
    public String removeDuplicateLetters(String s) {
        String result = "";

        HashSet<Character> visited = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> last_occurrence = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            last_occurrence.put(s.charAt(i),i);
        }
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if(!visited.contains(cc)) {
                while(!stack.isEmpty() && cc < stack.peek() && i < last_occurrence.get(stack.peek())) {
                    visited.remove(stack.pop());
                }
                visited.add(cc);
                stack.push(cc);
            }
            
        }

        StringBuilder sb = new StringBuilder(stack.size());
        for(Character c : stack) {
            sb.append(c.charValue());
        }
        // adbc
        // 
        return sb.toString();
    }
}