package custom;

import java.util.LinkedList;

public class MemUtil {

    public static void insert(LinkedList<MemoryArea> fl, MemoryArea m, boolean withMerge){
        boolean found = false;
        int i = -1;

        if(fl.size() == 0){
            fl.add(m);
        } else {
            while (!found && i < fl.size()){
                i++;
                if(fl.get(i).compareTo(m) > 0){
                    found = true;
                    fl.add(i,m);
                }
            }

            if(!found){
                fl.add(m);
                i = fl.size()-1;
            }

            if(withMerge){
                merge(fl,i);
            }
        }
    }

    private static void merge(LinkedList<MemoryArea> fl, int i) {
        //Check area on index before i, if they are in sequence, merge.


        boolean first = i != 0; //Check if object is first in list.
        boolean last = i != fl.size() - 1; //Check if object is last in list.

        //MemoryArea before MemoryArea at i.
        MemoryArea maBefore = null;
        if(!first){
            maBefore = fl.get(i-1);
        }

        MemoryArea ma = fl.get(i);

        //MemoryArea after MemoryArea at i.
        MemoryArea maAfter = null;
        if(!last){
            maAfter = fl.get(i+1);
        }

        if(maBefore != null && maAfter == null) {
            if(maBefore.getAddress() + maBefore.getSize() == ma.getAddress()) {
                fl.remove(i);
                fl.remove(i-1);
                MemoryArea maNew = new MemoryArea(maBefore.getAddress(),maBefore.getSize() + ma.getSize());
                insert(fl, maNew,false);
            }
        }
        else
        if(maBefore != null && maAfter != null) {
            fl.remove(i + 1);
            fl.remove(i);
            fl.remove(i - 1);
            MemoryArea maNew = new MemoryArea(maBefore.getAddress(),maBefore.getSize() + ma.getSize() + maAfter.getSize());
            insert(fl,maNew,false);
        }
        else
        if(maBefore == null && maAfter != null) {
            fl.remove(i + 1);
            fl.remove(i);
            MemoryArea maNew = new MemoryArea(ma.getAddress(),ma.getSize() + maAfter.getSize());
            insert(fl,maNew,false);
        }
    }
}
