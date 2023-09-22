package KI306.Shechuk.Lab3;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
/**
 * Class AirConditioner is simulating work of AC
 * It has 5 properties, 10 methods
 */
public abstract class AirConditioner
{
    private String model;
    private String mode;
    private int cost;
    private int temperature;
    private boolean enabled;
    /**
     * Default constructor
     * */
    public AirConditioner()
    {
        model = "Unknown";
        mode = "Default";
        cost = 0;
        temperature = 20;
        enabled = false;
        log("Default constructor has worked");
    }
    /**
     * Constructor
     * */
    public AirConditioner(String model, String mode, int cost, int temperature, boolean enabled)
    {
        this.model = model;
        this.mode = mode;
        this.cost = cost;
        this.temperature = temperature;
        this.enabled = enabled;
        log("Constructor has worked");
    }
    /**
     * Turn on / turn off method
     * */
    protected void onOff()
    {
        enabled = (!enabled);
        log("AC is " + (enabled ? "on" : "off") + " now");
    }
    /**
     * Increasing temperature
     * */
    protected void plusTemp()
    {
        temperature++;
        log("Temperature+");
    }
    /**
     * Decreasing temperature
     * */
    protected void minusTemp()
    {
        temperature--;
        log("Temperature-");
    }
    /**
     * Changing the AC mode
     * */
    protected void changeMode()
    {
        System.out.println("Choose the mode: 1) Default, 2) Sleep, 3) Turbo");
        Scanner scanner = new Scanner(System.in);
        int choose;
        choose = scanner.nextInt();
        switch (choose)
        {
            case 1:
                mode = "Default";
                break;
            case 2:
                mode = "Sleep";
                break;
            case 3:
                mode = "Turbo";
                break;
            default:
                System.out.println("Choose 1-3");
                break;
        }
        log("Mode switched to " + mode);
    }
    /**
     * Setting the timer
     * */
    protected void setTimer(int time)
    {
        if (enabled == true)
        {
            System.out.println("AC will be turned off in " + time + " seconds");
        }
        else
        {
            System.out.println("AC will be turned on in " + time + " seconds");
        }
        try
        {
            Thread.sleep(time * 1000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        log("Times is set on " + time);
        onOff();
    }
    /**
     * Setting autoregualtion
     * */
    protected void autoregulation()
    {
        temperature = 22;
        mode = "Default";
        log("AC is on autoregulation");
    }
    /**
     * Changing info by hands
     * */
    protected void changeInfo(String model, String mode, int cost, int
            temperature, boolean enabled)
    {
        this.model = model;
        this.mode = mode;
        this.cost = cost;
        this.temperature = temperature;
        this.enabled = enabled;
        log("AC's info has been changed");
    }
    /**
     * Reseting info to default
     * */
    protected void resetInfo()
    {
        model = "Unknown";
        mode = "Default";
        cost = 0;
        temperature = 20;
        enabled = false;
        log("AC's info has been reseted");
    }
    /**
     * Printing info to console
     * */
    protected void printInfo()
    {
        System.out.println("AC model is " + model);
        System.out.println("Mode is " + mode);
        System.out.println("Cost - " + cost + " $");
        System.out.println("Current temp is " + temperature);
        System.out.println("It is " + (enabled ? "turned on" : "turned off"));
        log("AC's info has been printed");
    }
    /**
     * Responsible for logging information to a file
     * */
    private void log(String msg)
    {
        try (BufferedWriter writer = new BufferedWriter(new
                FileWriter("log.txt", true)))
        {
            writer.write(msg + "\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
