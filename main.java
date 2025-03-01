 import java.util.Scanner;

import java.util.*;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Process> processes = new ArrayList<>();
        
        processes.add(new Process(1, 0, 8));
        processes.add(new Process(2, 1, 4));
        processes.add(new Process(3, 2, 5));
        processes.add(new Process(4, 3, 5));
        
        Scheduler scheduler = new Scheduler(processes);
        scheduler.runSimulation();
        scheduler.printResults();
    }
}

/* 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes:");
        int n = sc.nextInt();
        List<Process> processList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Arrival Time for P" + (i + 1) + ":");
            int arrivalTime = sc.nextInt();
            System.out.println("Enter Burst Time for P" + (i + 1) + ":");
            int burstTime = sc.nextInt();
            processList.add(new Process(i + 1, arrivalTime, burstTime));
        }
        
        Scheduler scheduler = new Scheduler(processList);
        scheduler.runSimulation();
        scheduler.printResults();
        
        sc.close();
    }
}*/

/*import java.util.Scanner;

class main{
    public static int Time=0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of process:");
        int n = sc.nextInt();
        Process[] p=new Process[n];
                
        // Input process data
        for(int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i+1) + " arrival time:");
            int arriv = sc.nextInt();
            System.out.println("Enter process " + (i+1) + " burst time:");
            int burst = sc.nextInt();
            int id = i+1;
            p[i]=new Process(id, arriv, burst);
        } //moveed to main class
        SJF ss=new SJF();
        SJF.sjf(p,n);
        SJF.printing(p);
    }
    */
