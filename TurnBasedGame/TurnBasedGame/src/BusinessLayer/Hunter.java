package BusinessLayer;

public class Hunter extends Human<Weapon> {
    private final String job = "Hunter";
    private final String generalType = "human";
    public Hunter(String name) {
        super(name);
    }

    //stamina durumuna bakamadık tam (Serkan sanırım 0 dedi)

    public void specialAction(Opponent OpponentThatHumanIsAttacking, Turn turn) {
        turn.setAttackModifier(0.5);
        //goblince çağrılan methodu çağırcaz
    }

    @Override
    public String getJob() {
        return job;
    }
    @Override
    public String getGeneralType() {return generalType;}
}
