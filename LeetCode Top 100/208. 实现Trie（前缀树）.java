class TrieNode {
    public boolean isWord; // 是否存在该单词
    public TrieNode[] children = new TrieNode[26]; // 创建一个数组，用于保存当前节点的子节点
    public TrieNode() {} // 构造方法
}

public class Trie {
    private TrieNode root; // 创建根节点属性

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(); // 初始化，root即创建一个新的Trie节点
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ws = root; // 创建一个根节点
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i); // 获取插入字符串中每个位置的字符
            if (ws.children[c - 'a'] == null) // 如果当前节点不存在值为c的子节点
                ws.children[c - 'a'] = new TrieNode(); // 就创建一个新的子节点，保存在数组中的相应位置
            ws = ws.children[c - 'a']; // 令ws指向刚刚保存的子节点
        }
        ws.isWord = true; // 所有字符插入完成后，令最后一个插入的节点的isWord属性为true，表示前缀树中存在该单词
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) return false; // 如果当前节点不存在值为c的子节点，返回false
            ws = ws.children[c - 'a']; // 令ws指向下一个子节点
        }
        return ws.isWord; // 返回先前在insert操作中保存的最后一个节点（终结点）的isWord属性
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        // 与search操作基本相同，不同之处在于，不需要判断终结点的isWord属性
        // 只要遍历完输入的prefix字符串即可，返回true
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}
