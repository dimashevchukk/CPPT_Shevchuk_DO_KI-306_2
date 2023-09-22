package KI306.Shechuk.Lab3;

/**
 * Class ClimatControl extends class Airconditioner with 3 methods and 2 properties
 * */
interface iClimatControl
{
    void setCcTemperature(int ccTemperature);
    void turnOnCc();
    void turnOffCc();
}
public class ClimatControl extends AirConditioner implements iClimatControl
{
    private int ccTemperature;
    private boolean ccEnabled;

    public ClimatControl()
    {
        ccTemperature = 20;
        ccEnabled = false;
    }

    @Override
    public void setCcTemperature(int ccTemperature)
    {
        if (!ccEnabled)
        {
         System.out.println("Firts turn on the CC");
        }
        else
        {
            this.ccTemperature = ccTemperature;
        }
    }

    @Override
    public void turnOnCc() {
        ccEnabled = true;
    }

    @Override
    public void turnOffCc() {
        ccEnabled = false;
    }
}
