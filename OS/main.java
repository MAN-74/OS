package OS;

import java.util.*;

class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of processes:");
        int n = sc.nextInt();
        List<Process> processes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i + 1) + " arrival time:");
            int arrival = sc.nextInt();
            System.out.println("Enter process " + (i + 1) + " burst time:");
            int burst = sc.nextInt();
            processes.add(new Process(i + 1, arrival, burst)); // ID is i+1
        }
     
        System.out.println("\nNumber of processes = " + n);
        System.out.println("Arrival times and burst times as follows:\n");
        for (Process p : processes) {
            System.out.println("P" + p.id + ": Arrival time = " + p.arrivalTime + ", Burst time = " + p.burstTime + " ms");
        }

        SJF ss = new SJF();
        ss.sjf(processes, n);
        ss.printing(processes);
        
        sc.close(); 
    }
}
