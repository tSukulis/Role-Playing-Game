public abstract class GameCharacter {


    private int id;
    private String name;
    private int level;
    private int maximumHealth;
    private int currentHealth;
    private int attack;
    private int defence;


    public GameCharacter(int id, String name, int level, int maximumHealth, int currentHealth, int attack, int defence){
        this.id = id;
        this.name = name;
        this.level = level;
        this.maximumHealth = maximumHealth;
        this.currentHealth = currentHealth;
        this.attack = attack;
        this.defence = defence;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public abstract void attack(GameCharacter target);

    public void receiveDamage(int damage){
        setCurrentHealth(getCurrentHealth() - damage);
        if(getCurrentHealth() < 0)
            setCurrentHealth(0);
    }

    public boolean isAlive(){
        return currentHealth > 0;
    }


}
