public class Segment implements Comparable<Segment> {
    String name;
    Point start;
    Point end;
    boolean isVisiable = false;

    float getSlope() {
        if (end.getX() == start.getX()) return 10000000000000000f;
        return (end.getY() - start.getY()) / (end.getX() - start.getX());
    }

    // 约束：start < end
    float getDis() {
        // 有问题！！！！！
        float k = getSlope();
        float t;
        if (EventController.getEventController().scanLineAlpha == Math.PI / 2) t = 10000000000000000f;
        else if (EventController.getEventController().scanLineAlpha == -Math.PI / 2) t = 10000000000000000f;
        else t = (float) Math.tan(EventController.getEventController().scanLineAlpha);
        return (1 + t * t) * (k * start.getX() - start.getY()) / (k - t) * (k * start.getX() - start.getY()) / (k - t);
    }

    Point getXIntercept() {
        return new Point(end.getX() - end.getY() / getSlope(), 0);
    }

    public Segment(String name, Point start, Point end) {
        this.name = name;
        this.start = start;
        this.end = end;

    }

    @Override
    public int compareTo(Segment o) {
        if (name.equals(o.name)) return 0;
        return getDis() < o.getDis() ? 1 : -1;
    }

    @Override
    public int hashCode() {
        // return id.hashCode();
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Segment{" +
                "name='" + name + '\'' +
                "dis='" + getDis() + '\'' +
                '}';
    }
}
