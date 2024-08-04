package org.example.memorycache.cache;

import java.util.HashMap;
import java.util.Map;

public class MemoryCache<K,V> {
    private  final Map<K,V> cache = new HashMap<>();

    public V getUserByKey(K key ){
        return cache.get(key);
    }
    public void updateUser(K key,V value){
        cache.put(key, value);
    }
    public void removeUserByKey(K key){
        cache.remove(key);
    }
    public void clearAllUser(){
        cache.clear();
    }
}
