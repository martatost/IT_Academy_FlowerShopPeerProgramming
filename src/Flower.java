

public class Flower extends Article{


    private String color;

    public Flower(String name, int quantity, double price, String color) throws Exception{
        super(name, quantity, price);
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) throws Exception{
        if((color == null)||(color.equals(""))) throw new Exception("El color de la flor es incorrecte");
        this.color = color;
    }

    @Override
    public String getArticleInformation() {
        return (getName() + " de color " + color.toLowerCase() + ": "
                + getQuantity() + " unitats a "
                + getPrice()+" cadascuna");
    }
}
