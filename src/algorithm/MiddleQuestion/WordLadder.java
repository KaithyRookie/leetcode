package algorithm.MiddleQuestion;

import algorithm.tree.Trie;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同
 *
 * @author kaithy.xu
 * @date 2020-06-23 21:36
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int depth = beginWord.length();

        Map<String, List<String>> dictMap = new HashMap<>(depth*wordList.size()*4/3);
        for (int i = 0; i < depth; i++) {
            char[] chars = beginWord.toCharArray();
            chars[i] = '*';
            String temp = new String(chars);
            List<String> list = dictMap.getOrDefault(temp,new ArrayList<>());
            list.add(beginWord);
        }

        for (String word : wordList) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < depth; i++) {
                chars[i] = '*';
                String temp = new String(chars);
                List<String> list = dictMap.getOrDefault(temp,new ArrayList<>());
                list.add(word);

            }
        }

        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);




        return -1;
    }


}
