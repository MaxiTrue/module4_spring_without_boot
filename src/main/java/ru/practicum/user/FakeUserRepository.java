package ru.practicum.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class FakeUserRepository implements UserRepository{

    private final static List<User> FAKE_USER_LIST = createManyFakeUsers(3);

    @Override
    public Collection<User> getAllUsers() {
        return FAKE_USER_LIST;
    }

    @Override
    public User saveUser(User user) {
        throw new UnsupportedOperationException("Метод save() ещё не готов");
    }

    private static List<User> createManyFakeUsers(int count) {
        List<User> fakeUsers = new ArrayList<>();
        for (long id = 1; id <= count; id++) {
            fakeUsers.add(createFakeUser(id));
        }
        return Collections.unmodifiableList(fakeUsers);
    }

    private static User createFakeUser(long id) {
        User fakeUser = new User();
        fakeUser.setId(id);
        fakeUser.setEmail("mail" + id + "@example.com");
        fakeUser.setName("Akakiy Akakievich #" + id);
        return fakeUser;
    }

}
