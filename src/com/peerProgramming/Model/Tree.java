package com.peerProgramming.Model;

import java.util.ArrayList;
import java.util.List;

public class Tree extends Article {

    private int height;

    public Tree(String name, int quantity, double price, int height) throws Exception {
        super(name, quantity, price);
        setHeight(height);
    }


    public Tree() {
    }


    public int getHeight() {
        return height;
    }


    public void setHeight(int height) throws Exception {
        if (height <= 0) throw new Exception("l'alsada es incorrecta");
        this.height = height;
    }


    @Override
    public String getArticleInformation() {
        return (getName() + " d'una alsada " + height + ": "
                + getQuantity() + " unitats a "
                + getPrice() + " cadascuna");
    }


    @Override
    public List<Article> getArticles(List<Article> stock) {
        List<Article> treeList = new ArrayList<>();
        for (Article art : stock) {
            if (art instanceof Tree) {
                treeList.add(art);
            }
        }
        return treeList;
    }

    @Override
    public boolean areTheSameArticle(Article article) {
        if (article instanceof Tree) {
            Tree tree = (Tree) article;
            if (this.getName().equalsIgnoreCase(tree.getName()) && this.getHeight() == tree.getHeight())
                return true;
        }
        return false;
    }
}
