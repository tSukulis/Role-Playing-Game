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
        this.level = Math.max(1, level);
        this.maximumHealth = Math.max(0, maximumHealth);
        this.currentHealth = clamp(currentHealth, 0, this.maximumHealth);
        this.attack = Math.max(0, attack);
        this.defence = Math.max(0, defence);
    }

    private int clamp(int value, int min, int max) {
        return Math.min(Math.max(value, min), max);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }

    public void setMaximumHealth(int maximumHealth) {
        this.maximumHealth = Math.max(0, maximumHealth);
        this.currentHealth = clamp(this.currentHealth, 0, this.maximumHealth);
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
        this.attack = Math.max(0, attack);
    }

    public void setLevel(int level) {
        this.level = Math.max(1, level);
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = clamp(currentHealth, 0, this.maximumHealth);
    }

    public void setDefence(int defence) {
        this.defence = Math.max(0, defence);
    }

    public abstract void attack(GameCharacter target);

    public void receiveDamage(int damage){
        int actualDamage = Math.max(0, damage - getDefence());
        setCurrentHealth(Math.max(0, getCurrentHealth() - actualDamage));
    }

    public boolean isAlive(){
        return currentHealth > 0;
    }


}
