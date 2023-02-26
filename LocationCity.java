/**
 * LocationCity
 */
public class LocationCity extends Location implements Comparable{
    private int price, rentPrice; 
    private Player player;

    LocationCity(String name, int locIndex, int price, int rentPrice, Player player) {
        super(name, locIndex); 
        this.price = price; 
        this.rentPrice = rentPrice; 
        this.player = player; 
    }


    boolean isOwned(){
        return this.player != null; 
    }

    // Encapsulations
    int getRentPrice() {
        return rentPrice;
    }
    void setPrice(int price) {
        this.price = price; 
    }
    int getPrice() {
        return this.price;
    }
    void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }
    Player getPlayer() {
        return this.player;
    }
    void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public int compareTo(Object o) {
        return String.valueOf(this.price).compareTo(String.valueOf(((LocationCity) o).price));
    }
}