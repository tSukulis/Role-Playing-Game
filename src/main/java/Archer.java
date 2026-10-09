import java.util.Random;

public class Archer extends Hero{
    private static final double criticalChance = 0.2;

    public Archer(int id, String name, int level, int maximumHealth, int currentHealth, int attack, int defence){
        super(id, name, level, maximumHealth, currentHealth, attack, defence);
        Weapon weapon = new Bow("wooden Bow", 10, 10);
        setEquippedWeapon(weapon);
    }


    public double getCriticalChance() {
        return criticalChance;
    }

    @Override
    public void attack(GameCharacter target){
        if(this.isAlive() && target.isAlive()) {
            System.out.println(this.getClass() + " attacked " + target.getClass() + " with attack: " + this.getAttack());
            Random random = new Random();
            int damage = calculateDamage();
            if (random.nextDouble() < criticalChance)
                damage *= 2;
            target.receiveDamage(damage);
            if (target instanceof Monster && !target.isAlive())
                this.defeatMonster((Monster)target);
        }
        else if (!this.isAlive())
            System.out.println("Archer is dead, can't attack");

        else System.out.println("Monster is dead, Archer cannot attack");
    }


    public void equipWeapon(Weapon weapon){
        if(weapon instanceof Bow && this.getInventory().containsItem(weapon)) {
            this.getInventory().addItem(this.getEquippedWeapon());
            this.setEquippedWeapon(weapon);
            this.getInventory().removeItem(weapon);
            System.out.println(weapon.getName() + " was equipped by " + this.getName());
        }
        else if(!(weapon instanceof Bow))
            System.out.println("Archer can only use Bows");
        else
            System.out.println("Weapon not in inventory");
    }
}
