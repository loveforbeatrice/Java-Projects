package BusinessLayer;

public class Slime extends Opponent{
    private final String type = "Slime";
    private final String generalType = "opponent";
    public Slime(int id) {
        super(id);
    }
    public  void special(Human<Weapon> HumanBeingAttacked, Turn turn){
        if(HumanBeingAttacked.isGuard()){
            HumanBeingAttacked.setPoint((int)(HumanBeingAttacked.getPoint()-getAttack()*0.25));
            double pointBeforeAddition = getPoint() + getAttack()*0.25;
            if (pointBeforeAddition>MAXPOINTSFOROPPONENTS){
                setPoint(MAXPOINTSFOROPPONENTS);
            }
            else {
                setPoint((int) pointBeforeAddition);
            }
            turn.setAttackModifier(1);
        }
            else{
            HumanBeingAttacked.setPoint(HumanBeingAttacked.getPoint()-getAttack());
            double pointBeforeAddition = getPoint() + getAttack();
            if (pointBeforeAddition>MAXPOINTSFOROPPONENTS){
                setPoint(MAXPOINTSFOROPPONENTS);
            }
            else {
                setPoint((int) pointBeforeAddition);
            }
        }
        turn.setAttackModifier(1);
    }

    public String getGeneralType() {
        return generalType;
    }
    public String getType() {
        return type;
    }


}
