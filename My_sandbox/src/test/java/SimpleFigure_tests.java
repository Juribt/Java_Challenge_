import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by bilovyur on 11.02.2017.
 */
public class SimpleFigure_tests {

    @Test
    public void test_SimpleFigure(){
      Assert.assertTrue(SimpleFigure.isSimple(Integer.MAX_VALUE));
    }

    @Test
    public void test_NON_SimpleFigure(){
        Assert.assertFalse(SimpleFigure.isSimple(Integer.MAX_VALUE -2)); //поставим assertFalse так как ожидаем, что не будет простое число
    }

    @Test
    public void test_While_SimpleFigure(){
        Assert.assertTrue(SimpleFigure.isSimpleWhile(Integer.MAX_VALUE)); //поставим assertFalse так как ожидаем, что не будет простое число
    }

    @Test (enabled=false)
    public void test_Long_SimpleFigure(){
       long n=Integer.MAX_VALUE; //после этого число будет преобразовано к типу long
        Assert.assertTrue(SimpleFigure.isSimple(n));
    }

    @Test
    public void test_SimpleFastFigure(){
        Assert.assertTrue(SimpleFigure.isSimpleFast(Integer.MAX_VALUE));
    }

    @Test
    public void test_SimpleFastestFigure(){
        Assert.assertTrue(SimpleFigure.isSimpleFastest(Integer.MAX_VALUE));
    }
}
