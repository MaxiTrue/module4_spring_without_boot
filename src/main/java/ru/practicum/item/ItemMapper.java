package ru.practicum.item;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class ItemMapper {

    public static Item mapToItem(ItemDto itemDto, long userId) {
        Item item = new Item();
        item.setUserId(userId);
        item.setUrl(itemDto.getUrl());
        item.setTags(itemDto.getTags());
        return item;
    }

    public static ItemDto mapToItemDto(Item item) {
        return new ItemDto(
                item.getId(),
                item.getUserId(),
                item.getUrl(),
                new HashSet<>(item.getTags())
        );
    }

    public static Collection<ItemDto> mapToItemDto(Collection<Item> items) {
        return items.stream().map(ItemMapper::mapToItemDto).collect(Collectors.toList());
    }

}
