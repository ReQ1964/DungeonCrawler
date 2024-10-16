package game;

import items.Item;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static Inventory instance;
    Map<String, Item> items;

    private Inventory() {
        this.items = new HashMap<>();
    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public Map<String, Item> getAllItems() {
        if(items.isEmpty()){
            System.out.println("You don't have any items!");
            return null;
        }

        return items;
    }

    public Item getItem(String key){
        return items.get(key);
    }

    public void addItem(String key, Item item) {
        items.put(key, item);
    }

    public void removeItem(String key) {
        items.remove(key);
    }
}

