package PageObjects;

public class Post {
    private int id;

    public Post(int id) {
        this.id = id;
    }

    public Post(){
        super();
    }

    public int getId(){
        return id;
    }
}
