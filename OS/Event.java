package OS;

public class Event {
    private String type; 
    private int time;    
    private Process process;
    private int PID;

    public Event(int time, String type, Process process) {
        this.time = time;
        this.type = type;
        this.process = process;
    }

    public Event(String type, int time, Process process) {
        this.type = type;
        this.time = time;
        this.process = process;
        this.PID = process.id; 
    }

    public String getType() {
        return type;
    }

    public int getTime() {
        return time;
    }

    public Process getProcess() {
        return process;
    }

    public int getPID() {
        return PID;
    }

    @Override
    public String toString() {
        return "Event Type: " + type +
               "\nTime: " + time +
               "\nProcess ID: " + PID;
    }
}


