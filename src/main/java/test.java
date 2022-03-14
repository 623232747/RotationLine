public class test {
    public static void main(String[] args) {
        Point.polar = new Point(2,2);
//        Segment a = new Segment("red",new Point(2f, 2f), new Point(1f, 4f));
//        Segment b = new Segment("purple",new Point(3f, 1f), new Point(5f, 5f));
//        Segment c = new Segment("yellow",new Point(4f, 3f), new Point(6f, 4f));
//        Segment d = new Segment("green",new Point(10f, 1f), new Point(1f, 4f));
//        Segment e = new Segment("blue",new Point(10f, 1f), new Point(7f, 6f));

//        Segment a = new Segment("1",new Point(2f,1f),new Point(0f,3f));
//        Segment b = new Segment("2",new Point(4f,1f),new Point(2f,3f));
//        Segment c = new Segment("3",new Point(6f,1f),new Point(4f,3f));
//        Segment d = new Segment("4",new Point(1f,1f),new Point(3f,1.5f));

//        Segment a = new Segment("1",new Point(1f,1f),new Point(2f,4f));
//        Segment b = new Segment("2",new Point(2f,1f),new Point(1f,4f));
//        Segment c = new Segment("3",new Point(2f,1f),new Point(3f,4f));
//        Segment d = new Segment("4",new Point(3f,1f),new Point(2f,4f));
//        Segment e = new Segment("5",new Point(3f,1f),new Point(3f,4f));

//        Segment a = new Segment("1",new Point(1f,1f),new Point(2f,4f));
//        Segment b = new Segment("2",new Point(2f,1f),new Point(2f,4f));
//        Segment c = new Segment("3",new Point(2f,4f),new Point(3f,6f));
//        Segment d = new Segment("4",new Point(2f,4f),new Point(4f,6f));
//
//        Segment a = new Segment("1",new Point(1f, 1f), new Point(4f, 4f));
//        Segment b = new Segment("2",new Point(3f, 2f), new Point(3f, 4f));
//        Segment c = new Segment("3",new Point(3f, 3f), new Point(2f, 4f));
//        Segment d = new Segment("4",new Point(1f, 2f), new Point(5f, 4f));

//        Segment a = new Segment("1",new Point(1f, 0f), new Point(0f, 1f));
//        Segment b = new Segment("2",new Point(0f, 2f), new Point(-2f, 0f));
//        Segment c = new Segment("3",new Point(-1f, 0f), new Point(0f, -1f));
//        Segment d = new Segment("4",new Point(0f, -2f), new Point(2f, 0f));
//        Segment e = new Segment("5",new Point(-3f, -1f), new Point(-3f, 1f));

        Segment a = new Segment("1",new Point(1f, 0.1f), new Point(0.1f, 1f));
        Segment b = new Segment("2",new Point(0.1f, 2f), new Point(-2f, 0.1f));
        Segment c = new Segment("3",new Point(-1f, 0.1f), new Point(0.1f, -1f));
        Segment d = new Segment("4",new Point(0.1f, -2f), new Point(2f, 0.1f));
        Segment e = new Segment("5",new Point(3f, -1f), new Point(3f, 1f));

        EventController eventController = EventController.getEventController();
        eventController.addSegment(a);
        eventController.addSegment(b);
        eventController.addSegment(c);
        eventController.addSegment(d);
        eventController.addSegment(e);
        eventController.find();
        System.out.println("能看到的线段是");
        for (Segment s :
                eventController.segments) {
            if (s.isVisiable)System.out.println(s.name);
        }
    }
}
