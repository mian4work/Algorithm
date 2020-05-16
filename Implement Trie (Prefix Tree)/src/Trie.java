/*
    Implement a trie with insert, search, and startsWith methods.

    Example:

    Trie trie = new Trie();

    trie.insert("apple");
    trie.search("apple");   // returns true
    trie.search("app");     // returns false
    trie.startsWith("app"); // returns true
    trie.insert("app");
    trie.search("app");     // returns true
    Note:

    You may assume that all inputs are consist of lowercase letters a-z.
    All inputs are guaranteed to be non-empty strings.
 */

/**
 * The key to implement the Trie is the TrieNode:
 *      1. Each node represents a char in a word in a hierarchical way. "hi" is node root -> root's children
 *      2. Each node contains a list of children: a 26 char list
 *      3. In the children, if no char available, set it to null
 *      4. It is important to mark the end element
 *      5. NOTE: no need to remember the current char in a TrieNode.
 *
 *      Example: "hi":
 *          root has children list from 0..25: where 'h' - 'a' is set with a new Trie: node1
 *          node1 has children list where 'i' - 'a' is set with a new Trie: node2
 *          node2 has all null children but isEnd is set to true
 */
public class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }

            node = node.children[c - 'a'];

            if(i == word.length() - 1) {
                node.isEnd = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(node.children[c - 'a'] == null) {
                return false;
            }

            node = node.children[c - 'a'];

            if(i == word.length() - 1 && node.isEnd) {
                return true;
            }
        }

        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if(node.children[c - 'a'] == null) {
                return false;
            }

            node = node.children[c - 'a'];
        }

        return true;
    }
}

class TrieNode {

    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;

    public TrieNode() {
        for(int i = 0; i < 25; i++) {
            children[i] = null;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
