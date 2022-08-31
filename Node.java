import java.awt.Image;

public class Node {
    protected String name;
    protected String type;
    protected Image image;

    public Image getImage(){
        return image;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }
    public Node(){

    }
}
