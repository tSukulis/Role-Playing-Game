public abstract class Hero extends  GameCharacter{
    private int experience;
    private int gold;
    private Weapon equippedWeapon;
    private Inventory inventory;


    public Hero(int id, String name, int level, int maximumHealth, int currentHealth, int attack, int defence){
        super(id, name, level, maximumHealth, currentHealth, attack, defence);
        experience = 0;
        gold = 0;
        equippedWeapon = null;
        inventory = new Inventory();
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public int getExperience() {
        return experience;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getGold() {
        return gold;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    @Override
    public void attack(GameCharacter target){
        if(this.isAlive() && target.isAlive()) {
            System.out.println(this.getClass() +" " + this.getName() +  " attacked " + target.getClass() + " " + target.getName() + " with attack: " + calculateDamage());
            target.receiveDamage(calculateDamage());
            if (target instanceof Monster && !target.isAlive()) {
                this.defeatMonster((Monster) target);
                System.out.println("#####################");
            }
        }
        else if (!this.isAlive())
           System.out.println("Hero is dead, can't attack");

        else System.out.println("Monster is dead, Hero cannot attack");
    }

    public int calculateDamage(){
        if(equippedWeapon != null)
            return getAttack() + equippedWeapon.getAttackBonus();
        else
            return getAttack();
    }

    public void levelUp(){
            this.setLevel(this.getLevel() + 1);
            this.experience = experience - 100;
    }

    public void defeatMonster(Monster monster){
        System.out.println(monster.getName() +" was defeated!!!");
        this.experience += monster.getExperienceReward();
        this.gold += monster.getGoldReward();
        while(this.experience >= 100) {
            this.levelUp();
            System.out.println(this.getName() + " reached level " + this.getLevel());
        }
    }

    public boolean checkGoldForItem(Item item){
        if(this.getGold() >= item.getValue())
            return true;
        return false;
    }

    public void buyItem(Item item){
        if(checkGoldForItem(item)) {
            this.setGold(this.gold - item.getValue());
            this.inventory.addItem(item);
            System.out.println(item.getName() + " item was added to " + this.getName() + " inventory");
        }
        else System.out.println(this.getName() + " has not enough gold for item: " + item.getName());
    }


    public abstract void equipWeapon(Weapon weapon);


    public void useItem(Item item){
        if(item instanceof Usable)
            ((Usable) item).use(this);

    }

    public void heroStatus(){
        System.out.print("Name:" + super.getName() + " " + " Level:" + super.getLevel() +", Health:" + super.getCurrentHealth() + "/" + super.getMaximumHealth() + ", Attack:" + super.getAttack() + ", Defence:" + super.getDefence() + ", Experience:" + this.getExperience() + ", Gold:" + this.getGold());
        if(this.getEquippedWeapon() != null)
            System.out.println(", Equipped Weapon: " + this.getEquippedWeapon().getName() + ", Attack Bonus:" + this.getEquippedWeapon().getAttackBonus());
        else
            System.out.println(", Equipped Weapon: None");
    }

}
