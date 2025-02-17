package os_Process;

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
        this.completionTime = 0;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }

 // if necessary
    @Override 
    public String toString() {
        return "Process ID: " + id + "/n Arrival Time: " + arrivalTime + 
               "/n Burst Time: " + burstTime + "/n Completion Time: " + completionTime + 
               "/n Turnaround Time: " + turnaroundTime + "/n Waiting Time: " + waitingTime;
    }
}

