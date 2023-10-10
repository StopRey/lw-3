public class Sniper1 extends Droid{
    public Sniper1(String name, int atk, int hp) {
        super(name, atk, hp);
        this.addAbility("Rat");
    }

    @Override
    public void repair(){
        this.setDmg(getMaxDmg()) ;
        this.setHp(getMaxHp()) ;
        this.setName(getStartName()) ;
        this.clearAbility();
        this.addAbility("Rat");
    }
}
