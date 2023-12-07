package leetcode.demo.problems;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and
 * retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * <p>
 * Implement the Trie class:
 * <p>
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 */
public class PrefixTreeTrie208 {
    class TrieNode {
        TrieNode[] kids = new TrieNode[26];
        boolean isEnd = false;

        public boolean containsKey(char ch) {
            return kids[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode node) {
            kids[ch - 'a'] = node;
        }

        public TrieNode get(char ch, TrieNode node) {
            return kids[ch - 'a'];
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd(TrieNode node) {
            return isEnd;
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch, node);
            }
            node.setEnd();
            return;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) return false;
                node = node.get(ch, node);
            }
            return node.isEnd(node);
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (!node.containsKey(ch)) return false;
                node = node.get(ch, node);
            }
            return true;
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