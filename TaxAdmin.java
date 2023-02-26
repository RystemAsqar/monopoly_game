import java.util.ArrayList;
import java.util.List;

/**
 * TaxAdmin
 */
public class TaxAdmin extends Location {

    private static List<Player> listOfPlayers_taxAdmin = new ArrayList<>(); 
    private int taxPrice; 

    public TaxAdmin(String name, int locIndex, int taxPrice) {
        super(name, locIndex); 
        this.taxPrice = taxPrice; 
    }
    int getTaxPrice() {
        return this.taxPrice;
    }
    static List<Player> getListOfPlayersTaxAdmin() {
        return listOfPlayers_taxAdmin;
    }

}