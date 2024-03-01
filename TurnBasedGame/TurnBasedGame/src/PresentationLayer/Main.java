package PresentationLayer;
import BusinessLayer.Human;
import BusinessLayer.Opponent;
import BusinessLayer.Weapon;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        TBGame tb = new TBGame();
        TBGame.Menu menu = tb.new Menu();
        menu.startGame();
        //önceki-sonrakinn min 0 olması gerektiğini yaz
    }

}
