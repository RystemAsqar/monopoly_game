/**
 * Jail
 */
public class Jail extends Location{
    
    private int type;
    public static int goToJailLocIndex;
    public static int jailLocIndex;


    Jail (String name, int locIndex, int type) {
        super(name, locIndex); 
        this.type = type; 

        if (type == 0) {
            jailLocIndex = locIndex; 
        } else {
            goToJailLocIndex = locIndex; 
        }
    }

    void setType(int type) {
        this.type = type; 
    }
    int getType() {
        return this.type; 
    }
    
}