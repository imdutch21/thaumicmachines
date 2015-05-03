package bart.thaumicmachines.potion;

import bart.thaumicmachines.utils.ActivatingBlocks;
import bart.thaumicmachines.utils.ObjectFinder;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockLever;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
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
    public void onEntityUpdatePerditio(LivingEvent.LivingUpdateEvent living)
    {
        if(living.entity instanceof EntityPlayerMP && ((EntityPlayerMP) living.entity).isPotionActive(ModPotions.perditio))
        {
            if(!((EntityPlayerMP) living.entity).capabilities.isCreativeMode)
            {
                if(timer >= 100)
                {
                    ItemStack[] inventory = ((EntityPlayerMP) living.entity).inventory.mainInventory;

                    ItemStack[] items = new ItemStack[9];
                    for(int i = 0; i < items.length; i++)
                    {
                        items[i] = inventory[i];
                    }
                    List<ItemStack> list = Arrays.asList(items);
                    Collections.shuffle(list);

                    for(int x = 0; x < items.length; x++)
                    {
                        ((EntityPlayerMP) living.entity).inventory.mainInventory[x] = list.get(x);
                    }
                    if(living.entityLiving.getActivePotionEffect(ModPotions.perditio).getDuration() == 0)
                    {
                        living.entityLiving.removePotionEffect(ModPotions.perditio.id);
                    }
                    timer = 0;
                } else
                    timer++;
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onEntityUpdateGelum(LivingEvent.LivingUpdateEvent event)
    {
        if(event.entityLiving != null && event.entityLiving.isPotionActive(ModPotions.gelum))
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
            if(event.entityLiving.getActivePotionEffect(ModPotions.gelum).getDuration() == 0)
            {
                event.entityLiving.removePotionEffect(ModPotions.gelum.id);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onEntityUpdateMachima(LivingEvent.LivingUpdateEvent event)
    {
        if(event.entityLiving != null && event.entityLiving.isPotionActive(ModPotions.machima))
        {
            if(timer >= 20)
            {
                EntityLivingBase living = event.entityLiving;
                World world = living.worldObj;
                int lowest = (int) living.posY - 5;
                int highest = (int) living.posY + 5;
                int xMin = (int) living.posX - 5;
                int xMax = (int) living.posX + 5;
                int zMin = (int) living.posZ - 5;
                int zMax = (int) living.posZ + 5;

                for(int y = lowest; y <= highest; y++)
                {
                    for(int x = xMin; x <= xMax; x++)
                    {
                        for(int z = zMin; z <= zMax; z++)
                        {
                            Block block = world.getBlock(x, y, z);
                            if(block instanceof BlockLever)
                            {
                                ActivatingBlocks.ActivateLever(block, world, x, y, z);
                            } else if(block instanceof BlockButton)
                            {
                                ActivatingBlocks.ActivateButton(block, world, x, y, z);
                            }
                        }
                    }
                }
                timer = 0;
            } else
                timer++;
        }
    }
}

