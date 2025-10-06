package Challange2;

public class Solution {
    public static void main(String[] args) {
        LRUCache<Integer,Integer> lruCache=new LRUCache<>(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.getVal(1));
        lruCache.put(3,3);
        System.out.println(lruCache.getVal(2));
        lruCache.put(4,4);
        System.out.println(lruCache.getVal(1));
        System.out.println(lruCache.getVal(3));
        System.out.println(lruCache.getVal(4));
    }
}
