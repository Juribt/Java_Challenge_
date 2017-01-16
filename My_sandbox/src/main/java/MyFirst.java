public class MyFirst
		{
public static void main(String[] args)
        {
			Point_4 a= new Point_4(4,3);
			Point_4 b= new Point_4(4,-3);
			double dist2 = a.distance(b);

			System.out.println("Distance (with method corrected ) between two points is :" + dist2);
	}
	}
