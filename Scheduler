import java.util.*;
class Scheduler {
    PriorityQueue<Event> eventQueue = new PriorityQueue<>();
    PriorityQueue<Process> readyQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.remainingTime));
    List<Process> processList;
    List<GanttChartEntry> ganttChart = new ArrayList<>();
    int currentTime = 0, totalExecutionTime = 0;
    Process runningProcess = null;

    public Scheduler(List<Process> processList) {
        this.processList = processList;
        for (Process p : processList) {
            eventQueue.add(new Event(p.arrivalTime, "ARRIVAL", p));
        }
    }

    public void runSimulation() {
        while (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            currentTime = event.time;
            handleEvent(event);
        }
    }

    private void handleEvent(Event event) {
        switch (event.type) {
            case "ARRIVAL":
                readyQueue.add(event.process);
                scheduleNextProcess();
                break;
            case "COMPLETION":
                completeProcess(event.process);
                scheduleNextProcess();
                break;
        }
    }

    private void scheduleNextProcess() {
        if (runningProcess != null && runningProcess.remainingTime > 0) {
            readyQueue.add(runningProcess);
        }
        if (!readyQueue.isEmpty()) {
            runningProcess = readyQueue.poll();
            int executionTime = runningProcess.remainingTime;
            int completionTime = currentTime + executionTime;
            eventQueue.add(new Event(completionTime, "COMPLETION", runningProcess));
            ganttChart.add(new GanttChartEntry(runningProcess.id, currentTime, completionTime));
            runningProcess.remainingTime = 0;
            totalExecutionTime += executionTime;
        }
    }

    private void completeProcess(Process process) {
        process.completionTime = currentTime;
        process.turnaroundTime = process.completionTime - process.arrivalTime;
        process.waitingTime = process.turnaroundTime - process.burstTime;
    }

    public void printResults() {
        System.out.println("\nGantt Chart:");
        for (GanttChartEntry entry : ganttChart) {
            System.out.printf("| P%d (%d-%d) ", entry.processId, entry.startTime, entry.endTime);
        }
        System.out.println("|");
        
        System.out.println("\nPID  Arrival  Burst  Complete  Turnaround  Waiting");
        float totalWT = 0, totalTAT = 0;
        for (Process p : processList) {
            System.out.printf("%2d %8d %7d %9d %11d %9d\n", 
                p.id, p.arrivalTime, p.burstTime, p.completionTime, p.turnaroundTime, p.waitingTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }
        System.out.printf("\nAverage Turnaround Time = %.2f\n", totalTAT / processList.size());
        System.out.printf("Average Waiting Time = %.2f\n", totalWT / processList.size());
        
        float cpuUtilization = ((float) totalExecutionTime / currentTime) * 100;
        System.out.printf("CPU Utilization = %.2f%%\n", cpuUtilization);
    }
}




/*import java.util.*;

class Scheduler {
    PriorityQueue<Event> eventQueue = new PriorityQueue<>();
    PriorityQueue<Process> readyQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.remainingTime));
    List<Process> processList;
    int currentTime = 0;
    Process runningProcess = null;

    public Scheduler(List<Process> processList) {
        this.processList = processList;
        for (Process p : processList) {
            eventQueue.add(new Event(p.arrivalTime, "ARRIVAL", p));
        }
    }

    public void runSimulation() {
        while (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            currentTime = event.time;
            handleEvent(event);
        }
    }

    private void handleEvent(Event event) {
        switch (event.type) {
            case "ARRIVAL":
                readyQueue.add(event.process);
                scheduleNextProcess();
                break;
            case "COMPLETION":
                completeProcess(event.process);
                scheduleNextProcess();
                break;
        }
    }

    private void scheduleNextProcess() {
        if (runningProcess != null && runningProcess.remainingTime > 0) {
            readyQueue.add(runningProcess);
        }
        if (!readyQueue.isEmpty()) {
            runningProcess = readyQueue.poll();
            int completionTime = currentTime + runningProcess.remainingTime;
            eventQueue.add(new Event(completionTime, "COMPLETION", runningProcess));
            runningProcess.remainingTime = 0;
        }
    }

    private void completeProcess(Process process) {
        process.completionTime = currentTime;
        process.turnaroundTime = process.completionTime - process.arrivalTime;
        process.waitingTime = process.turnaroundTime - process.burstTime;
    }

    public void printResults() {
        System.out.println("PID  Arrival  Burst  Complete  Turnaround  Waiting");
        float totalWT = 0, totalTAT = 0;
        for (Process p : processList) {
            System.out.printf("%2d %8d %7d %9d %11d %9d\n", 
                p.id, p.arrivalTime, p.burstTime, p.completionTime, p.turnaroundTime, p.waitingTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }
        System.out.printf("\nAverage Turnaround Time = %.2f\n", totalTAT / processList.size());
        System.out.printf("Average Waiting Time = %.2f\n", totalWT / processList.size());
    }
}*/
