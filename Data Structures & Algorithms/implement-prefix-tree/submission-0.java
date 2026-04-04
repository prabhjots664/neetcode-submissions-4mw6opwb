class PrefixTree {
    
    static class Trie{
        boolean isEnding = false;
        Map<Character, Trie> children = new HashMap<>();
    } 
    
    Trie root;
    
    public PrefixTree() {
         root = new Trie();
    }
    
    //"ac"
    public void insert(String word) {
        Trie ptr = root;
        for(char ch: word.toCharArray()){
            ptr.children.putIfAbsent(ch, new Trie());
            ptr=ptr.children.get(ch);
        }
        ptr.isEnding=true;
    }

    public boolean search(String word) {
        Trie ptr = root;
        for(char ch: word.toCharArray()){
            if(!ptr.children.containsKey(ch)){
                return false;
            }
            ptr=ptr.children.get(ch);
            
        }
        return ptr.isEnding;
    }

    public boolean startsWith(String prefix) {
        Trie ptr = root;
        for(char ch: prefix.toCharArray()){
            if(!ptr.children.containsKey(ch)){
                return false;
            }
            ptr=ptr.children.get(ch);
            
        }
        return true;
    }
}