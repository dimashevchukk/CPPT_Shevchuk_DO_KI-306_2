package KI306.Shechuk.Lab5;

import java.io.*;
import java.util.*;
import java.io.IOException;

/**
 * Class Main show usage of class CalcWFio
 *
 * @author Shevchuk Dmytro
 * @version 1.0
 */

public class Main
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        try
        {
            CalcWFio obj = new CalcWFio();

            Scanner s = new Scanner(System.in);
            System.out.print("Enter data: ");

            double data = s.nextDouble();

            if (data > 10)
            {
                throw new ArithmeticException();
            }

            obj.calculate(data);

            obj.writeResTxt("textRes.txt");
            obj.writeResBin("BinRes.bin"); // record res to files

            obj.readResBin("BinRes.bin");
            System.out.println("Result is: " + obj.getResult()); // output from .bin

            obj.readResTxt("textRes.txt");
            System.out.println("Result is: " + obj.getResult()); // output from .txt
        }
        catch (ArithmeticException | FileNotFoundException e)
        {
            System.out.println("Error x must be less 10");
        }
    }
}

class CalcWFio
{
    public void writeResTxt(String fName) throws FileNotFoundException
    {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%f ",result);
        f.close();
    }
    public void readResTxt(String fName)
    {
        try
        {
            File f = new File (fName);
            if (f.exists())
            {
                Scanner s = new Scanner(f);
                result = s.nextDouble();
                s.close();
            }
            else
            {
                throw new FileNotFoundException("File " + fName + "not found");
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.print(ex.getMessage());
        }
    }
    public void writeResBin(String fName) throws FileNotFoundException, IOException
    {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();
    }
    public void readResBin(String fName) throws FileNotFoundException, IOException
    {
        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }
    public void calculate(double x)
    {
        double rad = x * Math.PI / 180.0;

        try
        {
            result = 1 / Math.sin(rad);

            if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY || x % 180 == 0)
            {
                throw new ArithmeticException();
            }

            System.out.println("1 / sin(" + x + ") = " + result);
        }
        catch (ArithmeticException ex)
        {
            if (x == 0)
            {
                throw new ArithmeticException("Exception reason: X = 0");
            }
            else if (rad % Math.PI == 0)
            {
                throw new ArithmeticException("Exception reason: Illegal value of X for sin calculation");
            }
            else
            {
                throw new ArithmeticException("Unknown reason of the exception during exception calculation");
            }
        }
    }
    public double getResult()
    {
        return result;
    }
    private double result;
}