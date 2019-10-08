package com.peerProgramming.Model;

import java.util.ArrayList;
import java.util.List;

public class Decoration extends Article {

    private Material material;

    public Decoration(String name, int quantity, double price, String material) throws Exception {
        super(name, quantity, price);
        setMaterial(material);
    }


    public Decoration() {
        super();
    }


    public String getMaterial() {
        return material.toString().toLowerCase();
    }


    public void setMaterial(String m) throws Exception {
        try {
            this.material = Material.valueOf(m.toUpperCase());
        } catch (Exception e) {
            throw new Exception("el material no es correcte");
        }
    }


    @Override
    public String getArticleInformation() {
        return getName() + ", de " + material.toString().toLowerCase() + ": "
                + getQuantity() + " unitats a "
                + getPrice() + " cadascuna";
    }


    @Override
    public List<Article> getArticles(List<Article> stock) {
        List<Article> decorationList = new ArrayList<>();
        for (Article art : stock) {
            if (art instanceof Decoration) {
                decorationList.add(art);
            }
        }
        return decorationList;
    }


    @Override
    public boolean areTheSameArticle(Article article) {

        if (article instanceof Decoration) {
            Decoration decoration = (Decoration) article;
            if (this.getName().equalsIgnoreCase(decoration.getName()) && this.getMaterial().equalsIgnoreCase(decoration.getMaterial()))
                return true;
        }
        return false;
    }
}
