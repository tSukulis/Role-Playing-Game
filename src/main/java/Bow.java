public class Bow extends Weapon{

    public Bow(String name, int value, int attackBonus){
        super(name, value, attackBonus);
    }

    @Override
    public void use(Hero hero){
        hero.equipWeapon(this);

    }
}
