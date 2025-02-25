/*class SJF{
    

    public static void sjf( Process p[],int Time){//must run evry second to check
        int min=0;

        for(int i=0;i<p.length;i++){
            if(p[i].arrivalTime<=Time){ 
                if(p[i+1]!=null){}
                if(p[i+1].arrivalTime<=Time){
                    if(p[i].burstTime<p[i+1].burstTime){
                        min=p[i].id;
                    }else{
                        min=p[i+1].id;
                    }
                }else{
                    min=p[i].id; // it might cause an error
                }
                
            }

        }
        System.out.println("the workin now is p"+min);
        Time++;

    }

}*/
import java.util.Scanner;

/**
 * Created by hadiana_sliwa on 12/1/18.
 */
/* 
public class SJF {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println ("enter no of process:");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int ta[] = new int[n];
        int wt[] = new int[n];
        int f[] = new int[n];

        int st=0, tot=0;
        float avgwt=0, avgta=0;

        for(int i=0;i<n;i++)
        {
            System.out.println ("enter process " + (i+1) + " arrival time:");
            at[i] = sc.nextInt();
            System.out.println ("enter process " + (i+1) + " brust time:");
            bt[i] = sc.nextInt();
            pid[i] = i+1;
            f[i] = 0;
        }


        while(true)
        {
            int c=n, min = 999999;

            if (tot == n)
                break;

            for (int i=0; i<n; i++)
            {

                if ((at[i] <= st) && (f[i] == 0) && (bt[i]<min))
                {
                    min=bt[i];
                    c=i;
                }
            }
            if (c==n)
                st++;
            else
            {
                ct[c]=st+bt[c];
                st+=bt[c];
                ta[c]=ct[c]-at[c];
                wt[c]=ta[c]-bt[c];
                f[c]=1;
                pid[tot] = c + 1;
                tot++;
            }
        }

        System.out.println("\npid arrival brust complete turn waiting");
        for(int i=0;i<n;i++)
        {
            avgwt+= wt[i];
            avgta+= ta[i];
            System.out.println(pid[i]+"\t\t"+at[i]+"\t\t"+bt[i]+"\t\t"+ct[i]+"\t\t"+ta[i]+"\t\t"+wt[i]);
        }
        System.out.println ("\naverage tat is "+ (float)(avgta/n));
        System.out.println ("average wt is "+ (float)(avgwt/n));
        sc.close();
        for(int i=0;i<n;i++)
        {
            System.out.print(pid[i] + " ");
        }
    }
}*/

/* 
import java.util.Scanner;

public class PreemptiveSJF {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of process:");
        int n = sc.nextInt();
        
        int[] pid = new int[n];    // Process IDs
        int[] at = new int[n];     // Arrival Times
        int[] bt = new int[n];     // Burst Times
        int[] ct = new int[n];     // Completion Times
        int[] ta = new int[n];     // Turnaround Times
        int[] wt = new int[n];     // Waiting Times
        int[] f = new int[n];      // Finish Status
        int[] rt = new int[n];     // Remaining Times
        
        // Input process data
        for(int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i+1) + " arrival time:");
            at[i] = sc.nextInt();
            System.out.println("Enter process " + (i+1) + " burst time:");
            bt[i] = sc.nextInt();
            pid[i] = i+1;
            rt[i] = bt[i];
        }

        int complete = 0, t = 0, minm = Integer.MAX_VALUE;
        int shortest = 0, finish_time;
        boolean check = false;
        float avgwt = 0, avgta = 0;

        // Process until all processes are completed
        while (complete != n) {
            // Find process with minimum remaining time among the
            // processes that arrived till the current time
            for (int j = 0; j < n; j++) {
                if ((at[j] <= t) && (f[j] == 0) && (rt[j] < minm)) {
                    minm = rt[j];
                    shortest = j;
                    check = true;
                }
            }

            if (check == false) {
                t++;
                continue;
            }

            // Reduce remaining time by one
            rt[shortest]--;
            minm = rt[shortest];
            if (minm == 0)
                minm = Integer.MAX_VALUE;

            // If a process gets completely executed
            if (rt[shortest] == 0) {
                complete++;
                check = false;
                finish_time = t + 1;

                // Calculate waiting and turnaround times
                ct[shortest] = finish_time;
                ta[shortest] = ct[shortest] - at[shortest];
                wt[shortest] = ta[shortest] - bt[shortest];

                if (wt[shortest] < 0)
                    wt[shortest] = 0;
                
                f[shortest] = 1;
            }
            t++;
        }

        // Print results
        System.out.println("\npid  arrival  burst  complete turn  waiting");
        for (int i = 0; i < n; i++) {
            avgwt += wt[i];
            avgta += ta[i];
            System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + ta[i] + "\t" + wt[i]);
        }

        System.out.println("\nAverage Turnaround Time = " + (float)(avgta/n));
        System.out.println("Average Waiting Time = " + (float)(avgwt/n));
        
        sc.close();
    }
}*/import java.util.Scanner;

public class PreemptiveSJF {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of process:");
        int n = sc.nextInt();
        
        int[] processID = new int[n];    // Process IDs
        int[] arrivalTime = new int[n];     // Arrival Times
        int[] burstTims = new int[n];     // Burst Times
        int[] completionTime = new int[n];     // Completion Times
        int[] turnaroundTime = new int[n];     // Turnaround Times
        int[] waitingTime = new int[n];     // Waiting Times
        int[] finishStatus = new int[n];      // Finish Status
        int[] remainingTime = new int[n];     // Remaining Times
        int[] switchCount = new int[n]; // Count of context switches per process
        
        // Input process data
        for(int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i+1) + " arrival time:");
            arrivalTime[i] = sc.nextInt();
            System.out.println("Enter process " + (i+1) + " burst time:");
            burstTims[i] = sc.nextInt();
            processID[i] = i+1;
            remainingTime[i] = burstTims[i];
            switchCount[i] = 0;
        }

        int complete = 0, t = 0;
        int shortest = 0, currentProcess = -1;
        int minm;
        boolean check = false;
        float avgwt = 0, avgta = 0;
        
        System.out.println("\nGantt Chart:");
        System.out.println("Time | Process");

        while (complete != n) {
            // Find process with minimum remaining time
            shortest = -1;
            minm = Integer.MAX_VALUE;
            check = false;
            
            for (int j = 0; j < n; j++) {
                if ((arrivalTime[j] <= t) && (finishStatus[j] == 0) && (remainingTime[j] < minm)) {
                    minm = remainingTime[j];
                    shortest = j;
                    check = true;
                }
            }

            if (!check) {
                System.out.println(t + " | Idle");
                t++;
                currentProcess = -1;
                continue;
            }

            // If switching to a different process
            if (currentProcess != shortest) {
                if (currentProcess != -1) { // If not the first process
                    System.out.println(t + " | Context Switch");
                    switchCount[shortest]++; // Count switch for the new process
                    t++; // Context switch takes 1 second
                }
                currentProcess = shortest;
                System.out.println(t + " | P" + (shortest + 1));
            } else {
                System.out.println(t + " | P" + (shortest + 1));
            }

            // Execute process for one time unit
            remainingTime[shortest]--;
            t++;

            // If process completes
            if (remainingTime[shortest] == 0) {
                complete++;
                completionTime[shortest] = t;
                turnaroundTime[shortest] = completionTime[shortest] - arrivalTime[shortest];
                waitingTime[shortest] = turnaroundTime[shortest] - burstTims[shortest] - switchCount[shortest];
                if (waitingTime[shortest] < 0) waitingTime[shortest] = 0;
                finishStatus[shortest] = 1;
                currentProcess = shortest; // Process finished 
            }
        }

        // Print results
        System.out.println("\nProcess Details:");
        System.out.println("PID  Arrival  Burst  Complete  Turnaround  Waiting");
        for (int i = 0; i < n; i++) {
            avgwt += waitingTime[i];
            avgta += turnaroundTime[i];
            System.out.printf("%2d %8d %7d %9d %11d %9d\n", 
            processID[i], arrivalTime[i], burstTims[i], completionTime[i], turnaroundTime[i], waitingTime[i]);
        }

        System.out.printf("\nAverage Turnaround Time = %.2f\n", (float)(avgta/n));
        System.out.printf("Average Waiting Time = %.2f\n", (float)(avgwt/n));
        
        sc.close();
    }
}