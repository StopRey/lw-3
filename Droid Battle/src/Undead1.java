public class Undead1 extends Droid{
    public Undead1(String name, int atk, int hp) {
        super(name, atk, hp);
        this.addAbility("Shield");
    }

    @Override
    public void repair(){
        this.setDmg(getMaxDmg()) ;
        this.setHp(getMaxHp()) ;
        this.setName(getStartName()) ;
        this.clearAbility();
        this.addAbility("Shield");
    }
}
