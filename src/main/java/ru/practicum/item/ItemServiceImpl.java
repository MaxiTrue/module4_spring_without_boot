package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    ItemRepository itemRepository;

    @Override
    public Collection<ItemDto> getItems(Long userId) {
        return ItemMapper.mapToItemDto(itemRepository.findByUserId(userId));
    }

    @Override
    public ItemDto addNewItem(Long userId, ItemDto itemDto) {
        Item item = itemRepository.save(ItemMapper.mapToItem(itemDto, userId));
        return ItemMapper.mapToItemDto(itemRepository.save(item));
    }

    @Override
    public void deleteItem(Long userId, Long itemId) {

    }
}
