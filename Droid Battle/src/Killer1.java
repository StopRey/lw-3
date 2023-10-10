public class Killer1 extends Droid{
    public Killer1(String name, int atk, int hp) {
        super(name, atk, hp);
        this.addAbility("Doubler");
    }

    @Override
    public void repair(){
        this.setDmg(getMaxDmg()) ;
        this.setHp(getMaxHp()) ;
        this.setName(getStartName()) ;
        this.clearAbility();
        this.addAbility("Doubler");
    }
}
