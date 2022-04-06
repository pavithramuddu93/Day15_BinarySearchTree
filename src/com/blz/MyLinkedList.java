package com.blz;
public class MyLinkedList<K> {
    private INode tail;
    private INode head;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(INode newNode) {
        if (this.tail == null)
            this.tail = newNode;
        if (this.head == null)
            this.head = newNode;
        else {
            INode tempNode = this.head;
            this.head = newNode;
            newNode.setNext(tempNode);
        }
    }

    public void append(INode<K> newNode) {
        if (this.head == null)
            this.head = newNode;
        if (this.tail == null)
            this.tail = newNode;
        else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

    }


    public void printNodes() {
        if (this.head == null)
            System.out.println("No elements to print");
        else {
            INode tempNode = this.head;
            while (tempNode.getNext() != null) {
                System.out.print(tempNode.getKey() + "->");
                tempNode = tempNode.getNext();
            }
            System.out.println(tempNode.getKey());
        }
    }

    public void insert(INode myNode, INode newNode) {
        INode tempNode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempNode);
    }

    public INode pop() {
        if (this.head == null) {
            System.out.println("No elements to delete");
            return null;
        } else {
            INode tempNode = this.head;
            this.head = this.head.getNext();
            return tempNode;
        }
    }


    public INode popLast() {
        if (this.head == null) {
            System.out.println("No elements to delete");
            return null;
        } else {
            INode tempNode = this.head;
            while (tempNode.getNext().getNext() != null) {
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(null);
            INode ret = this.tail;
            this.tail = tempNode;
            return ret;
        }
    }


    public INode search(K key){
        INode tempNode=this.head;
        while(tempNode!=null){
            if(tempNode.getKey()==key) {
                return tempNode;
            }
            tempNode=tempNode.getNext();
        }
        return tempNode;
    }


    public void deleteNode(INode myNode){
        if(this.head==null)
            System.out.println("No elements to delete");
        else{
            INode tempNode=this.head;
            while(tempNode!=null){
                if(tempNode.getNext()==myNode){
                    tempNode.setNext(tempNode.getNext().getNext());
                }
                tempNode=tempNode.getNext();
            }
        }
    }

    /*
        @purpose: Ability to create ordered linked list in asending order.
        @param: node to delete.
        @function : deletes the node which is having data asked by the user.
        @return: No returns.
    */

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                '}';
    }
}