import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dragon extends Monster implements Flyable{
    private static final double DODGECHANCE = 0.5;
    private boolean flying;


    public Dragon(int id, String name, int level, int maximumHealth, int currentHealth, int attack, int defence, int experienceReward, int goldReward){
        super(id, name, level, maximumHealth, currentHealth, attack, defence, experienceReward, goldReward, createLoot());
    }

    private static List<Item> createLoot() {
        List<Item> loot = new ArrayList<>();
        loot.add(new HealthPotion("Health Potion", 0, 10));
        loot.add(new ManaPotion("Mana Potion", 0, 10));
        loot.add(new Sword("Steel sword", 0, 20));
        return loot;
    }

    @Override
    public void fly(){
        this.flying = true;

    }

    @Override
    public void receiveDamage(int damage){
        Random random = new Random();
        if(random.nextDouble() < DODGECHANCE){
            fly();
            System.out.println("Dragon flew away and avoided the attack");
        }
        else{
            super.receiveDamage(damage);
        }
    }

}
