class Event implements Comparable<Event> {
    int time;
    String type;
    Process process;
    
    public Event(int time, String type, Process process) {
        this.time = time;
        this.type = type;
        this.process = process;
    }
    
    @Override
    public int compareTo(Event e) {
        return this.time - e.time;
    }
}


















/*import java.util.*;

class Event implements Comparable<Event> {
    int time;
    String type;
    Process process;
    
    public Event(int time, String type, Process process) {
        this.time = time;
        this.type = type;
        this.process = process;
    }
    
    @Override
    public int compareTo(Event e) {
        return this.time - e.time;
    }
}
*/