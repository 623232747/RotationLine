import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;


public class EventController {

    public static EventController getEventController() {
        return eventController;
    }

    static EventController eventController = new EventController();

    ArrayList<Segment> segments = new ArrayList<>();

    float scanLineAlpha = 0;

    BSTree<Segment> scanLineStatus = new BSTree<>();

    PriorityQueue<Event> events = new PriorityQueue<>(); // 应该是一个优先队列

    void addSegment(Segment segment){
        if (segment.start.angle>segment.end.angle){
//            System.out.println("split: " +segment);
            Point intercept1 = segment.getXIntercept();
            Point intercept2 = segment.getXIntercept();
            intercept2.angle-=Math.PI*2;
            segments.add(new Segment(segment.name,segment.start,intercept1));
            segments.add(new Segment(segment.name,intercept2,segment.end));;
        }
        else segments.add(segment);
    }


    void find() {
        for (Segment s : segments) {
            Event se = new Event(s, EventType.Start, s.start);
            Event ee = new Event(s, EventType.End, s.end);
            events.add(se);
            events.add(ee);
        }
        while (!events.isEmpty()) {
            Event e = events.poll();
//            System.out.println(e.type);
//            System.out.println(e.segment.name);
//            System.out.println(e.getAngle());
            scanLineAlpha = e.getAngle();
            Event next =events.peek();
            switch (e.type) {
                case Start:
                    scanLineStatus.insert(e.segment);

                    Segment min = scanLineStatus.minimum();
                    min.isVisiable=true;
                    System.out.println(min);
                    break;
                case End:
                    scanLineStatus.remove(e.segment);
                    min = scanLineStatus.minimum();
                    if (min!=null){
                        min.isVisiable=true;
                        System.out.println(min);
                    }
                    break;
                default:
                    break;
            }
        }

    }


}
