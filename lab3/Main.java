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
        ClimatControl CC = new ClimatControl();
        CC.onOff();
        CC.minusTemp();
        CC.plusTemp();
        CC.changeMode();
        CC.changeInfo("V1", "Turbo", 500, 23, true);
        CC.autoregulation();
        CC.setTimer(3);
        CC.printInfo();
        CC.resetInfo();

        CC.setCcTemperature(22);
        CC.turnOnCc();
        CC.setCcTemperature(22);
        CC.turnOffCc();
    }
}
