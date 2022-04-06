package com.blz;

public class MyBinaryTree<K extends Comparable<K>> {
    private MyBinaryNode<K> root;

    public void add(K key) {
        this.root = this.addRecursively(root, key);
    }

    public int getSize() {
        return this.getSizeRecursively(root);
    }

    public int searchKey(K key) {
        return this.searchKeyRecursively(root, key);
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
    }

    private int searchKeyRecursively(MyBinaryNode<K> current, K key) {
        if (current == null)
            return 0;
        else if (current.key==key)
            return 1;
        else if(key.compareTo(current.key)<0)
            return searchKeyRecursively(current.left,key);
        else if(key.compareTo(current.key)>0)
            return searchKeyRecursively(current.right,key);
        return 0;
    }


}
