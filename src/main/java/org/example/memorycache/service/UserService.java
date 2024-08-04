package org.example.memorycache.service;

import org.example.memorycache.cache.MemoryCache;
import org.example.memorycache.entity.User;

import java.util.Optional;

public class UserService {
    private final MemoryCache<Long, User> memoryCache = new MemoryCache<>();

    public Optional<User> getUserById(Long id) {
        User user = memoryCache.getUserByKey(id);
        if (user != null) {
            System.out.println("Cache hit for user id :" + id);
            return Optional.of(user);
        } else {
            System.out.println("There is not Cache");
            user = getUserFromDB(id);
        }
        return Optional.ofNullable(user);
    }

    public void updateUser(Long id,User user){
        memoryCache.updateUser(id,user);
        System.out.println("User update to cache" + " " + user);
    }
    public void removeUserById(Long id){
        memoryCache.removeUserByKey(id);
        System.out.println("User removed by id :" + id);
    }

    public void clearAllUser(){
        memoryCache.clearAllUser();
        System.out.println("All User clear!");
    }


    private User getUserFromDB(Long id){
        System.out.println("Fetching user from db for id :"  + id);
       return new User(id,"User" + id,"user" + id + "@cache");
    }

}
