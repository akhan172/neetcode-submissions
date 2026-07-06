class WordDictionary {
    class Tnode{
        //char ch;
        Tnode[] children = new Tnode[26];
        boolean isEnd;

    }
    private Tnode root;
    public WordDictionary() {
        root = new Tnode();
    }

    public void addWord(String word) {
        Tnode curr=root;
        for(char ch: word.toCharArray()){
            int idx = ch-'a';

            if(curr.children[idx]==null){
                curr.children[idx] = new Tnode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    private boolean dfs(String word, Tnode node){
        if(node==null) return false;

        if(word.length() == 0){
            return node.isEnd;
        }
        char ch = word.charAt(0);

        if(ch=='.'){
            for(Tnode child : node.children){
                if(dfs(word.substring(1), child)){
                    return true;
                }
            }
            return false;
        }
        return dfs(word.substring(1), node.children[ch-'a']);
    }
    public boolean search(String word) {
        return dfs(word, root);
    }
}
