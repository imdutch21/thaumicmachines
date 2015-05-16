package bart.thaumicmachines.utils;

import java.awt.*;

/**
 * Created by Bart on 11-5-2015.
 */
public class HexToRGB
{
    public static float HexToRed(String hex)
    {
        Color color = Color.decode(hex);
        return color.getRed();
    }
    public static float HexToGreen(String hex)
    {
        Color color = Color.decode(hex);
        return color.getGreen();
    }
    public static float HexToBlue(String hex)
    {
        Color color = Color.decode(hex);
        return color.getBlue();
    }

    public static float HexToRedF(String hex)
    {
        String newHax = "0x" + hex;
        Color color = Color.decode(newHax);
        return color.getRed()/255f;
    }
    public static float HexToGreenF(String hex)
    {
        String newHax = "0x" + hex;
        Color color = Color.decode(newHax);
        return color.getGreen()/255f;
    }
    public static float HexToBlueF(String hex)
    {
        String newHax = "0x" + hex;
        Color color = Color.decode(newHax);
        return color.getBlue()/255f;
    }
}
