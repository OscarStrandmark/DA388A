package memory;

import custom.MemoryArea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * This memory model allocates memory cells based on the first-fit method. 
 * 
 * @author "Johan Holmberg, Malmö university"
 * @since 1.0
 */
public class FirstFit extends Memory {

	private LinkedList<MemoryArea> freeList;
	private ArrayList<MemoryArea> allocated;

	/**
	 * Initializes an instance of a first fit-based memory.
	 * 
	 * @param size The number of cells.
	 */
	public FirstFit(int size) {
		super(size);

		freeList = new LinkedList<MemoryArea>();
		allocated = new ArrayList<MemoryArea>();

		freeList.add(new MemoryArea(0,size));
	}

	/**
	 * Allocates a number of memory cells. 
	 * 
	 * @param size the number of cells to allocate.
	 * @return The address of the first cell.
	 */
	@Override
	public Pointer alloc(int size) {

		Pointer p = new Pointer(this);

		for (int i = 0; i < freeList.size(); i++) {

			MemoryArea area = freeList.get(i); //Get current area

			if(area.getSize() >= size){ //If objects fit in current area

				p.pointAt(area.getAddress()); //Point the pointer

				freeList.remove(area); //Remove the area from the list of free areas
				allocated.add(new MemoryArea(area.getAddress(),size)); //Add the object to the list of allocated areas
				if(area.getSize()-size > 0){ //Check if remaining size != 0, this is to avoid an object with Ex. Address = 1000, size = 0
					freeList.add(new MemoryArea(area.getAddress()+size,area.getSize()-size)); //Add the remaining area to the list of free areas
				}

				i = freeList.size();
			}
		}
		sortLists();
		return p;
	}
	
	/**
	 * Releases a number of data cells
	 * 
	 * @param p The pointer to release.
	 */
	@Override
	public void release(Pointer p) {
		int address = p.pointsAt();

		for (int i = 0; i < allocated.size(); i++) {
			if(allocated.get(i).getAddress() == address){
				MemoryArea obj = allocated.get(i);

				allocated.remove(obj);
				freeList.add(obj);
				i = allocated.size();
			}
		}
		sortLists();
	}
	
	/**
	 * Prints a simple model of the memory. Example:
	 * 
	 * |    0 -  110 | Allocated
	 * |  111 -  150 | Free
	 * |  151 -  999 | Allocated
	 * | 1000 - 1024 | Free
	 */
	@Override
	public void printLayout() {
		ArrayList<MemoryArea> tempList = new ArrayList<MemoryArea>();

		for(MemoryArea i : freeList){
			tempList.add(i);
		}
		for(MemoryArea i : allocated){
			tempList.add(i);
		}

		Collections.sort(tempList);

		String ps = "";

		for (int i = 0; i < tempList.size(); i++) {

			ps += tempList.get(i).getAddress() + " - " + (tempList.get(i).getAddress() + tempList.get(i).getSize()-1) + " | ";

			if(freeList.contains(tempList.get(i))){
				ps += "Free\n";
			}
			else
			if(allocated.contains(tempList.get(i)))	{
				ps += "Allocated\n";
			}
		}
		System.out.println(ps);
	}

	//Sorts lists, used for easier debugging. Don't know if lists are actually supposed to be sorted, so I'm just letting them sort by default.
	private void sortLists() {
		boolean WORK = true;
		if(WORK){
			Collections.sort(freeList);
			Collections.sort(allocated);
		}
	}
	/**
	 * Compacts the memory space.
	 */
	public void compact() {
		// TODO Implement this!
	}
}
