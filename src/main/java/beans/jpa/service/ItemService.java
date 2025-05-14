package beans.jpa.service;

import beans.jpa.model.Item;
import beans.jpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(Integer id) {
        return itemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("no item found for " + id));
    }

    public void create(Item item) {
        itemRepository.save(item);
    }

    public void update(Item item) {
        itemRepository.getReferenceById(item.getId()).setName(item.getName());
    }

    public void deleteById(Integer id) {
        itemRepository.deleteById(id);
    }
}
