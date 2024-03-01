package BusinessLayer;

public class Villager extends Human{
    private final String job = "Villager";
    private final String generalType = "human";

    public Villager(String name) {
        super(name);
    }
    @Override
    public String getJob() {
        return job;
    }
    @Override
    public String getGeneralType() {return generalType;}

}
