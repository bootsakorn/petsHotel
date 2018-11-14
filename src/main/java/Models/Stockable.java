package Models;

public interface Stockable {
    void insert(String name, int qualtity);
    void add(String name, int qualtity);
    void remove(String name, int qualtity);
}
