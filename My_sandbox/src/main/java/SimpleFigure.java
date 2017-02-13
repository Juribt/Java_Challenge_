/**
 * Created by bilovyur on 11.02.2017.
 */
public class SimpleFigure {

    public static boolean isSimple(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }


        }

        return true;  //перебор закончен, число простое
    }

    public static boolean isSimpleWhile(int n) {
        int i = 2;       //инициализация
        while (i < n && n % i != 0) {       //проверка окончания
            i++;  //увеличение счётчика
        }
        return i == n;  //перебор закончен, число простое, если возвращает n, т.е true то значит условие верно и число простое, если это условие не верно то возвращается false и число непростое
    }

    public static boolean isSimple(long n) {
        for (long i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }


        }

        return true;  //перебор закончен, число простое
    }

    public static boolean isSimpleFast(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }


        }

        return true;  //перебор закончен, число простое
    }

    public static boolean isSimpleFastest(int n) {
        int m = (int) Math.sqrt(n);  //преобразование к целому типу
        for (int i = 2; i < m; i++) {
            if (n % i == 0) {
                return false;
            }


        }

        return true;  //перебор закончен, число простое
    }
}