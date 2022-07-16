package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    ItemRepository itemRepository;

    @Override
    public Collection<Item> getItems(Long userId) {
        return itemRepository.findByUserId(userId);
    }

    @Override
    public Item addNewItem(Long userId, Item item) {
        return null;
    }

    @Override
    public void deleteItem(Long userId, Long itemId) {

    }
}
