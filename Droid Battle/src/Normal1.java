public class Normal1 extends Droid {

    public Normal1(String name, int atk, int hp) {
        super(name, atk, hp);
        this.addAbility("");
    }

    @Override
    public void repair(){
        this.setDmg(getMaxDmg()) ;
        this.setHp(getMaxHp()) ;
        this.setName(getStartName()) ;
        this.clearAbility();
        this.addAbility("");
    }
}
