package be.g00glen00b.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.g00glen00b.model.Item;

@RestController
@RequestMapping("/items")
public class ItemController {

	private List<Item> itens = new ArrayList<Item>();

	public ItemController() {
		itens.add(new Item(0, true, "item1"));
		itens.add(new Item(1, true, "item2"));
		itens.add(new Item(2, true, "item3"));
		itens.add(new Item(4, true, "item4"));
		itens.add(new Item(5, true, "item5"));
		itens.add(new Item(6, true, "item6"));

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Item> findItems() {
		return itens;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Item addItem(@RequestBody Item item) {
		Item i = new Item(7, true, "item7");
		itens.add(i);
		return i;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Item updateItem(@RequestBody Item updatedItem, @PathVariable Integer id) {
		updatedItem.setId(id);
		itens.get(id).setDescription(updatedItem.getDescription());
		;
		return updatedItem;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable Integer id) {
		itens.remove(id);
	}
}
