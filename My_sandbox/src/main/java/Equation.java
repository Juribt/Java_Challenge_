/**
 * Created by bilovyur on 05.02.2017.
 */
public class Equation {
    private double a;
    private double b;
    private double c;

    private int n; //количество корней уравнения

    public Equation (double a, double b, double c ) {
        this.a = a;
        this.b = b;
        this.c = c;
        double d = b * b - 4 * a * c; //вычисление дискриминанта


        if (a!= 0) {
            if (d > 0) {
                n = 2;
            } else if (d == 0) {
                n = 1;
            } else {
                n = 0;
            }
        } else if (b!= 0) {
            n = 1;
        } else if (c!= 0) {
            n = 0;
        } else {
            n = -1;
        }
            }


    public int rootNumber ()
    {
    return n;
    }
}
