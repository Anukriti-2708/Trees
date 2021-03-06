package com.Anu;

import java.io.*;

import java.util.*;

public class Main {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void

    public static void traversal(Node node) {
        System.out.println("Node pre" + node.data);
        for (Node child : node.children) {
            System.out.println("Edge Pre" + node.data + "-" + child.data);
            traversal(child);
            System.out.println("Edge Post" + node.data + "-" + child.data);
        }
        System.out.println("Node Post" + node.data);
    }

    public static void levelOrder(Node node) {
        Queue <Node> q = new ArrayDeque<>();
        q.add(node);
        while (q.size()!=0){
            node = q.remove();
            System.out.print(node.data + ",");
            for(Node child : node.children){
                q.add(child);
            }
        }
    }

        public static int height (Node node){ // in terms of edges
            int h = -1;     // height of root is 1 as it has no edges
            for (Node child : node.children) {
                int c = height(child);
                h = Math.max(c, h);
            }
            h += 1;
            return h;
        }

        public static int size (Node node){
            int size = 0;
            for (Node child : node.children) {
                int cs = size(child);
                size = size + cs;
            }
            size = size + 1;
            return size;
        }

        public static void display (Node node){
            String str = node.data + " -> ";
            for (Node child : node.children) {
                str += child.data + ", ";
            }
            str += ".";
            System.out.println(str);

            for (Node child : node.children) {
                display(child);
            }
        }

        public static int max (Node node){
            int m = 0;
            for (Node child : node.children) {
                int s = max(child);
                m = Math.max(s, m);
            }
            m = Math.max(m, node.data);
            return m;
        }

        public static Node construct ( int[] arr){
            Node root = null;

            Stack<Node> st = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == -1) {
                    st.pop();
                } else {
                    Node t = new Node();
                    t.data = arr[i];

                    if (st.size() > 0) {
                        st.peek().children.add(t);
                    } else {
                        root = t;
                    }

                    st.push(t);
                }
            }

            return root;
        }

        public static void main (String[]args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] values = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {

                arr[i] = Integer.parseInt(values[i]);
            }

            Node root = construct(arr);
            display(root);
            int size = size(root);
            System.out.println(size);
            int m = max(root);
            System.out.println(m);
            int h = height(root);
            System.out.println(h);
            traversal(root);
            levelOrder(root);
        }

    }
