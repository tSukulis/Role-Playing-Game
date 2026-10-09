public class HealthPotion extends Item{
    private int healingAmount;

    public HealthPotion(String name, int value, int healingAmount){
        super(name, value);
        this.healingAmount = healingAmount;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    public void use(Hero hero){
        if(hero.getInventory().containsItem(this)) {
            if (hero.getCurrentHealth() < hero.getMaximumHealth()) {
                hero.setCurrentHealth(hero.getCurrentHealth() + this.healingAmount);
                if(hero.getCurrentHealth() > hero.getMaximumHealth())
                    hero.setCurrentHealth(hero.getMaximumHealth());
                hero.getInventory().removeItem(this);
                System.out.println(hero.getName() + " used health potion. Current health is " + hero.getCurrentHealth());

            }
        }
        else
            System.out.println("Item not in hero's inventory");
    }
}
