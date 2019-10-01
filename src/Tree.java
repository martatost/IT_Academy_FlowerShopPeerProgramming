public class Tree extends Article {


    private double height;

    public Tree(String name, int quantity, double price, double height) throws Exception{
        super(name, quantity, price);
        setHeight(height);
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) throws Exception{
        if(height <= 0) throw new Exception("l'alsada es incorrecta");
        this.height = height;
    }

    @Override
    public String getArticleInformation() {
        return (getName() + " d'una alsada " + height + ": "
                + getQuantity() + " unitats a "
                + getPrice()+" cadascuna");
    }
}
