class Trie {
    class Node {
        Node[] ch = new Node[26];
        boolean end = false;
    }
    Node root;
    public Trie() {
        root = new Node();
    }
    public void insert(String w) {
        Node cur = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (cur.ch[i] == null) {
                cur.ch[i] = new Node();
            }
            cur = cur.ch[i];
        }
        cur.end = true;
    }
    public boolean search(String w) {
        Node cur = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (cur.ch[i] == null) return false;
            cur = cur.ch[i];
        }
        return cur.end;
    }
    
    public boolean startsWith(String p) {
        Node cur = root;
        for (char c : p.toCharArray()) {
            int i = c - 'a';
            if (cur.ch[i] == null) return false;
            cur = cur.ch[i];
        }
        return true;
    }
}