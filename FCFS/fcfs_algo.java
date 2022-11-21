package FCFS;

import java.util.*;

public class fcfs_algo {

		public static void swap(int x,int y)
		{
			int temp=x;
			x=y;
			y=temp;
			return;
		}

	public static void main(String[] args) {
		
        // Here We Taking input the no of processes  
		float AvgTAT=0;
		float AvgWT=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of Procsses: ");
		int n=sc.nextInt();
		
		int pid[] =new int[n];
		int AT[]=new  int[n];
		int BT[]=new int[n];
		int FT[]=new int[n];
		int TAT[]=new int[n];
		int wt[]=new int[n];
		
		// Here we taking input of Arrival time and Burst time
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the Arrival time for process "+(i+1)+":");
			AT[i]=sc.nextInt();
			System.out.println("Enter the Burst time for process "+(i+1)+":");
			BT[i]=sc.nextInt();
			pid[i]=i+1;
		}
		
		
		//sorting according to finish time 
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(AT[i] > AT[j])
				{
					swap(AT[i],AT[j]);
					swap(BT[i],BT[j]);
					swap(pid[i],pid[j]);
				}
			}
		}
		
		
	
		// Here we finding the finish time
		for(int i=0;i<n;i++)
		{
			if(i==0)
			{
				FT[i]=AT[i]+BT[i];
			}else
			{
				if(AT[i] > FT[i-1])
				{
					FT[i]=AT[i]+BT[i];
				}else
				{
					FT[i]=FT[i-1]+BT[i];
				}
			}
			TAT[i]=FT[i]-AT[i];
			wt[i]=TAT[i]-BT[i];
			AvgTAT+=(float)TAT[i];
			AvgWT+=(float)wt[i];
		}
		
		
		
		System.out.println("Processes\tArrivalTime\tBurstTime\tFinishTime\tTurnTime\tWaitingTime");
		for(int i=0;i<n;i++)
		{
			System.out.println("  "+pid[i]+"  \t\t "+AT[i]+"  \t\t "+BT[i]+"  \t\t "+FT[i]+"  \t\t "+TAT[i]+"  \t\t "+wt[i]);
		}
		
		
		System.out.println("Average Turn around time is: "+(float)(AvgTAT/n));
		System.out.println("Average  Waiting Time is: "+(float)(AvgWT/n));
		System.out.println("Average  ResponseTime is: "+(float)(AvgWT/n));
		
		
	}

}
