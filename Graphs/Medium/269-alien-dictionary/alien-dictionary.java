class Solution {

    class Alpha {
        char c;
        Set<Alpha> next;
        Alpha(char c){
            this.c = c;
            this.next = new HashSet<>();
        }
    }
    public String alienOrder(String[] words) {
        Alpha [] chars = new Alpha[26];
        for(int i=0; i<words.length; i++) {
            for(int j=0; j<words[i].length(); j++) {
                char cc = words[i].charAt(j);
                if(chars[cc - 'a'] == null) {
                    chars[cc - 'a'] = new Alpha(cc);
                }
            }
        }

        for(int i=0; i<words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int j=0;
            int minLen = Math.min(word1.length(), word2.length());
            if(word1.substring(0,minLen).equals(word2.substring(0,minLen)) && word1.length() > word2.length()) {
                return "";
            }
            while(j<word1.length() && j<word2.length()) {
                if(word1.charAt(j) != word2.charAt(j)) {
                    char cc1 = word1.charAt(j);
                    char cc2 = word2.charAt(j);
                    chars[cc1-'a'].next.add(chars[cc2-'a']);
                    break;
                }
                j++;
            }
        }
        return topoKahn(words, chars);

    }

    public String topoKahn(String[] words, Alpha [] chars) {
        String result= "";
        int totalAlpha = 0;
        // Calculate inorder degree
        int [] inorder = new int[26];
        for(int i=0; i<26; i++) {
            if(chars[i]!=null) {
             
                System.out.println("inorder cal curr "+chars[i].c + " "+chars[i].next.size());
                totalAlpha++;
                for(Alpha next: chars[i].next) {
                     System.out.println("inorder cal next "+next.c);
                    inorder[(next.c - 'a')]++;
                }
            } else {
                inorder[i] = -1;
            }
        }
        Queue<Alpha> queue = new LinkedList<>();
        // Add first element to queue
         for(int i=0; i<26; i++) {
            if(inorder[i] == 0) {
                queue.add(chars[i]);
            }
        }

        int visitedAlpha = 0;
        // Update the indegree of neighbours and add to queue if indegree = 0
        while(!queue.isEmpty()){
            Alpha currAlpha = queue.remove();
            System.out.println("queue node "+currAlpha.c);
            result+=currAlpha.c + "";
            for(Alpha currAlphaNext: currAlpha.next) {
                 System.out.println("queue node next + inorder "+currAlphaNext.c + " "+inorder[currAlphaNext.c - 'a']);
                if(--inorder[currAlphaNext.c - 'a'] == 0) {
                    queue.add(currAlphaNext);
                }
            }
            visitedAlpha++;
        
        }

        return visitedAlpha == totalAlpha ? result : "";
    }
}