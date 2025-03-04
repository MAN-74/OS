package OSProject;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import java.util.Scanner;
public class SJF {

    Queue<Event> eventQueue = new LinkedList<>();
    List<Process> processList;
        static int complete = 0, t = 0;
        static int shortest = 0, currentProcess = -1;
        static int minm;
        static boolean check = false;
        static float avgwt = 0, avgta = 0;
        int totalExecutionTime=0;

        public void SJF(List<Process> processes){
            processList=processes;
            for (Process p : processes) {
                eventQueue.add(new Event( "ARRIVAL", p.arrivalTime, p));
            }
        }
        public  void sjf(List<Process> processes,int n){
            int[] finishStatus = new int[n];      // Finish Status

        
        System.out.println("\nGantt Chart:");// ابي احذفها
        System.out.println("Time | Process");

        while (complete != n) {
            // Find process with minimum remaining time
            shortest = -1;
            minm = Integer.MAX_VALUE;
            check = false;
            for (int j = 0; j < n; j++) {
                Process pro=processes.get(j);
                if ((pro.arrivalTime <= t) && (finishStatus[j] == 0) && (pro.remainingTime < minm)) {
                    minm = pro.remainingTime;
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
            for(Event event: eventQueue){
                if(processes.get(shortest).id==event.PID)//هذي البروسيس اول مره تدخل
                eventQueue.add(new Event( "ARRIVAL", t, processes.get(shortest)));//الوقت اللي دخلت فيه
            }

            // If switching to a different process
            if (currentProcess != shortest) {
                if (currentProcess != -1) { // If its not the first process
                    eventQueue.add(new Event( "TERMINATION", t, processes.get(currentProcess)));
                    System.out.println(t + " | Context Switch");
                    processes.get(shortest).switchCount++; // Count switch for the new process
                    t++; // Context switch takes 1 second
                }
                currentProcess = shortest;
                System.out.println(t + " | P" + (shortest + 1));
            } else {
                System.out.println(t + " | P" + (shortest + 1));
            }

            // Execute process for one time unit
            processes.get(shortest).remainingTime--;
            t++;

            // If process completes
            if (processes.get(shortest).remainingTime == 0) {
                complete++;
                processes.get(shortest).completionTime = t;
                eventQueue.add(new Event("COMPLETION", processes.get(shortest).completionTime, processes.get(shortest)));
                processes.get(shortest).turnaroundTime = processes.get(shortest).completionTime - processes.get(shortest).arrivalTime;
                processes.get(shortest).waitingTime = processes.get(shortest).turnaroundTime - processes.get(shortest).burstTime - processes.get(shortest).switchCount;
                if (processes.get(shortest).waitingTime < 0)
                 processes.get(shortest).waitingTime = 0;

                finishStatus[shortest] = 1;
                currentProcess = shortest; // Process finished 
            }
            
        }

    }
 
        public  void printing(List<Process> processes){ 
        // Print results
        System.out.println("\nProcess Details:");
        System.out.println("PID  Arrival  Burst  Complete  Turnaround  Waiting");
        for (Process p:processes) {
            avgwt += p.waitingTime;
            avgta += p.turnaroundTime;
            System.out.printf("%2d %8d %7d %9d %11d %9d\n", 
            p.id, p.arrivalTime, p.burstTime, p.completionTime, p.turnaroundTime, p.waitingTime);
        }

        System.out.printf("\nAverage Turnaround Time = %.2f\n", (float)(avgta/processes.size()));
        System.out.printf("Average Waiting Time = %.2f\n", (float)(avgwt/processes.size()));
        float cpuUtilization = ((float) totalExecutionTime / t) ;//wrong calculation
        System.out.printf("CPU Utilization = %.2f%%\n", cpuUtilization);

        
    }
    
}


