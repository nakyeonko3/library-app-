package practiceLambda;


public class Fruit {
    static Integer couter = 0;
    private final int id;
    private final String name;
    private final int price;
    public Fruit(String name, int price) {
        this.id = ++ couter;
        this.name = name;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
