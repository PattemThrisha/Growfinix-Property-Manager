public class Property {

    
    private int id;
    private String city;
    private double price;
    private String type;

    
    public Property(int id, String city, double price, String type) {
        this.id = id;
        this.city = city;
        this.price = price;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    
    public String toString() {
        return "ID: " + id + ", City: " + city +
               ", Price: " + price + ", Type: " + type;
    }
}