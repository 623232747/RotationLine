public class Event implements Comparable<Event> {

    Point p;

    public float getAngle() {
        return p.angle;
    }

    Segment segment;
    EventType type;
    Event(Segment segment, EventType type, Point p){
        this.segment = segment;
        this.type = type;
        this.p = p;
    }

    @Override
    public int compareTo(Event e) {
        if (this.getAngle()-e.getAngle()!=0f) return p.compareTo(e.p);
        else if(this.type.ordinal()-e.type.ordinal()!=0)return this.type.ordinal()-e.type.ordinal();
        return p.compareTo(e.p);
    }
}
