package br.com.supermarket.model;

import java.util.ArrayList;

public class CategoryItem {
    private long id;
    private String name;
    private ArrayList<Item> items;

    public CategoryItem(String name) {
        this.name = name;
        items = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }
    public void removeItem(Item item) {
        items.remove(item);
    }
}
