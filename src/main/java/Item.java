public abstract class Item implements Usable{
    private String name;
    private int value;

    public Item(String name, int value){
        this.name = name;
        this.value = value;

    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

}
