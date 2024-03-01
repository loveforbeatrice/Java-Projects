package BusinessLayer;
public class Knight extends Human<Weapon> {

    private final String job = "Knight";
    private final String generalType = "human";
    public Knight(String name) {
        super(name);
    }
    public void specialAction(Opponent OpponentThatHumanIsAttacking, Turn turn) {
        turn.setAttackModifier(3);
    }

    @Override
    public String getGeneralType() {
        return generalType;
    }

    @Override
    public String getJob() {
        return job;
    }

}

