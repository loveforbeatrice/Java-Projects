package BusinessLayer;

public class SpecialAlreadyUsedException extends Exception{

    public SpecialAlreadyUsedException() {super("Special action has already been used by the character in this game.");}
    public SpecialAlreadyUsedException(String message){
        super(message);
    }
}
