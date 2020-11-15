package cat.itb.vistalista.models;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
    private static List<ItemModel> items = new ArrayList<>();

    public ItemList(){}

    public void afegirItem(String nom, int tier){
        ItemModel item = new ItemModel(nom,tier);
        items.add(item);
    }

    public List<ItemModel> getItems(){
        return items;
    }
}
