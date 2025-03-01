import java.util.Scanner;import java.util.Scanner;
public class SJF {

        static int complete = 0, t = 0;
        static int shortest = 0, currentProcess = -1;
        static int minm;
        static boolean check = false;
        static float avgwt = 0, avgta = 0;

        public static void sjf(Process[] p,int n){
            int[] finishStatus = new int[n];      // Finish Status

        
        System.out.println("\nGantt Chart:");
        System.out.println("Time | Process");

        while (complete != n) {
            // Find process with minimum remaining time
            shortest = -1;
            minm = Integer.MAX_VALUE;
            check = false;
            
            for (int j = 0; j < n; j++) {
                if ((p[j].arrivalTime <= t) && (finishStatus[j] == 0) && (p[j].remainingTime < minm)) {
                    minm = p[j].remainingTime;
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
                    p[shortest].switchCount++; // Count switch for the new process
                    t++; // Context switch takes 1 second
                }
                currentProcess = shortest;
                System.out.println(t + " | P" + (shortest + 1));
            } else {
                System.out.println(t + " | P" + (shortest + 1));
            }

            // Execute process for one time unit
            p[shortest].remainingTime--;
            t++;

            // If process completes
            if (p[shortest].remainingTime == 0) {
                complete++;
                p[shortest].completionTime = t;
                p[shortest].turnaroundTime = p[shortest].completionTime - p[shortest].arrivalTime;
                p[shortest].waitingTime = p[shortest].turnaroundTime - p[shortest].burstTime - p[shortest].switchCount;
                if (p[shortest].waitingTime < 0) p[shortest].waitingTime = 0;
                finishStatus[shortest] = 1;
                currentProcess = shortest; // Process finished 
            }
            
        }

    }
 
        public static void printing(Process[] p){ 
        // Print results
        System.out.println("\nProcess Details:");
        System.out.println("PID  Arrival  Burst  Complete  Turnaround  Waiting");
        for (int i = 0; i <p.length ; i++) {
            avgwt += p[i].waitingTime;
            avgta += p[i].turnaroundTime;
            System.out.printf("%2d %8d %7d %9d %11d %9d\n", 
            p[i].id, p[i].arrivalTime, p[i].burstTime, p[i].completionTime, p[i].turnaroundTime, p[i].waitingTime);
        }

        System.out.printf("\nAverage Turnaround Time = %.2f\n", (float)(avgta/p.length));
        System.out.printf("Average Waiting Time = %.2f\n", (float)(avgwt/p.length));
        
        
    }
    
}

