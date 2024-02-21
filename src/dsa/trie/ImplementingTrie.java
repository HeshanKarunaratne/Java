package dsa.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
}

public class ImplementingTrie {

    private TrieNode root;

    public ImplementingTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curNode = root;
        char[] arr = word.toCharArray();

        for (char curChar : arr) {
            if (!curNode.children.containsKey(curChar)) {
                curNode.children.put(curChar, new TrieNode());
            }
            curNode = curNode.children.get(curChar);
        }
        curNode.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curNode = root;
        char[] arr = word.toCharArray();

        for (char curChar : arr) {
            if (!curNode.children.containsKey(curChar)) {
                return false;
            }
            curNode = curNode.children.get(curChar);
        }
        return curNode.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        char[] arr = prefix.toCharArray();

        for (char curChar : arr) {
            if (!curNode.children.containsKey(curChar)) {
                return false;
            }
            curNode = curNode.children.get(curChar);
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementingTrie trie = new ImplementingTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
