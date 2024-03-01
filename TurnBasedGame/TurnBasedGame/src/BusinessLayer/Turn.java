package BusinessLayer;

public class Turn {
    private String OwnerIdOrName;
    private double attackModifier;
    public Turn(String IdorName){
        this.OwnerIdOrName=IdorName;
        this.attackModifier=1;
    }
    public void setOwnerIdOrName(String ownerIdOrName) {OwnerIdOrName = ownerIdOrName;}
    public void setAttackModifier(double attackModifier) {
        this.attackModifier = attackModifier;
    }

    public double getAttackModifier() {
        return attackModifier;
    }

    public String getOwnerIdOrName(){return OwnerIdOrName;}

}



    //metotlara 1 2 3 4 5 atadık her biri için farklı skip etme tarzı olacak bunları TBGamede belirleyeğiz
    //1 düz oyun
    //2 bir el vuruş diğer el vurmayacak
    //3 bu el Knight can skip the current turn and deals 3 × attack on his next turn. knight muhabbeti
    //4 bu el iki turn vuracak sonra vuramayacak goblin için
    //5 hunter bu da bu el az vurup sonraki el daha çok vuracak mı iki turn atacak mı öyleyli bir şeyler
    //birkaç metot eksiği falan var unutmamak lazım
    //wolfun specialı da yok hala orada copy constructor falan filanzi
