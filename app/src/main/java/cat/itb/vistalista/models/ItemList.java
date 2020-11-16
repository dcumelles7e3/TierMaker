package cat.itb.vistalista.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemList {
    private static List<ItemModel> items = new ArrayList<>();

    public ItemList(){
        //Afegim 4 items la primera vegada
        if (items.isEmpty()){
        afegirItem("Super Mario Bros 2",1);
        afegirItem("Super Mario 64",2);
        afegirItem("Super Mario Party",3);
        afegirItem("Dark Souls 2",4);}
        Collections.sort(items);
    }

    public void afegirItem(String nom, int tier){
        ItemModel item = new ItemModel(nom,tier);
        items.add(item);
    }

    public List<ItemModel> getItems(){
        return items;
    }

    public void borrar(int pos){
        items.remove(pos);
    }
    public String getNomActual(int pos){
        return items.get(pos).getNom();
    }
}
