package com.blz;
public class MyBinaryNode<K extends Comparable<K>> {
    K key;
    MyBinaryNode right;
    MyBinaryNode left;

    public MyBinaryNode(K key) {
        this.key = key;
        this.left = null;
        this.right = null;

    }


    public K getKey() {
        return key;
    }


    public void setKey(K key) {
        this.key=key;
    }


}