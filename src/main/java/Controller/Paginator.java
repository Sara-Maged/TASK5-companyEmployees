package Controller;

public class Paginator {
    private int index = 1;
    private int size = 1;

    public Paginator(int index, int size) {
        this.index = index;
        this.size = size;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
