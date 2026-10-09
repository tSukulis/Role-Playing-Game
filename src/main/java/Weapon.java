public abstract class Weapon extends Item{
    private int attackBonus;

    public Weapon(String name, int value, int attackBonus){
        super(name, value);
        this.attackBonus = attackBonus;
    }

    public int getAttackBonus() {
        return attackBonus;
    }
}
