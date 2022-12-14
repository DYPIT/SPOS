package Memory_Management;

import java.util.Scanner;

public class MM_Techniques {
	public static void FirstFit(int[] jb, int[] mem, int jobs, int blocks, float tot) {
		int[] vis = new int[blocks];
		float space = 0;

		for (int i = 0; i < jobs; i++) {
			for (int j = 0; j < blocks; j++) {
				if (vis[j] == 1)
					continue;
				if (jb[i] <= mem[j]) {
					vis[j] = 1;
					System.out.println("Job " + (i + 1) + " Allocated to Block " + (j + 1));
					space += mem[j];
					break;
				}
			}
		}
		System.out.println("Space Utilization is :- " + (space / tot));
	}

	public static void BestFit(int[] jb, int[] mem, int jobs, int blocks, float tot) {
		int[] vis = new int[blocks];
		float space = 0;

		for (int i = 0; i < jobs; i++) {
			int mini = Integer.MAX_VALUE;
			int ind = -1;
			for (int j = 0; j < blocks; j++) {
				if (vis[j] == 1)
					continue;
				if (jb[i] <= mem[j]) {
					int diff = (mem[j] - jb[i]);
					if (mini > diff) {
						mini = diff;
						ind = j;
					}
				}
			}
			if (ind != -1) {
				vis[ind] = 1;
				System.out.println("Job " + (i + 1) + " Allocated to Block " + (ind + 1));
				space += mem[ind];
			}
		}
		System.out.println("Space Utilization is :- " + (space / tot));
	}

	public static void WorstFit(int[] jb, int[] mem, int jobs, int blocks, float tot) {
		int[] vis = new int[blocks];
		float space = 0;

		for (int i = 0; i < jobs; i++) {
			int maxi = Integer.MIN_VALUE;
			int ind = -1;
			for (int j = 0; j < blocks; j++) {
				if (vis[j] == 1)
					continue;
				if (jb[i] <= mem[j]) {
					int diff = (mem[j] - jb[i]);
					if (maxi < diff) {
						maxi = diff;
						ind = j;
					}
				}
			}
			if (ind != -1) {
				vis[ind] = 1;
				System.out.println("Job " + (i + 1) + " Allocated to Block " + (ind + 1));
				space += mem[ind];
			}
		}
		System.out.println("Space Utilization is : " + (space / tot));
	}

	public static void NextFit(int[] jb, int[] mem, int jobs, int blocks, int temp, float tot) {
		int vis[] = new int[blocks];
		float space = 0;

		for (int i = 0; i < jobs; i++) {
			int ind = temp;
			for (int j = 0; j < blocks; j++) {

				if (vis[ind] == 1) {
					ind = (ind + 1) % blocks;
					continue;
				}
				if (jb[i] <= mem[ind]) {
					vis[ind] = 1;
					System.out.println("Job " + (i + 1) + " Allocated to Block " + (ind + 1));
					space += mem[ind];
					break;
				}
				ind = (ind + 1) % blocks;
			}
		}
		System.out.println("Space Utilization is : " + (space / tot));
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int jobs, blocks;
		System.out.println("Enter the no of memory Blocks");
		blocks = sc.nextInt();

		System.out.println("Enter the number of jobs: ");
		jobs = sc.nextInt();

		int[] jb = new int[jobs];
		int[] mem = new int[blocks];
		float tot = 0;

		System.out.println("Enter the memory required for each job: ");
		for (int i = 0; i < jobs; i++) {
			jb[i] = sc.nextInt();
		}

		System.out.println("Enter the memory spacce for each Memory Block: ");
		for (int i = 0; i < blocks; i++) {
			mem[i] = sc.nextInt();
			tot += mem[i];
		}

		int ch;
		do {
			System.out.println("1. First Fit");
			System.out.println("2. Best Fit");
			System.out.println("3. Worst Fit");
			System.out.println("4. Next Fit");
			System.out.println("5. Exit");

			System.out.println("Enter you choice: ");
			ch = sc.nextInt();

			switch (ch) {
				case 1:
					FirstFit(jb, mem, jobs, blocks, tot);
					break;
				case 2:
					BestFit(jb, mem, jobs, blocks, tot);
					break;
				case 3:
					WorstFit(jb, mem, jobs, blocks, tot);
					break;
				case 4: {
					int ind;
					System.out.println("Enter the block number that you want to start with : ");
					ind = sc.nextInt();
					NextFit(jb, mem, jobs, blocks, ind - 1, tot);
				}
					break;
			}
		} while (ch <= 4);
		sc.close();
	}
}

/*
Enter the no of memory Blocks
5
Enter the number of jobs:
4
Enter the memory required for each job:
90
50
30
20
Enter the memory spacce for each Memory Block:
20
100
40
200
10
1. First Fit
2. Best Fit
3. Worst Fit
4. Next Fit
5. Exit
Enter you choice:
1
Job 1 Allocated to Block 2
Job 2 Allocated to Block 4
Job 3 Allocated to Block 3
Job 4 Allocated to Block 1
Space Utilization is :- 0.972973
1. First Fit
2. Best Fit
3. Worst Fit
4. Next Fit
5. Exit
Enter you choice:
2
Job 1 Allocated to Block 2
Job 2 Allocated to Block 4
Job 3 Allocated to Block 3
Job 4 Allocated to Block 1
Space Utilization is :- 0.972973
1. First Fit
2. Best Fit
3. Worst Fit
4. Next Fit
5. Exit
Enter you choice:
3
Job 1 Allocated to Block 4
Job 2 Allocated to Block 2
Job 3 Allocated to Block 3
Job 4 Allocated to Block 1
Space Utilization is : 0.972973
1. First Fit
2. Best Fit
3. Worst Fit
4. Next Fit
5. Exit
Enter you choice:
4
Enter the block number that you want to start with :
2
Job 1 Allocated to Block 2
Job 2 Allocated to Block 4
Job 3 Allocated to Block 3
Job 4 Allocated to Block 1
Space Utilization is : 0.972973
1. First Fit
2. Best Fit
3. Worst Fit
4. Next Fit
5. Exit
Enter you choice:
5
* */