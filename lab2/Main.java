package KI306.Shechuk.Lab3;

/**
 * Class Main implements work of AirConditioner class
 *
 * @author Shevchuk Dmytro
 * @version 1.0
 * @since version 1.0
 */

public class Main
{
    public static void main(String[] args)
    {
        AirConditioner AC = new AirConditioner("V2", "Default", 1000, 22, false);

        AC.onOff();
        AC.minusTemp();
        AC.plusTemp();
        AC.changeMode();
        AC.changeInfo("V1", "Turbo", 500, 23, true);
        AC.autoregulation();
        AC.setTimer(3);
        AC.printInfo();
        AC.resetInfo();
    }
}