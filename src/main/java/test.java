import java.util.HashSet;

public class test {
    public static void main(String[] args) {
        Point.px = 0;
        Point.py = 0;

//        Segment a = new Segment("1",new Point(1f, 0f), new Point(0f, 1f));
//        Segment b = new Segment("2",new Point(0f, 2f), new Point(-2f, 0f));
//        Segment c = new Segment("3",new Point(-1f, 0f), new Point(0f, -1f));
//        Segment d = new Segment("4",new Point(0f, -2f), new Point(2f, 0f));
//        Segment e = new Segment("5",new Point(3f, -1f), new Point(3f, 1f));

        Segment a = new Segment("1", new Point(1f, 1f), new Point(0f, 2f));
        Segment b = new Segment("2", new Point(2f, 2f), new Point(4f, 0f));
        Segment c = new Segment("3", new Point(6f, 0f), new Point(0f, 6f));


        EventController eventController = EventController.getEventController();
        eventController.addSegment(a);
        eventController.addSegment(b);
        eventController.addSegment(c);
//        eventController.addSegment(d);
//        eventController.addSegment(e);
        eventController.find();
        System.out.println("能看到的线段是");
        HashSet<Segment> set = new HashSet<>();
        for (Segment s : eventController.segments) {
            // 会重复输出
            if (s.isVisiable) set.add(s);
        }
        for(Segment s:set){
            System.out.println(s.name);
        }
    }
}
