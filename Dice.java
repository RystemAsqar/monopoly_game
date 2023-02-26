/**
 * Dice
 */
public class Dice {
    private static int dice_result = 0; 

    Dice () {

    }
    static void setResult(int dice_result) {
        Dice.dice_result = dice_result;
    }
    static int getResult() {
        return dice_result; 
    }
    void generateDiceRoll() {
        dice_result += (int) ((Math.random() * 5) + 1);
    } 
}