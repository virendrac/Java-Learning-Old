package com.java.learning.hr.node;

import com.java.learning.hr.node.data.Data;

public class Node {
    private Data data;
    private Node nextNode;

    public Node(Data data) {
        this.data = data;
        this.nextNode = null;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

