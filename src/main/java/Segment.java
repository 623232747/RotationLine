public class Segment implements Comparable<Segment> {
    String name;
    Point start;
    Point end;
    boolean isVisiable = false;

    float getSlope() {
        return (end.getY() - start.getY()) / (end.getX() - start.getX());
    }

    // 约束：start < end
    float getDis() {
        // 有问题！！！！！
        float k = getSlope();
        float t;
        t = (float) Math.tan(EventController.getEventController().scanLineAlpha);
        if (k != Float.POSITIVE_INFINITY && k != Float.POSITIVE_INFINITY && k == k)
            return (1 + t * t) * (k * start.getX() - start.getY()) / (k - t) * (k * start.getX() - start.getY()) / (k - t);
        return (1 + t * t) * start.getX() * start.getX();

    }

    Point getXIntercept() {
        if (end.getY() == start.getY() && end.getY() == 0 && end.getX() == start.getX())
            return new Point(end.getX() + Point.px, Point.py);
        else if (end.getY() != start.getY())
            return new Point(start.getX() - start.getY() / getSlope() + Point.px, Point.py);
        return null;
    }

    public Segment(String name, Point start, Point end) {
        this.name = name;
        if (start.angle > end.angle && start.angle - end.angle < Math.PI) {
            this.start = end;
            this.end = start;
//            System.out.println("reverse: " + this);
        } else {
            this.start = start;
            this.end = end;
        }
    }

    @Override
    public int compareTo(Segment o) {
        if (name.equals(o.name)) return 0;
        return getDis() > o.getDis() ? 1 : -1;
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
                ", start=" + start +
                ", end=" + end +
                ", dis=" + getDis() +
                '}';
    }
}
