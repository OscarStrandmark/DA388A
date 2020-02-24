package memory;

public class BestFit extends Memory {

    public BestFit(int size) {
        super(size);
    }

    @Override
    public Pointer alloc(int size) {
        return null;
    }

    @Override
    public void release(Pointer p) {

    }

    @Override
    public void printLayout() {

    }
}
