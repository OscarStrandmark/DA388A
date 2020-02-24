package memory;

import custom.MemUtil;
import custom.MemoryArea;

import java.util.HashMap;
import java.util.LinkedList;

public class FirstFit extends Memory {

    public LinkedList<MemoryArea> freeList;
    private HashMap<Integer,MemoryArea> allocated;

    public FirstFit(int size) {
        super(size);

        freeList = new LinkedList<MemoryArea>();
        allocated = new HashMap<Integer,MemoryArea>();

        MemUtil.insert(freeList,new MemoryArea(0,size),false);
    }

    @Override
    public Pointer alloc(int size) {
        
        Pointer p = new Pointer(this);

        for (int i = 0; i < freeList.size(); i++) {
            MemoryArea area = freeList.get(i);

            if(area.getSize() >= size){

                p.pointAt(area.getAddress());

                freeList.remove(area);
                allocated.put(area.getAddress(),new MemoryArea(area.getAddress(),size));
                if(area.getSize() - size > 0){
                    MemUtil.insert(freeList,new MemoryArea(area.getAddress() + size, area.getSize() - size), true);
                }
            }
        }
        
        return null;
    }

    @Override
    public void release(Pointer p) {

    }

    @Override
    public void printLayout() {
    
    }

    public static void main(String[] args) {
        FirstFit ff = new FirstFit(1000);
        MemUtil.insert(ff.freeList,new MemoryArea(0,100),true);
    }
}
