public class Tank1 extends Droid {

    public Tank1(String name, int atk, int hp) {
        super(name, atk, hp);
        this.addAbility("Taunt");
    }

    @Override
    public void repair(){
        this.setDmg(getMaxDmg()) ;
        this.setHp(getMaxHp()) ;
        this.setName(getStartName()) ;
        this.clearAbility();
        this.addAbility("Taunt");
    }
}
