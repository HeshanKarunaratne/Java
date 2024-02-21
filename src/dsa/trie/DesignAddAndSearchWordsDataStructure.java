package dsa.trie;

/**
 * @author Heshan Karunaratne
 */
public class DesignAddAndSearchWordsDataStructure {
    private TrieNode trie;

    public DesignAddAndSearchWordsDataStructure() {
        trie = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = trie;

        for (char c: word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(trie, word, 0);
    }

    private boolean searchHelper(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : node.children.values()) {
                if (searchHelper(child, word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode child = node.children.get(c);
            if (child == null) {
                return false;
            }
            return searchHelper(child, word, index + 1);
        }
    }

    public static void main(String[] args) {
        DesignAddAndSearchWordsDataStructure wordDictionary = new DesignAddAndSearchWordsDataStructure();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("."));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search("aa"));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".a"));
        System.out.println(wordDictionary.search("a."));

    }
}
