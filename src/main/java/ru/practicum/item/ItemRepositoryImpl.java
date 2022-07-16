package ru.practicum.item;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class ItemRepositoryImpl implements ItemRepository{

    private final Map<Long, Item> items = new ConcurrentHashMap<>();
    private Long globalId = 0L;

    private Long generateNewId(){
        return globalId++;
    }

    @Override
    public Collection<Item> findByUserId(long userId) {
        return items.values().stream().filter(item -> item.getId() == userId).collect(Collectors.toList());
    }

    @Override
    public Item save(Item item) {
        item.setId(generateNewId());
        items.put(item.getId(), item);
        return item;
    }

    @Override
    public void deleteByUserIdAndItemId(long userId, long itemId) {
        Item findItem = items.get(itemId);
        if(findItem != null){
           if(findItem.getUserId() == userId){
              items.remove(itemId);
           }
        }
    }



}
