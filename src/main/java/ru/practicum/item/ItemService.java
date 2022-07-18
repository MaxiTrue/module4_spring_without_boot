package ru.practicum.item;

import java.util.Collection;

public interface ItemService {

    Collection<ItemDto> getItems(Long userId);

    ItemDto addNewItem(Long userId, ItemDto itemDto);

    void deleteItem(Long userId, Long itemId);

}
