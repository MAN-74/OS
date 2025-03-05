package lastmod;

class Process {
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
        this.completed = false;
    }

    @Override 
    public String toString() {
    	 return "-------------------------\n" +
    	           "Process ID: " + id + 
    	           "\nArrival Time: " + arrivalTime + 
    	           "\nBurst Time: " + burstTime + 
    	           "\nCompletion Time: " + completionTime + 
    	           "\nTurnaround Time: " + turnaroundTime + 
    	           "\nWaiting Time: " + waitingTime + 
    	           "\n-------------------------";
    }
}
