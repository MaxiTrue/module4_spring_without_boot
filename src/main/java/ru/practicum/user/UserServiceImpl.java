package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Collection<UserDto> getAllUsers() {
        return UserMapper.mapToUserDto(userRepository.getAllUsers());
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = userRepository.saveUser(UserMapper.mapToNewUser(userDto));
        return UserMapper.mapToUserDto(user);
    }
}
