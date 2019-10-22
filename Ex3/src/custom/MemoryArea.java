package custom;

public class MemoryArea implements Comparable {

    private int address;
    private int size;

    /**
     * An object that represents an area in the memory.
     *
     * @param address The address of the objects first cell
     * @param size The size of the allocated area
     */
    public MemoryArea(int address, int size){
        this.address = address;
        this.size = size;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(Object o) {

        //Used to sort lists of free/allocated areas. Will compare based on address.
        MemoryArea cArea = (MemoryArea) o;

        if(address > cArea.getAddress()) return  1;
        if(address < cArea.getAddress()) return -1;
        return 0;
    }
}
