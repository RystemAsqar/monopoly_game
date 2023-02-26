/**
 * Jail
 */
public class Jail extends Location{
    
    private int type;
    private boolean istype; 
    public static int goToJailLocIndex;
    public static int jailLocIndex;


    Jail (String name, int locIndex, boolean istype) {
        super(name, locIndex); 
        this.istype = istype; 

        if (istype) {
            jailLocIndex = locIndex; 
        } else {
            goToJailLocIndex = locIndex; 
        }
    }

    void setType(Boolean istype) {
        this.istype = istype; 
    }
    boolean getType() {
        return this.istype; 
    }
    
}