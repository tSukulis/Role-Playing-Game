import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public abstract class Monster extends GameCharacter implements Lootable{
    private int experienceReward;
    private int goldReward;
    private List<Item> loot;

    public Monster(int id, String name, int level, int maximumHealth, int currentHealth, int attack, int defence, int experienceReward, int goldReward, List<Item> loot){
        super(id, name, level, maximumHealth, currentHealth, attack, defence);
        this.experienceReward = experienceReward;
        this.goldReward = goldReward;

        if(loot == null)
            throw new IllegalArgumentException("Loot is null");
        else
            this.loot = loot;
    }

    public void setExperienceReward(int experienceReward) {
        this.experienceReward = experienceReward;
    }

    public void setGoldReward(int goldReward) {
        this.goldReward = goldReward;
    }

    public int getExperienceReward() {
        return experienceReward;
    }

    public int getGoldReward(){
        return goldReward;
    }

    public List<Item> getLoot() {
        return loot;
    }


    public void attack(GameCharacter target){
        if (this.isAlive() && target.isAlive()) {
            System.out.println(this.getClass() + " " + this.getName() + " attacked " + target.getClass() + " " + target.getName() + " with attack: " + this.getAttack());

            target.receiveDamage(getAttack());
        }
        else if(!this.isAlive())
            System.out.println(this.getName() + " is dead, can't attack");
        else
            System.out.println(target.getName() + " is dead, can't be attacked");
    }

    @Override
    public void loot(Hero hero){
        if(hero == null)
            throw new IllegalArgumentException("Hero cannot be null");

        Scanner scanner = new Scanner(System.in);
        int choice;
        while(true){
            if(this.loot.isEmpty()){
                System.out.println(hero.getName() + " can't loot, loot list is empty.");
                break;
            }
            int i = 1;
            System.out.println();
            System.out.println("Select items for looting\nselect 0 to exit");
            for(Item item: this.loot){
                System.out.print(i + ". " + item.getName() + " ");
                i++;
            }
            System.out.println();
            try {
                choice = scanner.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Wrong input");
                scanner.nextLine();
                continue;
            }
            if(choice == 0) {
                scanner.nextLine();
                break;
            }
            else if(choice >= 1 && choice <= this.loot.size()){
                hero.getInventory().addItem(this.loot.get(choice - 1));
                System.out.println(this.loot.get(choice - 1).getName() + " was added to " + hero.getName() + " inventory");
                this.loot.remove(choice - 1);
                scanner.nextLine();
            }
            else
                System.out.println("Wrong choice");
        }
    }
}
