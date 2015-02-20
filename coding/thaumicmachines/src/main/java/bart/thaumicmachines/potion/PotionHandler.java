package bart.thaumicmachines.potion;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

/**
 * Created by imdutch21 on 15-2-15.
 */
public class PotionHandler
{
    public int timer = 0;

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onEntityUpdateVolatus(LivingEvent.LivingUpdateEvent event)
    {
        if (event.entityLiving != null && event.entityLiving.isPotionActive(ModPotions.volatus))
        {
            EntityLivingBase living = event.entityLiving;
            int level = living.getActivePotionEffect(ModPotions.volatus).getAmplifier();
            if (living.motionY < -0.0784000015258789 && living.fallDistance >= 2.9 && !living.isSneaking())
            {
                living.motionY /= 1 + level * 0.33F;
                living.fallDistance = Math.max(2.9F, living.fallDistance - level / 3F);

                if (living.getActivePotionEffect(ModPotions.volatus).getDuration() == 0)
                {
                    living.removePotionEffect(ModPotions.volatus.id);
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public void onEntityUpdateVinclum(LivingEvent.LivingUpdateEvent event)
    {
        if (event.entityLiving != null && event.entityLiving.isPotionActive(ModPotions.vinculum))
        {
            EntityLivingBase living = event.entityLiving;

            living.motionX = 0.0;
            living.motionY = 0.0;
            living.motionZ = 0.0;
            living.setVelocity(0, 0, 0);
            living.getActivePotionEffect(ModPotions.vinculum);
            if (living.getActivePotionEffect(ModPotions.vinculum).getDuration() == 0)
            {
                living.removePotionEffect(ModPotions.vinculum.id);
            }else
            {
                if (timer == 1)
                {
                    timer = 0;
                    event.setCanceled(true);
                }else
                {
                    timer++;
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = false)
    public void onEntityHurtLimus(LivingHurtEvent event)
    {
        if (event.entityLiving != null && event.source == DamageSource.fall && event.entityLiving.isPotionActive(ModPotions.limus))
        {
            event.ammount = 0;
            event.entity.motionY = 1.2 + .1*event.entityLiving.getActivePotionEffect(ModPotions.limus).getAmplifier();
            event.setCanceled(true);
            if (event.entityLiving.getActivePotionEffect(ModPotions.limus).getDuration() == 0)
            {
                event.entityLiving.removePotionEffect(ModPotions.limus.id);
            }
        }
    }


    @SubscribeEvent
    public void onEndermanTP(EnderTeleportEvent event)
    {
        if (event.entityLiving.isPotionActive(ModPotions.volatus))
        {
            event.setCanceled(true);
        }
    }

}
