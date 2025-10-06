package Challange2;

import java.util.HashMap;
import java.util.Map;

class LRUCache<K,V> {
    private final int capacity;
    private final Map<K,Node> map;
    private final Node head,tail;
    private class Node{
        K key;
        V value;
        Node prev,next;
        Node(K key,V value){
            this.key=key;
            this.value=value;
        }
    }
    public LRUCache(int capacity){
        this.capacity=capacity;
        this.map=new HashMap<>();
        head=new Node(null,null);
        tail=new Node(null,null);
        head.next=tail;
        tail.prev=head;
    }
    public V getVal(K key){
        if(!map.containsKey(key))return null;
        Node node=map.get(key);
        moveThisNodeToHead(node);
        return node.value;
    }
    public void put(K key,V value){
        Node node=map.get(key);
        if(node!=null){
            node.value=value;
            moveThisNodeToHead(node);
        }
        else{
            Node newNode=new Node(key,value);
            map.put(key,newNode);
            addNodeToHead(newNode);
            if(map.size()>capacity){
                Node tailPrev=RemoveFromTail();
                map.remove(tailPrev.key);
            }
        }
    }
    private void addNodeToHead(Node node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    private void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private void moveThisNodeToHead(Node node){
        removeNode(node);
        addNodeToHead(node);
    }
    private Node RemoveFromTail(){
        Node tailPrev=tail.prev;
        removeNode(tailPrev);
        return tailPrev;
    }
}
