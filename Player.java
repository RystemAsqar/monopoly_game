import java.util.List;
import java.util.ArrayList; 

/**
 * Player
 */
public class Player {

    private String token; 
    private int startCapital = 2000; // sdelal startoviy kapital na summu 2000$, dumau tak budet udobnei, chem 2 000 000 000, zdes' mnogo cifr(((
    private List<LocationCity> ownLocation = new ArrayList<>();  
    private boolean jailType = false;
    private int currentLocIndex = 0;

    public Player(String token) {
        this.token = token; 
    }


    public void setToken(String token) {
        this.token = token; 
    }
    public String getToken() {
        return this.token; 
    }
    public void setCapital(int startCapital) {
        this.startCapital = startCapital; 
    }
    public int getCapital() {
        return this.startCapital; 
    }
    public void setJail(boolean jailType) {
        this.jailType = jailType; 
    }
    public boolean getJail(){
        return this.jailType; 
    }
    public void setCurrentLocIndex(int currentLocIndex) {
        this.currentLocIndex = currentLocIndex; 
    }
    public int getCurrentLocIndex() {
        return this.currentLocIndex; 
    }
    public List<LocationCity> getOwnLocation() {
        return this.ownLocation; 
    }

}