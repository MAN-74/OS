import java.util.Scanner;

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
     
}