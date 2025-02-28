/* import java.util.Scanner;

class main{
    public static int Time=0;

    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);
        System.out.println("enter the number of Process");
        int num=kb.nextInt();

        Process[] p=new Process[num];

        for(int i=0;i<num;i++){
            System.out.println("enter the Arrival Time for p"+i);
            int arrivalTime=kb.nextInt();
            System.out.println("enter the Burst time for p"+i);
            int burstTime=kb.nextInt();
            p[i]=new Process(i,arrivalTime,burstTime);
        }
        int totaltime=0;
        for(int i=0;i<p.length;i++){
            totaltime+=p[i].burstTime;
        }
        for(int i ;Time<totaltime;Time++){
           SJF.sjf(p,Time);
        }
    }
}*/

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
}
