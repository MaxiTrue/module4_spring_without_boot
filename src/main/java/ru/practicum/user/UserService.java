package ru.practicum.user;

import java.util.Collection;

public interface UserService {

    Collection<UserDto> getAllUsers();

    UserDto saveUser(UserDto userDto);

}
