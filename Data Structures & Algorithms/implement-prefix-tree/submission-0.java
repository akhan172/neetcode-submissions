class PrefixTree {
    class Tnode{
        Tnode[] child = new Tnode[26];
        boolean isEnd;
    }
    private Tnode root;
    public PrefixTree() {
        root = new Tnode();
    }

    public void insert(String word) {
        Tnode curr = root;
        for(char ch:word.toCharArray()){
            int idx = ch-'a';

            if(curr.child[idx]==null){
                curr.child[idx] = new Tnode();
            }
            curr = curr.child[idx];
        }
        curr.isEnd=true;
    }
    private boolean solve(String word, Tnode curr){
        if(curr == null){
            return false;
        }
        if(word.length()==0){
            return curr.isEnd;
        }
        int idx = word.charAt(0) - 'a';

        return solve(word.substring(1), curr.child[idx]);
    }
    private boolean solvepfx(String word, Tnode curr){
        if(curr == null){
            return false;
        }
        if(word.length()==0){
            return true;
        }
        int idx = word.charAt(0) - 'a';

        return solvepfx(word.substring(1), curr.child[idx]);
    }
    public boolean search(String word) {
        return solve(word, root);
    }

    public boolean startsWith(String prefix) {
        return solvepfx(prefix, root);
    }
}
