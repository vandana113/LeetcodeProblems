class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String [] directory = path.split("/");
        StringBuilder result = new StringBuilder();
    
        for(int i=0; i<directory.length; i++) {
            if(directory[i].equals(".") || directory[i].isEmpty()) {
                continue;
            } else if(directory[i].equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                } 
            } else {
                stack.push(directory[i]);
            }
        }

        for(String str: stack) {
            result.append("/");
            result.append(str);
        }

        return result.length()>0 ? result.toString() : "/";
    }
}