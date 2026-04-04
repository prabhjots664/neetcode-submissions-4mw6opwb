class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if( !wordSet.contains(endWord)){
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int res = 0;
        while(!q.isEmpty()){
            res++;
            for(int i=q.size();i>0;i--){
                String node = q.poll();
                if(node.equals(endWord)){
                    return res;
                }
                for(int j=0;j<node.length();j++){
                    for (char c = 'a'; c <= 'z'; c++) {
                        String child = node.substring(0,j) + c + node.substring(j+1);
                        if(wordSet.contains(child)){
                            q.offer(child);
                            wordSet.remove(child);
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}
