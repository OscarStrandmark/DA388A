package memory;

import custom.MemoryArea;

import java.util.*;

/**
 * This memory model allocates memory cells based on the first-fit method. 
 * 
 * @author "Johan Holmberg, Malmö university"
 * @since 1.0
 */
public class FirstFit extends Memory {

	private LinkedList<MemoryArea> freeList;
	private HashMap<Integer,MemoryArea> allocated;

	/**
	 * Initializes an instance of a first fit-based memory.
	 * 
	 * @param size The number of cells.
	 */
	public FirstFit(int size) {
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

		for (int i = 0; i < freeList.size(); i++) {

			MemoryArea area = freeList.get(i); //Get current area

			if(area.getSize() >= size){ //If objects fit in current area

				p.pointAt(area.getAddress()); //Point the pointer

				freeList.remove(area); //Remove the area from the list of free areas
				allocated.put(area.getAddress(),new MemoryArea(area.getAddress(),size)); //Add the object to the list of allocated areas
				if(area.getSize()-size > 0){ //Check if remaining size != 0, this is to avoid an object with Ex. Address = 1000, size = 0
					//freeList.add(new MemoryArea(area.getAddress()+size,area.getSize()-size)); //Add the remaining area to the list of free areas
					freeList.add(i,new MemoryArea(area.getAddress()+size,area.getSize()-size));

				}

				i = freeList.size();
			}
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

			boolean found = false;

			if(freeList.size() > 0){
				int i = 0;
				while (!found && i < freeList.size()){
					if(freeList.get(i).getAddress() >= area.getAddress()){
						found = true;
						freeList.add(i,area);
					}
					i++;
				}
			}
			if(!found){
				freeList.add(area);
			}

			/*
			vvvvvvvvvvvvvvvvvvvvvvvvvvvv
			freeList.add(area);
			Collections.sort(freeList);
			^^^^^^^^^^^^^^^^^^^^^^^^^^^^
			Borttagen enligt kommentar på inlämning:
			"Hej Oscar
			Du gör rätt i din allokering, men din release() bygger på att du sorterar listan istället för att hålla den sorterad.
			Detta är dyrt och följer inte den algoritm som beskrivs.
			Ta en titt på det och skicka in igen.
			Johan
			*/

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

	/**
	 * Compacts the memory space.
	 */
	public void compact() {
		// TODO Implement this!
	}
}
