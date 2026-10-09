public class Warrior extends Hero{

    public Warrior(int id, String name, int level, int maximumHealth, int currentHealth, int attack, int defence){
        super(id, name, level, maximumHealth, currentHealth, attack, defence);
        Weapon weapon = new Sword("iron sword", 10, 15);
        setEquippedWeapon(weapon);
    }

    public void equipWeapon(Weapon weapon){
        if(weapon instanceof Sword && this.getInventory().containsItem(weapon)) {
            this.getInventory().addItem(this.getEquippedWeapon());
            this.setEquippedWeapon(weapon);
            this.getInventory().removeItem(weapon);
            System.out.println(weapon.getName() + " was equipped by " + this.getName());
        }
        else if (!(weapon instanceof Sword))
            System.out.println("Warrior can only use Swords");
        else
            System.out.println("Weapon not in inventory");
    }
}
