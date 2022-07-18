package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

@Repository
@RequiredArgsConstructor
@Primary
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    @Override
    public Collection<User> getAllUsers() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root);
        return entityManager.createQuery(cr).getResultList();
    }

    Collection<User> searchByEmailDomain(String domain) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root).where(cb.like(root.get("email"), "%" + domain));
        return entityManager.createQuery(cr).getResultList();
    }

    @Override
    public User saveUser(User user) {
        entityManager.merge(user);
        entityManager.close();
        return user;
    }
}
