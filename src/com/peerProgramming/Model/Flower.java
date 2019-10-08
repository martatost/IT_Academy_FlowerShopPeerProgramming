package com.peerProgramming.Model;

import java.util.ArrayList;
import java.util.List;

public class Flower extends Article {


    private String color;

    public Flower(String name, int quantity, double price, String color) throws Exception {
        super(name, quantity, price);
        setColor(color);
    }


    public Flower() {
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) throws Exception {
        if ((color == null) || (color.equals(""))) throw new Exception("El color de la flor es incorrecte");
        this.color = color;
    }


    @Override
    public String getArticleInformation() {
        return (getName() + " de color " + color.toLowerCase() + ": "
                + getQuantity() + " unitats a "
                + getPrice() + " cadascuna");
    }


    @Override
    public List<Article> getArticles(List<Article> stock) {
        List<Article> flowerList = new ArrayList<>();
        for (Article art : stock) {
            if (art instanceof Flower) {
                flowerList.add(art);
            }
        }
        return flowerList;
    }

    @Override
    public boolean areTheSameArticle(Article article) {
        if (article instanceof Flower) {
            Flower flower = (Flower) article;
            if (this.getName().equalsIgnoreCase(flower.getName()) && this.getColor().equalsIgnoreCase(flower.getColor()))
                return true;
        }
        return false;
    }
}
