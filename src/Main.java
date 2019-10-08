import com.peerProgramming.Files.FileExtractInformation;
import com.peerProgramming.Model.*;

import java.util.List;

public class Main {

    static final int FLOWER = 1;
    static final int TREE = 2;
    static final int DECORATION = 3;

    public static void main(String[] args) throws Exception {
        String sourceFile="./files/FlowerShopPeerProgramming.txt";
        List<Article> articlesFromFile;
        FileExtractInformation file = new FileExtractInformation();

        articlesFromFile = file.FileExtractInformation(sourceFile);
        FlowerShop fileShop = new FlowerShop("Botiga des de fitxer");
        for (Article article:articlesFromFile) {
            fileShop.addArticle(article);
        }


        FlowerShop shop1 = new FlowerShop("Exemple1");
        shop1.addArticle(new Flower("Rosa", 10, 2.0, "Blanc"));
        shop1.addArticle(new Tree("Taronger", 5, 200.0, 10));
        shop1.addArticle(new Decoration("Cercat", 100, 20.0, "Fusta"));

        printStock(shop1);
        printStock(fileShop);
    }


    private static void printFlowers(FlowerShop shop) {
        System.out.println("Flors:");
        List<Article> flowers = shop.getArticles(shop.getStock(), FLOWER);
        for (Article flower : flowers) {
            System.out.println("\t- " + flower.getArticleInformation());
        }
    }


    private static void printTrees(FlowerShop shop) {
        System.out.println("Arbres:");
        List<Article> trees = shop.getArticles(shop.getStock(), TREE);
        for (Article tree : trees) {
            System.out.println("\t- " + tree.getArticleInformation());
        }
    }


    private static void printDecoration(FlowerShop shop) {
        System.out.println("Decoració:");
        for (Article decoration : shop.getArticles(shop.getStock(), DECORATION)) {
            System.out.println("\t- " + decoration.getArticleInformation());
        }
    }


    private static void printStock(FlowerShop shop) {
        System.out.println("Floristeria: " + shop.getName());
        System.out.println("Stock:");
        printTrees(shop);
        printFlowers(shop);
        printDecoration(shop);
    }
}
