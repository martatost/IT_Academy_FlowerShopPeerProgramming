

public class Decoration extends Article{

    private Material material;

    public Decoration (String name, int quantity, double price, String material) throws Exception{
        super(name,quantity, price);
        setMaterial(material);
    }

    public String getMaterial() {
        return material.toString().toLowerCase();
    }

    public void setMaterial(String m) throws Exception{
        try{
            this.material = Material.valueOf(m.toUpperCase());
        }
        catch (Exception e){
            throw new Exception("el material no es correcte");
        }
    }

    @Override
    public String getArticleInformation() {
        return getName() + ", de " + material.toString().toLowerCase() + ": "
                + getQuantity() + " unitats a "
                + getPrice()+" cadascuna";
    }

}
