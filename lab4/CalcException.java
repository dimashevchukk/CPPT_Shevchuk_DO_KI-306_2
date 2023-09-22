package KI306.Shechuk.Lab4;

/**
 * Class CalcException more precises ArithmeticException
 *
 */

public class CalcException extends ArithmeticException
{
    public CalcException(String cause)
    {
        super(cause);
    }
}
