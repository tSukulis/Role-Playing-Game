import java.util.ArrayList;
import java.util.List;

public class Orc extends Monster {

    public Orc(int id, String name, int level, int maximumHealth, int currentHealth, int attack, int defence, int experienceReward, int goldReward){
        super(id, name, level, maximumHealth, currentHealth, attack, defence, experienceReward, goldReward, createLoot());

    }

    private static List<Item> createLoot() {
        List<Item> loot = new ArrayList<>();
        loot.add(new HealthPotion("Health Potion", 0, 10));
        loot.add(new Sword("Bronze Sword", 0, 5));
        return loot;
    }

    
}
