package bart.thaumicmachines.potion;


import bart.thaumicmachines.lib.References;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by imdutch21 on 15-2-15.
 */
public class ModPotions extends Potion
{
    private static final ResourceLocation resource = new ResourceLocation(References.RESOURCESPREFIX + "textures/gui/potions.png");
    public static Potion volatus;
    public static Potion limus;
    public static Potion vinculum;
    public ModPotions(String name, boolean badEffect, int color, int iconIndex)
    {
        super(findFreeID(), badEffect, color);
        setPotionName("thaumicmachines.potion." + name);
        setIconIndex(iconIndex % 8, iconIndex / 8);
        getLiquidColor(color);
    }

    static int findFreeID()
    {
        for (int i = 0; i < potionTypes.length; i++)
            if (potionTypes[i] == null)
                return i;
        return -1;
    }

    public static void init()
    {
        if (Potion.potionTypes.length < 256)
            extendPotionArray();
        volatus = new PotionVolatus("volatus", false, 0xFFFFFF, 0);
        limus = new PotionLimus("limus", false, 0x01f800, 1);
        vinculum = new PotionVinculum("vinculum", false, 0x9a8080, 2);
    }

    public static void extendPotionArray()
    {
        Potion[] potionTypes = null;
        for (Field f : Potion.class.getDeclaredFields())
        {
            f.setAccessible(true);
            try
            {
                if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a"))
                {
                    Field modfield = Field.class.getDeclaredField("modifiers");
                    modfield.setAccessible(true);
                    modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);
                    potionTypes = (Potion[]) f.get(null);
                    Potion[] newPotionTypes = new Potion[256];
                    System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
                    f.set(null, newPotionTypes);
                }
            } catch (Exception e)
            {
                System.err.println("ThaumicMachines did something wrong but if you ask me it was totally not my fault. Just report it");
                System.err.println(e);
            }
        }
    }

    public int getLiquidColor(int liquidColour)
    {
        return liquidColour;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getStatusIconIndex()
    {
        Minecraft.getMinecraft().renderEngine.bindTexture(resource);
        return super.getStatusIconIndex();
    }
}
