package BusinessLayer;

public class NotAUniqueNameException extends Exception {

    public NotAUniqueNameException() {super("This name has already been used!");}
    public NotAUniqueNameException(String message){super(message);}


}
