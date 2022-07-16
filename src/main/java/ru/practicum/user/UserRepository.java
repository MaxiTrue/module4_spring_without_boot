package ru.practicum.user;

import java.util.Collection;

public interface UserRepository {

    Collection<User> getAllUsers();

    User saveUser(User user);

}
