package com.company;

import java.util.ArrayList;

public class TrieSolver {


    public static void Solve(String[] input) {

        var root = new Node();

        for (var w : input)
            root.AppendWord(w, 0);

        var res = new ArrayList<String>(input.length);

        String top1 = "";
        String top2 = "";

        for (var w : input)
            if (root.CheckWord(w, 0, root)) {
                res.add(w);

                if (top2.length() < w.length())
                    top2 = w;

                if (top1.length() < top2.length()) {
                    String temp = top1;
                    top1 = top2;
                    top2 = temp;
                }
            }

        System.out.println(top1);
        System.out.println(top2);
        System.out.println(res.size());
    }

    static class Node {
        Node[] _nodes = new Node[26];
        private String _val = null;

        public boolean CheckWord(String word, int ind, Node root) {
            if (ind > word.length()) return false;

            if (ind == word.length()) {
                if (_val != null && _val != word) return true;
                return false;
            }

            if (_val != null) {
                if (root.CheckWord(word, ind, root)) return true;
            }

            var c = word.charAt(ind) - 'a';
            if (_nodes[c] == null) return false;
            return _nodes[c].CheckWord(word, ind + 1, root);
        }


        public void AppendWord(String word, int level) {
            if (level == word.length()) {
                _val = word;
                return;
            }

            var c = word.charAt(level) - 'a';
            Node node;

            if (_nodes[c] != null) {
                node = _nodes[c];
            } else {
                node = new Node();
                _nodes[c] = node;
            }

            node.AppendWord(word, level + 1);
        }
    }
}
