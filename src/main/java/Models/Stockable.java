package Models;

public interface Stockable {
    void add(Object o, int quantity);
    void remove(Object o, int quantity);
}
