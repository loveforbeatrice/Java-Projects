package BusinessLayer;

public class InsufficientStaminaException extends Exception{

    public InsufficientStaminaException() {
        super("Insufficient stamina to perform the action.");
    }

    public InsufficientStaminaException(String message){
        super(message);
    }
}
