package OSProject;

public class Event {
    public String EventType ;
    
    String type;//arrival start termination complatoin
    int time;      // The time at which the event occurs
    Process process;
    int PID;

    public Event(String type, int time, Process process) {
        this.type = type;
        this.time = time;
        this.process = process;
        this.PID=PID;
    }
}


