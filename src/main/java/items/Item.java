package items;

public interface Item {
    String name = "";
    String description = "";

    String getName();
    void use();
    String examine();
}
