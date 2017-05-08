
enum EventType {
    LLEGADA,
    SALIDA
}

public class Event {
    EventType type;

    private EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    Double time;

    public Event(EventType type, Double time) {
        this.type = type;
        this.time = time;
    }

    public boolean sosDeSalida(){
        return this.getType().equals(EventType.SALIDA);
    }

    public boolean sosDeLlegada(){
        return this.getType().equals(EventType.LLEGADA);
    }
}

