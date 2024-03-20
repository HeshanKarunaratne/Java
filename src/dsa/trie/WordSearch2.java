package dsa.trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
public class WordSearch2 {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;

        public TrieNode() {
        }

    }

    char[][] _board = null;
    List<String> _res = new LinkedList<>();

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }

        this._board = board;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }
        return this._res;
    }

    private void backtracking(int row, int col, TrieNode parent) {
        Character letter = this._board[row][col];
        TrieNode currNode = parent.children.get(letter);

        if (currNode.word != null) {
            this._res.add(currNode.word);
            currNode.word = null;
        }
        this._board[row][col] = '#';

        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {

            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];

            if (newRow < 0 || newRow >= this._board.length || newCol < 0 || newCol >= this._board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(this._board[newRow][newCol])) {
                backtracking(newRow, newCol, currNode);
            }
        }
        this._board[row][col] = letter;

        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}
