import java.util.ArrayList;
import java.util.List;

public class Goblin extends Monster{

    public Goblin(int id, String name, int level, int maximumHealth, int currentHealth, int attack, int defence, int experinceReward, int goldReward){
        super(id, name, level, maximumHealth, currentHealth, attack, defence, experinceReward, goldReward, createLoot());

    }

    private static List<Item> createLoot() {
        List<Item> loot = new ArrayList<>();
        loot.add(new HealthPotion("Health Potion", 0, 10));
        return loot;
    }



}
