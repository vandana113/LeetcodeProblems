class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String [] directory = path.split("/");
        String result = "";
      

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

        while(!stack.isEmpty()) {
            result=  "/" + stack.pop() + result;
        }

        return result.length()>0 ? result : "/";
    }
}