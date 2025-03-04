package br.com.supermarket.model;

import java.util.ArrayList;

public class Market {
    private long id;
    private String name;
    private ArrayList<CategoryItem> categories;

    public Market(String name) {
        this.name = name;
        this.categories = new ArrayList<>();
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

    public void removeCategory(CategoryItem categoryItem) {
        this.categories.remove(categoryItem);
    }

    public void showCategories() {
        int i = 0;
        for (CategoryItem categoryItem : categories) {
            System.out.println("Id: " + i +
                    "\nCategory: " + categoryItem.getName());
            i++;
        }
    }

    public void showItems() {
        for(CategoryItem categoryItem : categories){
            System.out.println("Categoria: "+ categoryItem.getName());
            int i =0;
            for(Item item : categoryItem.getItems()){
                System.out.println("Id: "+ i +
                                    " Name: " + item.getName() +
                                    " Price: " + item.getPrice());
                i++;
            }
        }
    }

    public  void showCategory(int id){
        for(int i=0;i<categories.size();i++){
            if(i == id){
                int j = 0;
                ArrayList<Item> items = categories.get(i).getItems();
                for (Item item : items) {
                    System.out.println("Id: " + (j+1) +
                            "\nName: " + items.get(j).getName() +
                            "\nPrice: " + items.get(j).getPrice());
                    j++;
                }
                return;
            }
        }
    }
}
