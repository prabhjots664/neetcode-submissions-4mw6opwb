class WordDictionary {

    static class Trie{
        boolean isEnding = false;
        Map<Character, Trie> children = new HashMap<>();
    } 

    Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie ptr = root;
        for(char ch: word.toCharArray()){
            ptr.children.putIfAbsent(ch, new Trie());
            ptr=ptr.children.get(ch);
        }
        ptr.isEnding=true;
    }

    public boolean searchDFS(String word, int i, Trie ptr){
        if(i==word.length()){
            if(ptr.isEnding==true){
                return true;
            } else {
                return false;
            }
        }
        char ch = word.charAt(i);
        boolean containsChar = false;
        if(ch!='.'){
            containsChar = ptr.children.containsKey(ch) && searchDFS(word, i+1, ptr.children.get(ch));
        } else {
            for (char keyChar : ptr.children.keySet()) {
                containsChar = containsChar || searchDFS(word, i+1, ptr.children.get(keyChar));
            }
        }
        
        return containsChar;   
    }
    
    //".ay"
    public boolean search(String word) {
        //  = root;
        return searchDFS(word, 0, root);
    }
}
