/**
 * Location
 */
public class Location {

    private String name; 
    private int locIndex = 0; 


    Location(String name, int locIndex) {
        this.name = name; 
        this.locIndex = locIndex; 
    }

    //getter and setters --> Encapsulation
    void setLocIndex(int locIndex) {
        this.locIndex = locIndex; 
    }
    int getLocIndex() {
        return this.locIndex; 
    }
    void setName(String name) {
        this.name = name;
    }
    String getName() {
        return this.name; 
    }
}