package BusinessLayer;

public interface ICharacter<W>{

    public void punch(Opponent opponent,Turn turn);
    public <W extends Weapon> void attackWithWeapon(Opponent opponent,double modifier, int input);
    public void guard();
    public void run();
    public void specialAction(Opponent OpponentThatHumanIsAttacking,Turn turn);




}
