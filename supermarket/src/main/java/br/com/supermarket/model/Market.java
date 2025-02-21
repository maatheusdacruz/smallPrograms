package br.com.supermarket.model;

import java.util.ArrayList;

public class Market {
    private long id;
    private String name;
    private ArrayList<CategoryItem> categories;
    private ArrayList<Item> items;

    public Market(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public Market() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CategoryItem> getCategories() {
        return categories;
    }

    public void addCategory(CategoryItem categoryItem) {
        this.categories.add(categoryItem);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}
