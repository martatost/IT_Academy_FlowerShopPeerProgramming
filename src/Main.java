import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        FlowerShop shop1= new FlowerShop("Exemple1");


        shop1.addArticle(new Flower("Rosa", 10, 2.0, "Blanc"));
        shop1.addArticle(new Tree("Taronger", 5, 200.0, 10));
        shop1.addArticle(new Decoration("Cercat", 100, 20.0, "Fusta"));
        printStock(shop1);

    }

    private static void printFlowers(FlowerShop shop) {
        System.out.println("Flors:");
        for(Article flower : shop.getFlowers()) {
            System.out.println("\t- " + flower.getArticleInformation());
        }
    }
    private static void printTrees(FlowerShop shop) {
        System.out.println("Flors:");
        for(Article tree : shop.getTrees()) {
            System.out.println("\t- " + tree.getArticleInformation());
        }
    }
    private static void printDecoration(FlowerShop shop) {
        System.out.println("Decoració:");
        for(Article decoration : shop.getDecoration()) {
            System.out.println("\t- " + decoration.getArticleInformation());
        }
    }
    private static void printStock(FlowerShop shop) {
        System.out.println( "Floristeria: "+shop.getName());
        System.out.println("Stock:");
        printTrees(shop);
        printFlowers(shop);
        printDecoration(shop);
    }

}
