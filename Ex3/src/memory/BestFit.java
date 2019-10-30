package memory;

import custom.MemoryArea;

import java.util.*;

/**
 * This memory model allocates memory cells based on the best-fit method.
 * 
 * @author "Johan Holmberg, Malmö university"
 * @since 1.0
 */
public class BestFit extends Memory {

	private LinkedList<MemoryArea> freeList;
	private HashMap<Integer,MemoryArea> allocated;

	/**
	 * Initializes an instance of a best fit-based memory.
	 * 
	 * @param size The number of cells.
	 */
	public BestFit(int size) {
		super(size);

		freeList = new LinkedList<MemoryArea>();
		allocated = new HashMap<Integer, MemoryArea>();

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

		MemoryArea bestArea = null;

		int min_address = 0;
		int min_size    = Integer.MAX_VALUE;

		for(MemoryArea ma : freeList){ //Find smallest area that is bigger than size
			if(ma.getSize() >= size && ma.getSize() < min_size){
				min_address = ma.getAddress();
				min_size	= ma.getSize();
				bestArea = ma;
				p.pointAt(ma.getAddress());
			}
		}

		freeList.remove(bestArea); //Remove the area from the list of free areas.

		allocated.put(bestArea.getAddress(),new MemoryArea(bestArea.getAddress(),size)); //Add the allocated area to the list of allocated areas

		if(bestArea.getSize()-size > 0){ //Add the leftovers back to the list, if its size is > 0
			freeList.add(new MemoryArea(bestArea.getAddress()+size,bestArea.getSize()-size));
		}

		return p;
	}
	
	/**
	 * Releases a number of data cells
	 * 
	 * @param p The pointer to release.
	 */
	@Override
	public void release(Pointer p) {
		MemoryArea area = allocated.get(p.pointsAt());
		if(area != null) {
			allocated.remove(area.getAddress());
			freeList.add(area);
			Collections.sort(freeList);

			merge();
		}
	}

	/**
	 * Merges all free areas next to each other in the memory into one bigger memory-block.
	 */
	private void merge() {
		//The list to replace freeList
		LinkedList<MemoryArea> newList = new LinkedList<MemoryArea>();
		//Create clone of freelist to work in
		LinkedList<MemoryArea> copy = new LinkedList<MemoryArea>();
		for(MemoryArea area : freeList){
			copy.add(area);
		}

		int size = copy.size();

		for(int i = 0; i <= size;i++){
			MemoryArea currentArea = copy.pollFirst();

			if(copy.peekFirst() != null){ //Check if list is not empty

				boolean enable = true;
				while(enable){
					if((copy.peekFirst() != null) && (copy.peekFirst().getAddress() == (currentArea.getAddress() + currentArea.getSize()))) { //If next area in list is after current area (in the memory)
						currentArea.setSize(currentArea.getSize() + copy.pollFirst().getSize()); //Add size of next object to current object and remove it from the list.
					} else {
						newList.add(currentArea);
						enable = false;
					}
				}
			} else {
				if(currentArea != null)	newList.add(currentArea);
			}
		}
		freeList = newList;
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

		Set<Integer> keys = allocated.keySet();
		for(Integer i : keys){
			tempList.add(allocated.get(i));
		}

		Collections.sort(tempList);

		String ps = "";

		for (int i = 0; i < tempList.size(); i++) {

			ps += tempList.get(i).getAddress() + " - " + (tempList.get(i).getAddress() + tempList.get(i).getSize()-1) + " | ";

			if(freeList.contains(tempList.get(i))){
				ps += "Free\n";
			}
			else
			if(allocated.get(tempList.get(i).getAddress()) != null)	{
				ps += "Allocated\n";
			}
		}
		System.out.println(ps);
	}
}
