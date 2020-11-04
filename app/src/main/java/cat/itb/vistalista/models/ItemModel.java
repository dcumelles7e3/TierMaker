package cat.itb.vistalista.models;

public class ItemModel {
    private String nom;
    private String tier;

    public ItemModel(String nom, String tier) {
        this.nom = nom;
        this.tier = tier;
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
}
