package bart.thaumicmachines.potion;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by imdutch21 on 15-2-15.
 */
public class PotionHandler
{
    public int timer = 0;

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onEntityUpdateVolatus(LivingEvent.LivingUpdateEvent event)
    {
        if(event.entityLiving != null && event.entityLiving.isPotionActive(ModPotions.volatus))
        {
            EntityLivingBase living = event.entityLiving;
            int level = living.getActivePotionEffect(ModPotions.volatus).getAmplifier();
            if(living.motionY < -0.0784000015258789 && living.fallDistance >= 2.9 && !living.isSneaking())
            {
                living.motionY /= 1 + level * 0.33F;
                living.fallDistance = Math.max(2.9F, living.fallDistance - level / 3F);

                if(living.getActivePotionEffect(ModPotions.volatus).getDuration() == 0)
                {
                    living.removePotionEffect(ModPotions.volatus.id);
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public void onEntityUpdateVinclum(LivingEvent.LivingUpdateEvent event)
    {
        if(event.entityLiving != null && event.entityLiving.isPotionActive(ModPotions.vinculum))
        {
            EntityLivingBase living = event.entityLiving;
            living.setAIMoveSpeed(0f);
            living.motionZ = 0.0;
            if(living.getActivePotionEffect(ModPotions.vinculum).getDuration() == 0)
            {
                living.removePotionEffect(ModPotions.vinculum.id);
            } else
            {
                if(timer == 1)
                {
                    timer = 0;
                    event.setCanceled(true);
                } else
                {
                    timer++;
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = false)
    public void onEntityHurtLimus(LivingHurtEvent event)
    {
        if(event.entityLiving != null && event.source == DamageSource.fall && event.entityLiving.isPotionActive(ModPotions.limus))
        {
            event.ammount = 0;
            event.entity.motionY = 1.2 + .1 * event.entityLiving.getActivePotionEffect(ModPotions.limus).getAmplifier();
            event.setCanceled(true);
            if(event.entityLiving.getActivePotionEffect(ModPotions.limus).getDuration() == 0)
            {
                event.entityLiving.removePotionEffect(ModPotions.limus.id);
            }
        }
    }


    @SubscribeEvent
    public void onEndermanTP(EnderTeleportEvent event)
    {
        if(event.entityLiving.isPotionActive(ModPotions.volatus))
        {
            event.setCanceled(true);
        }
    }


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onEntityUpdateEntropy(LivingEvent.LivingUpdateEvent living)
    {
        if(living.entity instanceof EntityPlayer && ((EntityPlayer) living.entity).isPotionActive(ModPotions.entropy))
        {
            if(!((EntityPlayer) living.entity).capabilities.isCreativeMode)
            {
                if(timer == 100)
                {
                    ItemStack[] inventory = ((EntityPlayer) living.entity).inventory.mainInventory;

                    ItemStack[] items = new ItemStack[9];
                    for(int i = 0; i < items.length; i++)
                    {
                        items[i] = inventory[i];
                    }
                    List<ItemStack> list = Arrays.asList(items);
                    Collections.shuffle(list);

                    for(int x = 0; x < items.length; x++)
                    {
                        ((EntityPlayer) living.entity).inventory.mainInventory[x] = list.get(x);
                    }
                    if(living.entityLiving.getActivePotionEffect(ModPotions.entropy).getDuration() == 0)
                    {
                        living.entityLiving.removePotionEffect(ModPotions.entropy.id);
                    }
                }
            }
            else timer++;
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onEntityUpdateCold(LivingEvent.LivingUpdateEvent event)
    {
        if(event.entityLiving != null && event.entityLiving.isPotionActive(ModPotions.cold))
        {
            EntityLivingBase living = event.entityLiving;


            int x = (int) living.posX;
            int y = (int) living.posY;
            int z = (int) living.posZ;
            if(living.worldObj.getBlock(x, y, z).getMaterial() == Material.air && living.worldObj.getBlock(x, y - 1, z).getMaterial() != Material.air && Blocks.snow_layer.canPlaceBlockAt(living.worldObj, x, y, z))
            {
                living.worldObj.setBlock(x, y, z, Blocks.snow_layer);
            }
            for(int i = 0; i < ForgeDirection.VALID_DIRECTIONS.length; i++)
            {
                ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
                Block block = living.worldObj.getBlock(x + direction.offsetX, y - 1 + direction.offsetY, z + direction.offsetZ);
                if(block == Blocks.water)
                {
                    living.worldObj.setBlock(x + direction.offsetX, y - 1 + direction.offsetY, z + direction.offsetZ, Blocks.ice);
                }
            }
            if(event.entityLiving.getActivePotionEffect(ModPotions.cold).getDuration() == 0)
            {
                event.entityLiving.removePotionEffect(ModPotions.cold.id);
            }
        }
    }
}
