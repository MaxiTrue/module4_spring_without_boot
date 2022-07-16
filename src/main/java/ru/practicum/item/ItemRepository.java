package ru.practicum.item;

import java.util.Collection;

public interface ItemRepository {

    Collection<Item> findByUserId(long userId);

    Item save(Item item);

    void deleteByUserIdAndItemId(long userId, long itemId);

}
