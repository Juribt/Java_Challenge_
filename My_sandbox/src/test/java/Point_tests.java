import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;
//import org.testng.annotations.Test;
//import org.testng.annotations.Test;

/**
 * Created by bilovyur on 16.01.2017.
 */
public class Point_tests {

    @Test
public void test_distance ()
    {
        Point_4 d= new Point_4(4,3);
        Point_4 c= new Point_4(4,-3);

        assert d.distance(c)== 6.0; //проверка расстояния между точками, корректное значение

        Assert.assertEquals(d.distance(c), 6.0); //проверка расстояния между точками, корректное значение



    }
     //запуск второго теста
    @Test
    public void test_distance_1 ()
    {
        Point_4 a= new Point_4(-1,2);
        Point_4 b= new Point_4(3,2);

        assert a.distance(b)== 4.0; //проверка расстояния между точками, корректное значение

        Assert.assertEquals(a.distance(b), 4.0); //проверка расстояния между точками, корректное значение



    }

}
