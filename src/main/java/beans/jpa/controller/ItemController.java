package beans.jpa.controller;

import beans.jpa.model.Item;
import beans.jpa.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @GetMapping
    public List<Item> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "{id}")
    public Item findById(@PathVariable(name = "id") Integer id) {
        return service.findById(id);
    }

    @PutMapping
    public void create(@RequestBody Item item) {
        service.create(item);
    }

    @PatchMapping
    public void update(@RequestBody Item item) {
        service.update(item);
    }

    @DeleteMapping(value = "{id}")
    public void deleteById(@PathVariable(name = "id") Integer id) {
        service.deleteById(id);
    }

}
