import java.util.ArrayList;
import java.util.List;

public class FlowerShop {
    private String name;
    private List<Article> stock = new ArrayList<>();

    public FlowerShop(String name) throws Exception{
        setName(name);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) throws Exception{
        if(name == null || name.equals("")) throw new Exception("El nom de la floristeria �s incorrecte.");
        this.name = name;
    }

    //Public Methods
    public void addArticle(Article article) throws Exception {
        int i = findArticle(article);
        if(i != -1) {
            int newQuantity = stock.get(i).getQuantity()+article.getQuantity();
            stock.get(i).setQuantity(newQuantity);
        } else {
            stock.add(article);
        }
    }
    public int findArticle(Article article) {
        for(int i = 0; i < stock.size(); i++) {
            if(stock.get(i).getName().equalsIgnoreCase(article.getName())) {
                return i;
            }
        }
        return -1;
    }
    public List<Flower> getFlowers(){
        List<Flower> flowerList = new ArrayList<>();
        for(Article art : stock) {
            if(art instanceof Flower) {
                flowerList.add((Flower)art);
            }
        }
        return flowerList;
    }
    public List<Tree> getTrees(){
        List<Tree> treeList = new ArrayList<>();
        for(Article art : stock) {
            if(art instanceof Tree) {
                treeList.add((Tree)art);
            }
        }
        return treeList;
    }
    public List<Decoration> getDecoration(){
        List<Decoration> decorationList = new ArrayList<>();
        for(Article art : stock) {
            if(art instanceof Decoration) {
                decorationList.add((Decoration)art);
            }
        }
        return decorationList;
    }


}
