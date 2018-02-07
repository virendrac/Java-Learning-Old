package com.pramati.java.lru.data;

public class LRUData <T> {
    private T data;
    private LRUData<T> prevNode;
    private LRUData<T> nextNode;

    public LRUData(T data) {
        this.data = data;
    }
    public LRUData() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LRUData<T> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(LRUData<T> prevNode) {
        this.prevNode = prevNode;
    }

    public LRUData<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(LRUData<T> nextNode) {
        this.nextNode = nextNode;
    }
}
