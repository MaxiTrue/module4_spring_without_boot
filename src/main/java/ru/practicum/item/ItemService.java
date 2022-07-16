package ru.practicum.item;

import java.util.Collection;

public interface ItemService {

    Collection<Item> getItems(Long userId);

    Item addNewItem(Long userId, Item item);

    void deleteItem(Long userId, Long itemId);

}
