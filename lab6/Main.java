package KI306.Shechuk.Lab6;

import java.util.*;

public class Main
{
    /**
     * The GoodsStorage class is a container for goods
     *
     * @author Shevchuk Dmytro
     * @version 1.0
     */

    public static void main(String[] args)
    {
        GoodsStorage <? super Data> gs = new GoodsStorage <Data>();

        gs.AddData(new Water("Karpatska", 15));
        gs.AddData(new Water("Morshynska", 20));
        gs.AddData(new Gum("Orbit", 14));
        gs.AddData(new Gum("Dirol", 17));
        gs.AddData(new Gum("Dirol", 17));
        gs.AddData(new Gum("SFafd", 19));

        System.out.print("The most expensive good is: \n");
        Data max = gs.findMax();
        max.print();

        System.out.println("Water: " + Water.num);
        System.out.println("Gum: " + Gum.num);

        int gumCount = 0;
        int waterCount = 0;

        for (Object item : gs.getData())
        {
            if (item instanceof Gum)
            {
                gumCount++;
            }
            else
            {
                waterCount++;
            }
        }

        System.out.println("Number of Gum items: " + gumCount);
        System.out.println("Number of Water items: " + waterCount);

    }
}
class GoodsStorage <T extends Data>
{
    private ArrayList<T> arr;
    public GoodsStorage()
    {
        arr = new ArrayList<T>();
    }

    public List<? super T> getData()
    {
        return arr;
    }
    public T findMax()
    {
        if (!arr.isEmpty())
        {
            T max = arr.get(0);

            for (int i = 1; i < arr.size(); i++)
            {
                if (arr.get(i).compareTo(max) > 0)
                {
                    max = arr.get(i);
                }

            }

            return max;
        }

        return null;
    }
    public void AddData(T data)
    {
        arr.add(data);
        System.out.print("Element added: ");
        data.print();
    }
    public void DeleteData(int i)
    {
        arr.remove(i);
    }
    public void Eat(int i)
    {
        System.out.print("You have eaten good at index " + i);
        DeleteData(i);
    }
}
/**
 * The Data interface represents items that can be used and have weight.
 *
 * @author Shevchuk Dmytro
 * @version 1.0
 */
interface Data extends Comparable<Data>
{
    public int getCost();

    public void print();
}

/**
 * The Water class represents a Water item that implements the Data interface.
 *
 * @author Shevchuk Dmytro
 * @version 1.0
 */
class Water implements Data
{
    private String name;
    private int cost;
    public static int num = 0;
    public Water(String name, int cost)
    {
        this.name = name;
        this.cost = cost;

        num++;
    }
    @Override
    public int getCost()
    {
        return cost;
    }
    public void setCost(int cost)
    {
        this.cost = cost;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    @Override
    public void print()
    {
        System.out.println("Cost of " + name + " is " + cost);
    }
    @Override
    public int compareTo(Data data)
    {
        Integer c = cost;
        return c.compareTo(data.getCost());
    }
}
/**
 * The Gum class represents a Water item that implements the Data interface.
 *
 * @author Shevchuk Dmytro
 * @version 1.0
 */
class Gum implements Data
{
    private String name;
    private int cost;
    public static int num = 0;
    public Gum(String name, int cost)
    {
        this.name = name;
        this.cost = cost;
        num++;
    }
    @Override
    public int getCost()
    {
        return cost;
    }
    public void setCost(int cost)
    {
        this.cost = cost;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    @Override
    public void print()
    {
        System.out.println("Cost of " + name + " is " + cost);
    }
    @Override
    public int compareTo(Data data)
    {
        Integer c = cost;
        return c.compareTo(data.getCost());
    }
}