2. Design an LRU Cache 🧠
Problem Statement:
Design and implement a Least Recently Used (LRU) Cache. This cache should store key-value pairs up to a fixed capacity. When the cache is full and a new item is added, the least recently used item should be evicted.

Functional Requirements:

The cache must have a fixed capacity defined at the time of creation.

It must support two main operations:

put(key, value): Insert or update the value for a given key. If the cache is full, this operation should evict the least recently used item before inserting the new one.

get(key): Retrieve the value for a given key. If the key exists, this operation should mark the item as recently used. If the key does not exist, it should return a null or an equivalent indicator.

All operations (put and get) should ideally perform in O(1) time complexity.

Non-Functional Requirements:

The implementation should be generic to support any key-value types.

Consider thread safety as a bonus point (how would you make your get and put methods safe for concurrent access?).