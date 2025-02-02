package batches;

import memory.*;

public class ComplexBatch {

	public static void main(String[] args) {
		ComplexBatch batch = new ComplexBatch();
		batch.run();
	}
	
	public int[] range(int start, int stop) {
		int[] range = new int[stop - start + 1];
		
		for (int i = 0; i < range.length; i++) {
			range[i] = start + i;
		}
		
		return range;
	}

	public void run() {
		System.out.println("First fit");
		run(new FirstFit(1000)); // Swap this for  your own implementation
		System.out.println("\nBest fit");
		run(new BestFit(1000)); // Swap this for  your own implementation
	}

	public void run(Memory m) {
		Pointer[] ps = new Pointer[20];

		//1
		ps[0] = m.alloc(100);
		ps[0].write(range(1, 100));
		//2
		ps[1] = m.alloc(200);
		ps[1].write(range(1001, 1200));
		//3
		ps[2] = m.alloc(500);
		ps[2].write(range(101, 600));
		//4
		ps[3] = m.alloc(200);
		ps[3].write(range(1, 200));
		//5
		m.release(ps[2]);
		//6
		ps[4] = m.alloc(50);
		ps[4].write(range(51, 100));
		//7
		ps[5] = m.alloc(5);
		ps[5].write(range(42, 46));
		//8
		ps[6] = m.alloc(90);
		ps[6].write(range(5000, 5089));
		//9
		m.release(ps[0]);
		//10
		ps[7] = m.alloc(60);
		ps[7].write(range(10, 69));
		//11
		m.release(ps[4]);
		//12
		ps[8] = m.alloc(45);
		ps[8].write(range(1, 45));
		//13
		m.release(ps[5]);
		//14
		ps[9] = m.alloc(10);
		ps[9].write(range(16, 25));
		//15
		m.release(ps[6]);
		//16
		ps[10] = m.alloc(40);
		ps[10].write(range(301, 340));
		//17
		ps[11] = m.alloc(200);
		ps[11].write(range(1, 200));
		//18
		ps[12] = m.alloc(35);
		ps[12].write(range(501, 535));
		//19
		ps[13] = m.alloc(25);
		ps[13].write(range(1, 25));
		//20
		ps[14] = m.alloc(60);
		ps[14].write(range(1, 60));
		//21
		ps[15] = m.alloc(60);
		ps[15].write(range(1, 60));
		//22
		m.release(ps[3]);
		m.release(ps[13]);
		m.release(ps[12]);
		//23
		ps[16] = m.alloc(170);
		ps[16].write(range(10001, 10170));

//		m.compact();
		//24
		ps[17] = m.alloc(30);
		ps[17].write(range(40, 65));
		//25
		ps[18] = m.alloc(40);
		ps[18].write(range(1, 40));
		//26
		ps[19] = m.alloc(5);
		ps[19].write(range(11, 15));

		m.printLayout();

		//27
		// After these last releases, the memory table should be empty
		m.release(ps[1]);
		m.release(ps[7]);
		m.release(ps[8]);
		m.release(ps[9]);
		m.release(ps[10]);
		m.release(ps[11]);
		m.release(ps[14]);
		m.release(ps[15]);
		m.release(ps[16]);
		m.release(ps[17]);
		m.release(ps[18]);
		m.release(ps[19]);

		m.printLayout();

	}
}
