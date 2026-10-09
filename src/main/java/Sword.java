public class Sword extends Weapon{

    public Sword(String name, int value, int attackBonus){
        super(name, value, attackBonus);
    }

    @Override
    public void use(Hero hero){
        hero.equipWeapon(this);
    }
}
