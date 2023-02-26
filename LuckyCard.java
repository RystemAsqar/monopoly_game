import java.util.*;


/**
 * LuckyCard
 */
public class LuckyCard extends Location{

    private int prices[] = {-500,-400,-300,-200,-100,100,200,300,400,500};
    private static List<Integer> luckyCardLoc = new ArrayList<>();

    LuckyCard(String name, int locIndex) {
        super(name, locIndex); 
        luckyCardLoc.add(locIndex);
    }
    static List<Integer> getLuckyCardLoc() {
        return luckyCardLoc; 
    }

    void randomEvent(Player player) {
        int random = (int)(Math.random());

        switch(random) {
            case 0: 
                deCreaseAndIncreaseCash(player);
                break;
            case 1:
                goToTheJail(player);
                break; 
            default: 
                break;
        }

    }

    void deCreaseAndIncreaseCash(Player player) {
        Random rand = new Random(); 
        int random_index = rand.nextInt(prices.length); 
        int random_price = prices[random_index];

        if(random_price > 0) {
            System.out.println("You take a lucky card and your cash has been increased by " + random_price + "$");
        }else {
            System.out.println("You take a lucky card and your cash has been decreased by " + random_price + "$");
        }
        player.setCapital(player.getCapital()+random_price);
    }

    void goToTheJail(Player player) {
        System.out.println("OOOOOPSSS: You are in Jail now :(");
        player.setJail(true);
        player.setCurrentLocIndex(Jail.jailLocIndex);
    }
}