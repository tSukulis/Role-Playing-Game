import java.util.InputMismatchException;
import java.util.Scanner;

public class Battle {
    private Hero hero;
    private Monster monster;


    public Battle(Hero hero, Monster monster){
        if(hero == null || monster == null)
            throw new IllegalArgumentException("Hero and Monster cannot be null");

        if(!hero.isAlive() || !monster.isAlive())
            throw new IllegalArgumentException("Hero and Monster must be alive");

        this.hero = hero;
        this.monster = monster;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(hero.getName() + "'s health is " + hero.getCurrentHealth());
        System.out.println(monster.getName() + "'s health is " + monster.getCurrentHealth());
        while(hero.isAlive() && monster.isAlive()){
            int choice;
            while(true){
                System.out.println("Choose hero's action");
                System.out.println("1. attack");
                System.out.println("2. use item");
                try {
                    choice = scanner.nextInt();
                }
                catch (InputMismatchException e){
                    System.out.println("Wrong choice.");
                    scanner.nextLine();
                    continue;
                }
                scanner.nextLine();
                if(choice == 1){
                    hero.attack(monster);
                    break;
                }
                else if (choice == 2) {
                    if(itemUse(scanner))
                        break;
                    else{
                        hero.attack(monster);
                        break;
                    }
                }
                else{
                    System.out.println("Wrong input");
                }
            }
            System.out.println(monster.getName() + "'s current health is " + monster.getCurrentHealth());
            if(!monster.isAlive()) {
                break;
            }

            monster.attack(hero);
            System.out.println(hero.getName() + "'s health is " + hero.getCurrentHealth());
            if(!hero.isAlive())
                break;

        }
        if(hero.isAlive() && !monster.isAlive()){
            System.out.println("#####"+hero.getName() + " won the battle against " + monster.getName()+"#####");
            System.out.println(hero.getName() + "'s experience is " + hero.getExperience());
            System.out.println(hero.getName() + "'s level is " + hero.getLevel());
            monster.loot(hero);
        }
        else if(!hero.isAlive() && monster.isAlive()){
            System.out.println("#####"+monster.getName() + " won the battle against " + hero.getName()+"#####");
        }
    }

    private boolean itemUse(Scanner scanner){
        if(hero.getInventory().getInventory().isEmpty()){
            System.out.println("Empty inventory.");
            return false;
        }
        int choice;
        while (true) {
            int i = 0;
            for (Item item : hero.getInventory().getInventory()) {
                System.out.println(++i + ": " + item.getName());
            }
            System.out.println("Choose an item to use.");
            try {
                choice = scanner.nextInt();
            }
            catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Wrong input.");
                continue;
            }
            scanner.nextLine();
            if (choice < 1 || choice > hero.getInventory().getInventory().size()) {
                System.out.println("wrong input");
            }
            else {
                hero.useItem(hero.getInventory().getInventory().get(choice - 1));
                return true;
            }
        }
    }
}
