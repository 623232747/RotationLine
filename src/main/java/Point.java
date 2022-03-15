public class Point implements Comparable<Point> {
    static float px = 0;
    static float py = 0;


    public float getX() {
        return x-px;
    }

    public float getY() {
        return y-py;
    }

    private float x;
    private float y;
    float angle;


    Point(float x, float y) {
        this.x = x;
        this.y = y;
        this.angle = (float) (Math.atan2(y-py,x-px));
    }


    float dis() {
        return getX() * getX() + getY() * getY();
    }

        @Override
    public int compareTo(Point o) {
            if (angle == o.angle) {
                return dis() < o.dis()?1:-1; //角度相等时，根据原点距离排序，这样可以让原点排在第一个
            }
            return angle > o.angle?1:-1;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", angle=" + angle +
                '}';
    }
}
