public class ManaPotion extends Item{
    private int manaRestored;

    public ManaPotion(String name, int value, int manaRestored){
        super(name, value);
        this.manaRestored = manaRestored;
    }

    public int getManaRestored() {
        return manaRestored;
    }

    public void use(Hero hero){
        if(hero instanceof Mage && hero.getInventory().containsItem(this)){
            if(((Mage) hero).getCurrentMana() < ((Mage) hero).getMaximumMana()) {
                ((Mage) hero).setCurrentMana(((Mage) hero).getCurrentMana() + this.manaRestored);
                if(((Mage) hero).getCurrentMana() > ((Mage) hero).getMaximumMana())
                    ((Mage) hero).setCurrentMana(((Mage) hero).getMaximumMana());
                hero.getInventory().removeItem(this);
                System.out.println(hero.getName() + " used mana potion");
            }
        }
        else if(!(hero instanceof Mage))
            System.out.println(hero.getName() + " do not use mana");
        else
            System.out.println("Item not in hero's inventory");
    }
}
