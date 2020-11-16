package cat.itb.vistalista.models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

import cat.itb.vistalista.R;

public class ItemModel implements Comparable<ItemModel>{
    private String nom;
    private int tier;
    private int imatge;

    public ItemModel(String nom, int tier) {
        this.nom = nom;
        this.tier = tier;

        switch (tier){
            case 1:
                this.imatge = R.drawable.t1img;
                return;
            case 2:
                this.imatge = R.drawable.t2img;
                return;
            case 3:
                this.imatge = R.drawable.t3img;
                return;
            case 4:
                this.imatge = R.drawable.t4img;
                return;
            default:
                this.imatge = 0;
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public int getImatge() {
        return imatge;
    }

    public void setImatge(int imatge) {
        this.imatge = imatge;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int compareTo(ItemModel o) {
        return Integer.compare(this.tier,o.getTier());
    }
}