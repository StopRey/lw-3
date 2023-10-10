public class Pusher1 extends Droid{
    public Pusher1(String name, int atk, int hp) {
        super(name, atk, hp);
        this.addAbility("Wind");
    }

    @Override
    public void repair(){
        this.setDmg(getMaxDmg()) ;
        this.setHp(getMaxHp()) ;
        this.setName(getStartName()) ;
        this.clearAbility();
        this.addAbility("Wind");
    }
}
