package BusinessLayer;

public class Squire extends Human<Weapon>{
    private final String job = "Squire";
    private final String generalType = "human";

    public Squire(String name) {super(name);}

    public void specialAction(Opponent opponentThatHumanIsAttacking, Turn turn) {
            turn.setAttackModifier(0.5);
        modifierAttack(opponentThatHumanIsAttacking,turn);
       turn.setAttackModifier(1);
            setStamina(10);
    }
    @Override
    public String getGeneralType() {return generalType;}
    @Override
    public String getJob() {return job;}
}
