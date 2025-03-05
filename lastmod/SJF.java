package lastmod;

import java.util.*;

public class SJF {
    List<Process> processList;
    int totalBurstTime = 0;
    int totalCompletionTime = 0;
    int contextSwitchTime = 1;
    int totalExecutionTime = 0; // Track CPU execution time
    // Find the process with the minimum remaining time
shortest = -1;
int minm = Integer.MAX_VALUE;
check = false;

// Track the earliest arriving process in case of ties
int earliestArrival = Integer.MAX_VALUE;

for (int j = 0; j < n; j++) {
    Process pro = processes.get(j);
    if ((pro.arrivalTime <= t) && (finishStatus[j] == 0)) {
        if (pro.remainingTime < minm || (pro.remainingTime == minm && pro.arrivalTime < earliestArrival)) {
            minm = pro.remainingTime;
            shortest = j;
            earliestArrival = pro.arrivalTime;
            check = true;
        }
    }
}


    public void sjf(List<Process> processes, int n) {
        processList = processes;
        int[] finishStatus = new int[n]; // Track finished processes
        int complete = 0, t = 0;
        int shortest = -1;
        boolean check;
        
        for (Process p : processes) {
            totalBurstTime += p.burstTime; // Sum total burst time
        }

        System.out.println("\nScheduling Algorithm: Shortest remaining time first");
        System.out.println("Context Switch: 1ms\n");
        System.out.println("Time     Process/CS");

        int startTime = 0;
        String prevProcess = "";

        while (complete != n) {
            // Find process with minimum remaining time
            shortest = -1;
            int minm = Integer.MAX_VALUE;
            check = false;

            for (int j = 0; j < n; j++) {
                Process pro = processes.get(j);
                if ((pro.arrivalTime <= t) && (finishStatus[j] == 0) && (pro.remainingTime < minm)) {
                    minm = pro.remainingTime;
                    shortest = j;
                    check = true;
                }
            }

            if (!check) { // CPU is idle
                if (!prevProcess.equals("Idle")) {
                    if (!prevProcess.isEmpty()) {
                    	System.out.printf("%-10s %-5s%n", (startTime + "-" + t), prevProcess);
                    }
                    startTime = t;
                }
                prevProcess = "Idle";
                t++;
                continue;
            }

            String currentProcessID = "P" + (shortest + 1);

            // Handle context switch
            if (!prevProcess.equals(currentProcessID)) {
                if (!prevProcess.isEmpty() && !prevProcess.equals("Idle")) {
                	System.out.printf("%-10s %-5s%n", (startTime + "-" + t), prevProcess);
                }
                startTime = t;
                if (!prevProcess.equals("") && !prevProcess.equals("Idle")) {
                	System.out.printf("%-10s %-5s%n", (t + "-" + (t + contextSwitchTime)), "CS");
                    t += contextSwitchTime; // Context switch takes 1ms
                    startTime = t;
                }
                prevProcess = currentProcessID;
            }

            // Execute process for one time unit
            processes.get(shortest).remainingTime--;
            t++;
            totalExecutionTime++;

            // If process completes
            if (processes.get(shortest).remainingTime == 0) {
                complete++;
                processes.get(shortest).completionTime = t;
                processes.get(shortest).turnaroundTime = t - processes.get(shortest).arrivalTime;
                processes.get(shortest).waitingTime = processes.get(shortest).turnaroundTime - processes.get(shortest).burstTime;
                if (processes.get(shortest).waitingTime < 0)
                    processes.get(shortest).waitingTime = 0;
                finishStatus[shortest] = 1;
            }
        }

        // Print last execution interval
        if (!prevProcess.isEmpty()) {
        	System.out.printf("%-10s %-5s%n", (startTime + "-" + t), prevProcess);
        }

        totalCompletionTime = t; // Total time when last process finished
    }

    public void printing(List<Process> processes) {
        float avgWT = 0, avgTAT = 0;

        for (Process p:processes) {
            avgWT += p.waitingTime;
            avgTAT += p.turnaroundTime;
        }

        System.out.printf("\nAverage Turnaround Time: %.2f\n", avgTAT / processes.size());
        System.out.printf("Average Waiting Time: %.2f\n", avgWT / processes.size());
        
        float cpuUtilization = ((float) totalBurstTime / totalCompletionTime) * 100;
        System.out.printf("CPU Utilization: %.2f%%\n", cpuUtilization);
    }
}

