public class Main {
    public static void main(String[] args) {


        Hero archer = new Archer(1, "mike", 10, 100, 90, 20, 30);
        Monster dragon = new Dragon(10, "phisk", 1000, 1000, 1000, 500, 600, 100, 200);

        Hero warrior = new Warrior(1, "Nick the warrior", 10, 100, 100, 30, 40);

        Monster orc1 = new Orc(2, "Orc", 5, 100, 100, 10, 20, 25, 50);
        Monster orc2 = new Orc(3, "Orc", 5, 100, 100, 10, 20, 25, 10);
        Monster orc3 = new Orc(4, "Orc", 5, 100, 100, 10, 20, 25, 10);
        Monster orc4 = new Orc(5, "Orc", 5, 100, 100, 10, 20, 25, 10);

        Mage mage = new Mage(10, "Rastoder", 90, 100, 100, 10, 30);
        Mage mage2 = new Mage(11, "Levi", 90, 100, 100, 10, 30);


        ManaPotion manaPotion1 = new ManaPotion("mana", 10, 10);
        HealthPotion healthPotion1 = new HealthPotion("health1", 10, 15);
        warrior.getInventory().addItem(healthPotion1);
        warrior.getInventory().addItem(manaPotion1);

        Weapon bronzeSword = new Sword("Bronze Sword", 0, 10);
        Weapon bow = new Bow("Bronze Bow", 0, 10);
        warrior.getInventory().addItem(bronzeSword);
        warrior.getInventory().viewInventory();
        warrior.heroStatus();
        mage.heroStatus();
        System.out.println();


/*
        warrior.attack(orc1);
        warrior.attack(orc1);
        warrior.attack(orc1);
        warrior.attack(orc1);
        System.out.println(warrior.getName() + "'s experience is: " + warrior.getExperience());
        System.out.println(warrior.getName() + "'s level is: " + warrior.getLevel());
        System.out.println(warrior.getName() + "'s gold is: " + warrior.getGold());

        orc2.attack(warrior);
        System.out.println(warrior.getName() + "s health is " + warrior.getCurrentHealth());

        warrior.buyItem(healthPotion1);

        System.out.println(warrior.getInventory().getInventory());

        warrior.useItem(healthPotion1);
        System.out.println(warrior.getName() + "s health is " + warrior.getCurrentHealth());
        System.out.println(warrior.getInventory().getInventory());

        Weapon newWeapon = new Sword("Steel sword", 40, 20);
        warrior.buyItem(newWeapon);
        warrior.useItem(newWeapon);
        System.out.println(warrior.getInventory().getInventory());
        System.out.println(warrior.getInventory().getInventory().size());
        System.out.println(warrior.getName() + "'s equipped Weapon is " + warrior.getEquippedWeapon().getName());

        System.out.println("####################################");
        System.out.println(mage.getName() + "'s currentMana is " + mage.getCurrentMana());
        mage.attack(orc2);
        mage.attack(orc2);
        mage.attack(orc2);
        mage.attack(orc2);
        System.out .println(mage.getName() + "'s experience is " + mage.getExperience());
        System.out.println(mage.getName() + "'s currentMana is " + mage.getCurrentMana());

        mage.buyItem(manaPotion1);

        System.out.println(mage.getInventory().getInventory());

        manaPotion1.use(mage);
        System.out.println(mage.getName() + "'s currentMana is " + mage.getCurrentMana());
        manaPotion1.use(mage);
        System.out.println(mage.getInventory().getInventory());



         */

        
        warrior.getInventory().viewInventory();
        try {
            Battle battle = new Battle(warrior, orc1);
            battle.run();
        }
        catch (IllegalArgumentException e ){
            System.out.println("Could not start battle: " + e.getMessage());
        }
        System.out.println("*************************");
        warrior.getInventory().viewInventory();

        //orc1.loot(archer);
        warrior.useItem(bronzeSword);
        warrior.heroStatus();

        
    }




}
