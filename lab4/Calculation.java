package KI306.Shechuk.Lab4;

/**
 * Class Calculation implements method for y = 1 / sin(x) expression calculation
 *
 * @author Shevchuk Dmytro
 * @version 1.0
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Calculation
{
    private int x;

    public Calculation()
    {
        x = 1;
    }
    public void Input()
    {
        System.out.print("Input x: ");
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
    }
    public void Calc()
    {
        double res;
        double rad = x * Math.PI / 180.0;

        try
        {
            res = 1 / Math.sin(rad);

            if (res == Double.POSITIVE_INFINITY || res == Double.NEGATIVE_INFINITY || x % 180 == 0)
            {
                throw new ArithmeticException();
            }

            System.out.println("1 / sin(" + x + ") = " + res);
            log("1 / sin(" + x + ") = " + res);
        }
        catch (ArithmeticException ex)
        {
            if (x == 0)
            {
                throw new CalcException("Exception reason: X = 0");
            }
            else if (rad % Math.PI == 0)
            {
                throw new CalcException("Exception reason: Illegal value of X for sin calculation");
            }
            else
            {
                throw new CalcException("Unknown reason of the exception during exception calculation");
            }
        }
    }
    private void log(String msg)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true)))
        {
            writer.write(msg + "\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
