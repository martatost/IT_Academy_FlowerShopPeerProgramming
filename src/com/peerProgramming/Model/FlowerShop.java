package com.peerProgramming.Model;

import java.util.ArrayList;
import java.util.List;


public class FlowerShop {

    static final int FLOWERS = 1;
    static final int TREES = 2;
    static final int DECORATION = 3;
    private String name;
    private List<Article> stock = new ArrayList<>();

    public FlowerShop(String name) throws Exception {
        setName(name);
    }


    public String getName() {
        return name;
    }


    public List<Article> getStock() {
        return stock;
    }


    public void setName(String name) throws Exception {
        if (name == null || name.equals("")) throw new Exception("El nom de la floristeria és incorrecte.");
        this.name = name;
    }


    public void addArticle(Article article) throws Exception {
        int i = findArticle(article);
        if (i != -1) {
            int newQuantity = stock.get(i).getQuantity() + article.getQuantity();
            stock.get(i).setQuantity(newQuantity);
        } else {
            stock.add(article);
        }
    }


    public List<Article> getArticles(List<Article> stock, int type) {
        List<Article> articlesToReturn;
        switch (type) {
            case FLOWERS:
                Flower flower = new Flower();
                articlesToReturn = flower.getArticles(stock);
                return articlesToReturn;
            case TREES:
                Tree tree = new Tree();
                articlesToReturn = tree.getArticles(stock);
                return articlesToReturn;
            case DECORATION:
                Decoration decoration = new Decoration();
                articlesToReturn = decoration.getArticles(stock);
                return articlesToReturn;
            default:
        }
        return null;
    }


    public int findArticle(Article article) {
        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).areTheSameArticle(article)){//(stock.get(i).getName().equalsIgnoreCase(article.getName())&& article.areTheSame())) {
                return i;
            }
        }
        return -1;
    }

    public void addArticleFromFile(String line) {



    }
}
