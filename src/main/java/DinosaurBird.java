import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DinosaurBird extends Monster implements Flyable{
    private static final double DODGECHANCE = 0.3;
    private boolean flying;

    public DinosaurBird(int id, String name, int level, int maximumHealth, int currentHealth, int attack, int defence, int experienceReward, int goldReward){
        super(id, name, level, maximumHealth, currentHealth, attack, defence, experienceReward, goldReward, createLoot());
        flying = false;
    }

    private static List<Item> createLoot() {
        List<Item> loot = new ArrayList<>();
        loot.add(new HealthPotion("Health Potion", 0, 10));
        loot.add(new Bow("Steel Bow", 0, 20));
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
        }
        else{
            super.receiveDamage(damage);
        }
    }

}
