import java.util.ArrayList;
import java.util.Arrays;
interface Aa
{
    void hello(int a, int b);
}


public class Sample {
    public static void main(String[] args) {
    Aa a = (x, y) -> System.out.print("Addition is "+ (x+y));
    a.hello(2,4);
    }
}
