package com.peerProgramming.Files;

import com.peerProgramming.Model.Article;
import com.peerProgramming.Model.Decoration;
import com.peerProgramming.Model.Flower;
import com.peerProgramming.Model.Tree;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileExtractInformation {

    private Throwable LoggerUtil;

    public void FileExtractInformation() {
    }

    @SuppressWarnings("unchecked")
    public List<Article> FileExtractInformation(String sourceFile){
        List<Article> articles = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(sourceFile));

            for (Object object : jsonArray) {
                JSONObject article = (JSONObject) object;
                String name = String.valueOf(article.get("name"));
                int quantity = Integer.parseInt(String.valueOf(article.get("quantity")));
                double unitPrice = Double.parseDouble(String.valueOf(article.get("unitPrice")));

                if (article.get("material") != null) {
                    Decoration decoration = new Decoration(name, quantity, unitPrice, String.valueOf(article.get("material")));
                    articles.add(decoration);
                }
                if (article.get("color") != null) {
                    Flower flower = new Flower(name, quantity, unitPrice, String.valueOf(article.get("color")));
                    articles.add(flower);
                }
                if (article.get("height") != null) {
                    Tree tree = new Tree(name, quantity, unitPrice, Integer.parseInt(String.valueOf(article.get("height"))));
                    articles.add(tree);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return articles;
    }
}
