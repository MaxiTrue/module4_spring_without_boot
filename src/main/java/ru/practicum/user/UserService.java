package ru.practicum.user;

import java.util.Collection;

public interface UserService {

    Collection<User> getAllUsers();

    User saveUser(User user);

}
