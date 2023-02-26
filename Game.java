import java.util.*; 

/**
 * Game
 */
public class Game {

    Map map = new Map();
    private List<Player> players = new ArrayList<>();
    private List<Location> locations = new ArrayList<>();
    public void play() {

        map.map();
        locations = map.locations; 

        Scanner scan1 = new Scanner(System.in); 
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        
        
        int totalPlayerNum; 

        do{
            System.out.println("Enter the number of players you want :");
            totalPlayerNum = scan1.nextInt();
            if (totalPlayerNum<2 || totalPlayerNum>4){
                System.out.println("Error: Player number must between 2..4");
            }
        } while (totalPlayerNum<2 || totalPlayerNum>4);

        int i = 1;
        do {
            System.out.println("Enter Player"+i +" name: " );
            String name = scan2.nextLine();
            if (hasThisName(players,name)) {
                System.out.println("You can't take this name.");
                continue;
            }
            players.add(new Player(name));
            i++;
        } while (i <= totalPlayerNum);
        
        while(isGame(players)) {
            for (Player player: players) {
                System.out.println(player.getToken() + "'s turn");
                if(player.getJail()) {
                    System.out.println("Player " + player.getToken()+ " is in Jail!");
                    player.setJail(false);
                    continue; 
                }
                System.out.println("Press any key to roll dice");
                scan3.nextLine(); 

                Dice dice1 = new Dice(); 
                Dice dice2 = new Dice(); 
                dice1.generateDiceRoll();
                dice2.generateDiceRoll();

                int dice_result = Dice.getResult();
                Dice.setResult(0);
                System.out.println("Dice result: " + dice_result);
                int playerNewLocIndex = player.getCurrentLocIndex() + dice_result;


                if(playerNewLocIndex >= locations.size()) {
                    player.setCapital(player.getCapital() + 100); // +aqsha qosu 
                    playerNewLocIndex = playerNewLocIndex % locations.size(); 
                }
                player.setCurrentLocIndex(playerNewLocIndex);
                int playerLocIndexAfterMove = player.getCurrentLocIndex(); 
                Location playerLocAfterMove = locations.get(playerLocIndexAfterMove); 
                System.out.println("You are now on " + playerLocAfterMove.getName().toUpperCase());

                if(playerLocAfterMove instanceof Jail) {
                    Jail playerLocAfterMoveConvert = (Jail)playerLocAfterMove;
                    if(!playerLocAfterMoveConvert.getType()) {
                        player.setJail(true);
                        player.setCurrentLocIndex(Jail.jailLocIndex);
                    }
                }else if (playerLocAfterMove instanceof TaxAdmin) {
                    TaxAdmin playerLocAfterMoveConvert = (TaxAdmin)playerLocAfterMove;
                    player.setCapital(player.getCapital() - playerLocAfterMoveConvert.getTaxPrice());
                    System.out.println(player.getToken()+" paid " + playerLocAfterMoveConvert.getTaxPrice() +"$ You now have "+ player.getCapital());
                }else if (playerLocAfterMove instanceof LuckyCard) {
                    LuckyCard playerLocAfterMoveConvert = (LuckyCard) playerLocAfterMove;
                    playerLocAfterMoveConvert.randomEvent(player);
                }else if (playerLocAfterMove instanceof LocationCity) {
                    LocationCity playerLocAfterMoveConvert = (LocationCity) playerLocAfterMove;
                    if(playerLocAfterMoveConvert.isOwned()) {
                        int rentAmount = playerLocAfterMoveConvert.getRentPrice();
                        player.setCapital(player.getCapital() - rentAmount);
                        playerLocAfterMoveConvert.getPlayer().setCapital(playerLocAfterMoveConvert.getPlayer().getCapital() + rentAmount);
                    } else {
                        Scanner str = new Scanner(System.in);
                        System.out.println("You have: " + player.getCapital() + "$ and " + playerLocAfterMoveConvert.getName().toUpperCase() + "'s price: "+ playerLocAfterMoveConvert.getPrice() + "$");
                        System.out.println("Do you want to buy this location? (Y/n):");
                        String choice = str.nextLine();
                        if(choice.equals("Y") || choice.equals("y")) {
                            int price = playerLocAfterMoveConvert.getPrice(); 
                            if(player.getCapital() >= price) {
                                player.setCapital(player.getCapital()-price);
                                playerLocAfterMoveConvert.setPlayer(player);
                                player.getOwnLocation().add(playerLocAfterMoveConvert);
                                System.out.println(player.getToken()+" bought location: " + playerLocAfterMoveConvert.getName() + " and remaining money is: " + player.getCapital());
                            } else {
                                System.out.println("Sorry, You don't have enough money.");
                            }
                        }
                    }
                }
                System.out.println("**************************");
            }
        }
    }



    public boolean isGame(List<Player> players) {
        Iterator<Player> iteratorPlayers = players.iterator(); 

        while(iteratorPlayers.hasNext()) {
            Player player = iteratorPlayers.next(); 
            if(player.getCapital() < 0) {
                if(player.getOwnLocation().size() > 0) {
                    System.out.println("Player: " +  player.getToken() + " has less than 0$ so hi/she is in debt so his/her owned locations will be sold");
                    List<LocationCity> playersOwnedLocation = player.getOwnLocation(); // oiynshynyn barlyq zherleri osy listqa koshedi 
                    Collections.sort(playersOwnedLocation); 
                    Iterator<LocationCity> iteratorOwnedLocations = playersOwnedLocation.iterator();
                    while(iteratorOwnedLocations.hasNext()) {
                        LocationCity city = iteratorOwnedLocations.next(); 
                        int price = city.getPrice(); 
                        player.setCapital(player.getCapital() + price);
                        System.out.println("Player " + player.getToken() + "'s owned location " + city.getName() + " has been sold/foreclosed now and so Player " + player.getToken() + " now have " + player.getCapital() + "$");
                        city.setPlayer(null);
                        iteratorOwnedLocations.remove();

                        if (player.getCapital() >= 0) {
                            break; 
                        }
                    }
                } 
                if(player.getCapital() < 0) {
                    System.out.println("Player " + player.getToken() + " is in debt and has no owned city to be foreclosed so He/She is bankrupted so eliminated");
                        iteratorPlayers.remove();
                } 
            }
        }
        if(players.size() == 1) {
            Player winner = players.get(0);
            System.out.println("Congratulation!!! Game is over, Player "+ winner.getToken() + " won the game !!!");
            return false; 
        }else {
            return true; 
        }
    }

    // function
    public boolean hasThisName(List<Player> playerList, String name) {
        for (Player player: playerList) {
            if(player.getToken().equals(name)) {
                return true; 
            }
        }
        return false; 
    }
}