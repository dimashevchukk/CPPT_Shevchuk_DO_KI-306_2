import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

/**
 * Клас Lab1ShevchukKI306 реалізує виконання лабораторної роботи №1
 *
 * @author Shevchuk Dmytro
 * @version 1.0
 * @since version 1.0
 */

public class Lab1ShevchukKI306
{
    /**
     * Метод відповідає за ввід розміру матриці
     *
     * @return int розмір матриці
     */
    public static int SizeInput()
    {
        Scanner scanner = new Scanner(System.in);
        int size;

        while (true)
        {
            try
            {
                System.out.print("Введіть розмір квадратної матриці: ");
                size = scanner.nextInt();

                if (size <= 0)
                {
                    System.out.println("Число має бути більше нуля");
                    throw new Exception();
                }

                return size;
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage() + " Введіть число:");
                scanner.next();
            }
        }
    }
    /**
     * Метод відповідає за ввід символу-заповнювача
     *
     * @return char символ
     */
    public static char FillerInput()
    {
        Scanner scanner = new Scanner(System.in);
        char filler;

        while (true)
        {
            try
            {
                System.out.print("Введіть символ-заповнювач: ");
                String str = scanner.nextLine();

                if (str.length() != 1)
                {
                    System.out.println("Введіть один символ");
                    continue;
                }

                return str.charAt(0);
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
                scanner.next();
            }
        }
    }
    /**
     * Метод генерує зубчастий масив
     * @param size
     * @param filler
     * @return arr
     */
    public static char[][] GenerateArray(int size, char filler)
    {
        char [][] arr = new char[size][];

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = new char[size];

            if (size % 2 == 0)
            {
                if (i < arr.length / 2 - 1)
                {
                    size -= 2;
                }
                else if (i > arr.length / 2 - 1)
                {
                    size += 2;
                }
            }
            else
            {
                if (i < arr.length / 2)
                {
                    size -= 2;
                }
                else
                {
                    size += 2;
                }
            }
        }

        for (int i = 0; i < arr.length; i++)
        {
            Arrays.fill(arr[i], filler);
        }

        return arr;
    }
    /**
     * Метод виводить згенерований масив на консоль
     *
     * @param arr
     */
    public static void PrintArray(char[][] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length - (arr[i].length / 2); j++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j]);
            }
            for (int j = 0; j < arr.length - (arr[i].length / 2); j++)
            {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    /**
     * Метод зберігає згенерований масив у файл
     *
     * @param arr
     */
    public static void SaveArrToFile(char[][] arr)
    {
        try
        {
            PrintWriter writer = new PrintWriter("arr.txt");

            for (int i = 0; i < arr.length; i++)
            {
                for (int j = 0; j < arr.length - (arr[i].length / 2); j++)
                {
                    writer.print(" ");
                }
                for (int j = 0; j < arr[i].length; j++)
                {
                    writer.print(arr[i][j]);
                }
                for (int j = 0; j < arr.length - (arr[i].length / 2); j++)
                {
                    writer.print(" ");
                }
                writer.println();
            }

            writer.flush();
            writer.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Точка входу в програму
     */
    public static void main(String[] args)
    {
        int size = SizeInput();
        char filler = FillerInput();
        char[][] arr = GenerateArray(size, filler);

        PrintArray(arr);
        SaveArrToFile(arr);
    }
}
