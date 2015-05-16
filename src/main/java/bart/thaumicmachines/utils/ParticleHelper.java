package bart.thaumicmachines.utils;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Bart on 16-5-2015.
 */
public class ParticleHelper
{
    @SideOnly(Side.CLIENT)
    public static void spawnParticle(World world, double x, double y, double z, double motionX, double motionY, double motionZ, float red, float green, float blue, int index)
    {
        EntityFX particle = new EntityFX(world, x, y, z, motionX, motionY, motionZ);

        particle.setRBGColorF(red, green, blue);
        particle.setParticleTextureIndex(index);

        Minecraft mc = FMLClientHandler.instance().getClient();

        if(mc == null || mc.renderViewEntity == null || mc.effectRenderer == null || mc.gameSettings == null)
        {
            return;
        }

        int particleSetting = mc.gameSettings.particleSetting;
        Random rand = new Random();
        if(particleSetting == 2 || (particleSetting == 1 && rand.nextInt(3) > 0))
        {
            return;
        }

        double distanceX = mc.renderViewEntity.posX - (int)x;
        double distanceY = mc.renderViewEntity.posY - (int)y;
        double distanceZ = mc.renderViewEntity.posZ - (int)z;

        double viewableDistanceSqr = 256.0D;
        double distanceFromBlockSqr = distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ;

        if(distanceFromBlockSqr > viewableDistanceSqr)
        {
            return;
        }
        if(world.getBlock((int) x, (int) y, (int) z).isOpaqueCube())
        {
            return;
        }
        mc.effectRenderer.addEffect(particle);
    }
}
