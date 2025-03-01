/*class Process {
    int id;             
    int arrivalTime;    
    int burstTime;      
    int remainingTime;  
    int completionTime; 
    int waitingTime;    
    int turnaroundTime; 
    boolean completed;
    int switchCount;

    public Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime; 
        this.completionTime = 0;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.switchCount = 0;
    }

 // if necessary
    @Override 
    public String toString() {
        return "Process ID: " + id + 
        	   "\nArrival Time: " + arrivalTime + 
               "\nBurst Time: " + burstTime + 
               "\nCompletion Time: " + completionTime + 
               "\nTurnaround Time: " + turnaroundTime + 
               "\nWaiting Time: " + waitingTime;
    }
}*/
import java.util.*;

class Process {
    int id;
    int arrivalTime;
    int burstTime;
    int remainingTime;
    int completionTime;
    int waitingTime;
    int turnaroundTime;
    
    public Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

