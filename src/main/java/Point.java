public class Point implements Comparable<Point> {
    static Point polar = new Point(0, 0);


    public float getX() {
        return x-polar.x;
    }

    public float getY() {
        return y-polar.y;
    }

    private float x;
    private float y;
    float angle;


    Point(float x, float y) {
        this.x = x;
        this.y = y;
        this.angle = (float) (Math.atan2(y,x));
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

}
