

public abstract class Article {

    //Init
    private String name;
    private int quantity;
    private double unitPrice;

    //Contructor
    public Article(String name, int quantity, double price) throws Exception{
        if(name == null || name.equals("")) throw new Exception("El nom de l'article és incorrecte.");
        this.name = name;
        setQuantity(quantity);
        setPrice(price);
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return unitPrice;
    }

    // Setters
    public void setQuantity(int quantity) throws Exception{
        if(quantity < 0) throw new Exception("La quantitat d'articles a afegir és incorrecta.");
        this.quantity = quantity;
    }
    public void setPrice(double price) throws Exception{
        if(price < 0.0) throw new Exception("El preu de l'article és incorrecte.");
        this.unitPrice = price;
    }

    public abstract String getArticleInformation();

}
