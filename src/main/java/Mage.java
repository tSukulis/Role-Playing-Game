public class Mage extends Hero{
    private static final int SPELL_COST = 20;
    private static final int SPELL_DAMAGE = 20;
    private int currentMana;
    private int maximumMana;

    public Mage(int id, String name, int level, int maximumHealth, int currentHealth, int attack, int defence){
        super(id, name, level, maximumHealth, currentHealth, attack, defence);
        this.currentMana = 100;
        this.maximumMana = 100;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public int getMaximumMana() {
        return maximumMana;
    }

    public boolean hasEnoughMana(){
        return currentMana >= SPELL_COST;
    }

    @Override
    public void attack(GameCharacter target){
        if (isAlive() && target.isAlive()){
            if (hasEnoughMana()) {
                int damage = calculateDamage() + SPELL_DAMAGE;
                System.out.println(this.getClass() + " attacked " + target.getClass() + " with attack: " + damage);
                this.currentMana -= SPELL_COST;
                target.receiveDamage(damage);
            } 
            else{
                System.out.println(this.getClass() + " attacked " + target.getClass() + " with attack: " + calculateDamage());
                target.receiveDamage(calculateDamage());
            }
            if (target instanceof Monster && !target.isAlive())
                this.defeatMonster((Monster)target);
        }
        else if (!this.isAlive())
            System.out.println("Mage is dead, can't attack");

        else System.out.println("Monster is dead, Mage cannot attack");
    }

    public void equipWeapon(Weapon weapon) {


    }





    }
