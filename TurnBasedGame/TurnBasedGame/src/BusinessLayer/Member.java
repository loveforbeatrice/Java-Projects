package BusinessLayer;
public abstract class Member{
    public String generalType;
    private String idOrName;
    private int speed;
    public String getGeneralType() {
        return generalType;
    }
    private boolean dead = false;

    public Member(String idOrName){
        this.idOrName=idOrName;
    }
    public Member(Member member){
        this.generalType=member.getGeneralType();
        this.idOrName=member.getIdOrName();
        this.speed=member.getSpeed();
        this.dead= member.isDead();
    }

    public abstract int RandomPointsAssignment();
    public abstract int RandomSpeedAssignment();
    public abstract int RandomAttackAssignment();


    public String getIdOrName() {
        return idOrName;
    }
    public void setIdOrName(String idOrName) {
        this.idOrName = idOrName;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void died(){this.dead = true;}
    public boolean isDead(){return dead;}

}
