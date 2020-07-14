public class WordDictionary {
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            TrieNode node = current.children[word.charAt(i) - 'a'];
            current.children[word.charAt(i) - 'a'] = node == null ? new TrieNode() : node;
            current = current.children[word.charAt(i) - 'a'];
        }
        current.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode current = root;
        int i = 0;
        while(i < word.length()) {
            Character c = word.charAt(i);
            if(c != '.') {
                if(current.children[c - 'a'] == null) {
                    return false;
                } else {
                    current = current.children[c - 'a'];
                    i++;
                }
            } else {
                TrieNode subCurrent = current;
                int j = i;
                while(word.charAt(j) == '.') {
                    for(int k = 0; k < 26; k++) {
                        if(subCurrent.children[k] != null) {

                        }
                    }
                    j++;
                }
            }
        }
    }
}

class TrieNode {
    boolean isEnd = false;
    TrieNode[] children = new TrieNode[26];
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
