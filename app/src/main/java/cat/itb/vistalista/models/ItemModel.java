package cat.itb.vistalista.models;

import java.util.ArrayList;
import java.util.List;

public class ItemModel {
    private List<ItemModel> items = new ArrayList<>();

    private String nom;
    private String tier;
    private int imatge;

    public ItemModel(String nom, String tier, int imatge) {
        this.nom = nom;
        this.tier = tier;
        this.imatge = imatge;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public int getImatge() {
        return imatge;
    }

    public void setImatge(int imatge) {
        this.imatge = imatge;
    }
}