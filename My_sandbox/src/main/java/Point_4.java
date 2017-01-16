/**
 * Created by bilovyur on 16.01.2017.
 */
public class Point_4 {

        public double x; //координата точки по x
        public double y; //координата точки по y

        public Point_4(double x, double y)
        {
            this.x = x;
            this.y= y;
        }
        public double distance(Point_4 b)
        {
            double k1 = this.x - b.x ;
            double k2 = this.y - b.y ;
            double  dist = Math.sqrt(k1*k1 + k2*k2);
            return dist;
        }



}
