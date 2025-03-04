package OSProject;

import java.util.*;

class main{
    public static int Time=0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of process:");
        int n = sc.nextInt();
        List<Process> processes = new ArrayList<>();
                
        // Input process data
        for(int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i+1) + " arrival time:");
            int arrival = sc.nextInt();
            System.out.println("Enter process " + (i+1) + " burst time:");
            int burst = sc.nextInt();
            int id = i+1;
            processes.add(new Process(i + 1, arrival, burst));
        } 
        SJF ss=new SJF();
        ss.sjf(processes,n);
        ss.printing(processes);
    }
}
