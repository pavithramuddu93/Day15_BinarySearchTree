package com.blz;

public class MyBinaryTree<K extends Comparable<K>> {
    private MyBinaryNode<K> root;

    public void add(K key) {
        this.root = this.addRecursively(root, key);
    }

    private MyBinaryNode addRecursively(MyBinaryNode<K> current, K key) {
        if (current == null)
            return new MyBinaryNode<>(key);
        int compareResult = key.compareTo(current.key);
        if (compareResult == 0) return current;
        if (compareResult < 0) {
            current.left = this.addRecursively(current.left, key);
        } else {
            current.right = this.addRecursively(current.right, key);
        }
        return current;
    }

    private int getSizeRecursively(MyBinaryNode<K> current) {
        if (current == null)
            return 0;
        else {
            return 1 + this.getSizeRecursively(current.left)
                    + this.getSizeRecursively(current.right);
        }
//        return current==null?0:1+this.getSizeRecursively(current.left)+this.getSizeRecursively(current.right);
    }


    public int getSize() {
        return this.getSizeRecursively(root);
    }
}