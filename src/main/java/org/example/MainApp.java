package org.example;

import org.example.memorycache.entity.User;
import org.example.memorycache.service.UserService;
import org.example.memorycache.service.UserService;

import java.util.Optional;

/**
 * Hello world!
 *
 */
public class MainApp
{
    public static void main( String[] args )
    {

        UserService service = new UserService();


/*        // retrieve user for first time (cache is empty)
Optional<User> user1 = service.getUserById(1l);
user1.ifPresent(System.out::println);


// Retrieve the user for the second time (the cache must hold the result)
        Optional<User> user2 = service.getUserById(1l);
        user2.ifPresent(System.out::println);

        // Retrieve the another user
        Optional<User> user3 = service.getUserById(2l);
        user3.ifPresent(System.out::println);

        // Retrieve the user for the second time (the cache must hold the result)
        Optional<User> user4 = service.getUserById(2l);
        user4.ifPresent(System.out::println);*/


        User newUser = new User(1L, "milad rostami", "miladrostami24@gmail.com");
        service.updateUser(1l,newUser);


        Optional<User> user1 = service.getUserById(1L);
        user1.ifPresent(System.out::println);


        Optional<User> user2 = service.getUserById(2L);
        user2.ifPresent(System.out::println);

        User anotherUser = new User(2L, "Jane Doe", "jane.doe@example.com");
        service.updateUser(2L, anotherUser);

        Optional<User> user3 = service.getUserById(2L);
        user3.ifPresent(System.out::println);

        service.removeUserById(1L);

        Optional<User> user4 = service.getUserById(1L);
        user4.ifPresent(System.out::println);

        service.clearAllUser();

        Optional<User> user5 = service.getUserById(2L);
        user5.ifPresent(System.out::println);









    }
}
