package com.pramati.java.lru.data.cache;

import com.pramati.java.lru.data.LRUData;

public class LRUCache <T> {
    private int size;
    private LRUData<T> head;
    private LRUData<T> tail;
    private int counter=0;

    public LRUCache(int size) {
        this.size = size;
    }

    public void add(T o ){
        LRUData<T> t=new LRUData<T>();
        t.setData(o);
        if(head==null){
            head=t;
            tail=t;
            counter++;
        }else{
            LRUData<T> temp=head;
            while(temp!=null){
                if(temp.getData().equals(t.getData())){
                    t.setPrevNode(tail);
                    tail.setNextNode(t);
                    temp.getPrevNode().setNextNode(temp.getNextNode());
                    temp.getNextNode().setPrevNode(temp.getPrevNode());
                    tail=t;
//                    break;
                    return;
                }
                temp=temp.getNextNode();
            }

            if(counter<size){
                tail.setNextNode(t);
                temp=tail;
                tail=t;
                tail.setPrevNode(temp);
                counter++;
            }else{
                t.setPrevNode(tail);
                tail.setNextNode(t);
                tail=t;
                head=head.getNextNode();
                head.setPrevNode(null);
            }
        }
    }

    public void printCache(){
        LRUData<T> temp=tail;
        while(temp!=null){
            System.out.println(temp.getData());
            temp=temp.getPrevNode();
        }
    }
}
