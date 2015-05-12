package bart.thaumicmachines.tileentities;

import bart.thaumicmachines.blocks.BlockMachineUpgrade;
import bart.thaumicmachines.blocks.BlockMachineUpgrade2;
import bart.thaumicmachines.lib.handler.ConfigHandler;
import bart.thaumicmachines.potion.ModPotions;
import bart.thaumicmachines.utils.HexToRGB;
import bart.thaumicmachines.utils.ObjectFinder;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.IAspectContainer;

import java.util.List;

import static thaumcraft.api.aspects.Aspect.*;

/**
 * Created by imdutch21 on 14-2-15.
 */
public class TEEssentiaMachine extends TileEntity
{
    public Aspect jarAspectType = null;
    public Boolean isJarWithAspect = false;
    public Aspect currentAspect = null;
    public int ticksTillRefresh = 0;
    public int refresh = 0;
    public int facing;
    public boolean isWorking = false;
    public double efficiencyUpgrade = 1;
    public int rangeUpgrade = 5;
    public double powerUpgrade = 1;

    @Override
    public void updateEntity()
    {
        getJarAspect();
        spawnParticles();
        upgradeCalculator();
        if(currentAspect != null)
        {
            if(ticksTillRefresh <= 0)
                ticksTillRefresh = 0;
            else if(currentAspect == AIR && ConfigHandler.effectAIR)
                functionAIR();
            else if(currentAspect == WATER && ConfigHandler.effectWATER)
                functionWATER();
            else if(currentAspect == FIRE && ConfigHandler.effectFIRE)
                functionFIRE();
            else if(currentAspect == ENTROPY && ConfigHandler.effectENTROPY)
                functionENTROPY();
            else if(currentAspect == WEATHER && ConfigHandler.effectWEATHER)
                functionWEATHER();
            else if(currentAspect == MOTION && ConfigHandler.effectMOTION)
                functionMOTION();
            else if(currentAspect == LIFE && ConfigHandler.effectLIFE)
                functionLIFE();
            else if(currentAspect == POISON && ConfigHandler.effectPOISON)
                functionPOISON();
            else if(currentAspect == ENERGY && ConfigHandler.effectENERGY)
                functionENERGY();
            else if(currentAspect == FLIGHT && ConfigHandler.effectFLIGHT)
                functionFLIGHT();
            else if(currentAspect == DARKNESS && ConfigHandler.effectDARKNESS)
                functionDARKNESS();
            else if(currentAspect == HEAL && ConfigHandler.effectHEAL)
                functionHEAL();
            else if(currentAspect == SLIME && ConfigHandler.effectSLIME)
                functionSLIME();
            else if(currentAspect == TAINT && ConfigHandler.effectTAINT)
                functionTAINT();
            else if(currentAspect == TRAP && ConfigHandler.effectTRAP)
                functionTRAP();
            else
                currentAspect = null;
        }
    }


    public void getJarAspect()
    {
        Block block = worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord);
        TileEntity tile = worldObj.getTileEntity(this.xCoord, this.yCoord + 1, this.zCoord);
        Block jar = GameRegistry.findBlock("Thaumcraft", "blockJar");
        if(ticksTillRefresh == 0 && tile != null && tile instanceof IAspectContainer && block != null && jar != null && block.equals(jar) && block.getDamageValue(worldObj, this.xCoord, this.yCoord, this.zCoord) == 0)
        {
            IAspectContainer tileJar = (IAspectContainer) tile;
            if(tileJar.getAspects().getAspects()[0] != null)
            {
                jarAspectType = tileJar.getAspects().getAspects()[0];
                isJarWithAspect = true;
                AspectList list = tileJar.getAspects();
                int amount = (int) (getDurationForAspect(jarAspectType) * efficiencyUpgrade);
                if(ticksTillRefresh == 0 && list.getAmount(jarAspectType) > 0 && amount > 0 && tileJar.takeFromContainer(jarAspectType, (int) (1 + (powerUpgrade > 1 ? powerUpgrade : 0) * 2 + (rangeUpgrade > 5 ? rangeUpgrade : 0) / 2)))
                {
                    tileJar.takeFromContainer(jarAspectType, 0);
                    currentAspect = jarAspectType;
                    ticksTillRefresh = amount;
                }
            } else
            {
                jarAspectType = null;
                isJarWithAspect = false;
            }
        } else
        {
            jarAspectType = null;
            isJarWithAspect = false;
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setInteger("facing", facing);
        if(ticksTillRefresh > 0)
            nbt.setInteger("tilrefresh", ticksTillRefresh);
        if(refresh > 0)
            nbt.setInteger("refresh", refresh);
        if(currentAspect.getName() != null)
            nbt.setString("aspect", currentAspect.getName());
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        facing = nbt.getInteger("facing");
        if(nbt.getInteger("tilrefresh") > 0)
            ticksTillRefresh = nbt.getInteger("tilrefresh");
        if(nbt.getInteger("refresh") > 0)
            refresh = nbt.getInteger("refresh");
        if(nbt.getString("aspect") != null)
            currentAspect = Aspect.getAspect(nbt.getString("aspect"));
    }

    public void upgradeCalculator()
    {
        rangeUpgrade = 5;
        efficiencyUpgrade = 1;
        powerUpgrade = 1;
        for(int i = 0; i < ForgeDirection.VALID_DIRECTIONS.length; i++)
        {
            ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];
            Block block = worldObj.getBlock(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);
            int meta = worldObj.getBlockMetadata(this.xCoord + direction.offsetX, this.yCoord + direction.offsetY, this.zCoord + direction.offsetZ);

            Boolean block1 = block instanceof BlockMachineUpgrade;
            Boolean block2 = block instanceof BlockMachineUpgrade2;
            if(block1 || block2)
            {
                if(direction.equals(ForgeDirection.UP))
                {
                    if(meta == 0 && block1)
                        rangeUpgrade += ConfigHandler.rangeUpgrade;
                    if(meta == 6 && block1)
                        efficiencyUpgrade += ConfigHandler.efficiencyUpgrade;
                    if(meta == 0 && block2)
                        powerUpgrade += ConfigHandler.powerUpgrade;
                } else if(direction.equals(ForgeDirection.DOWN))
                {
                    if(meta == 1 && block1)
                        rangeUpgrade += ConfigHandler.rangeUpgrade;
                    if(meta == 7 && block1)
                        efficiencyUpgrade += ConfigHandler.efficiencyUpgrade;
                    if(meta == 1 && block2)
                        powerUpgrade += ConfigHandler.powerUpgrade;
                } else if(direction.equals(ForgeDirection.EAST))
                {
                    if(meta == 3 && block1)
                        rangeUpgrade += ConfigHandler.rangeUpgrade;
                    if(meta == 9 && block1)
                        efficiencyUpgrade += ConfigHandler.efficiencyUpgrade;
                    if(meta == 3 && block2)
                        powerUpgrade += ConfigHandler.powerUpgrade;
                } else if(direction.equals(ForgeDirection.WEST))
                {
                    if(meta == 5 && block1)
                        rangeUpgrade += ConfigHandler.rangeUpgrade;
                    if(meta == 11 && block1)
                        efficiencyUpgrade += ConfigHandler.efficiencyUpgrade;
                    if(meta == 5 && block2)
                        powerUpgrade += ConfigHandler.powerUpgrade;
                } else if(direction.equals(ForgeDirection.NORTH))
                {
                    if(meta == 2 && block1)
                        rangeUpgrade += ConfigHandler.rangeUpgrade;
                    if(meta == 8 && block1)
                        efficiencyUpgrade += ConfigHandler.efficiencyUpgrade;
                    if(meta == 2 && block2)
                        powerUpgrade += ConfigHandler.powerUpgrade;
                } else if(direction.equals(ForgeDirection.SOUTH))
                {
                    if(meta == 4 && block1)
                        rangeUpgrade += ConfigHandler.rangeUpgrade;
                    if(meta == 10 && block1)
                        efficiencyUpgrade += ConfigHandler.efficiencyUpgrade;
                    if(meta == 4 && block2)
                        powerUpgrade += ConfigHandler.powerUpgrade;
                }

            }
        }
    }

    public int getDurationForAspect(Aspect aspect)
    {
        if(aspect == AIR)
            return ConfigHandler.effectAIRUses;
        else if(aspect == WATER)
            return ConfigHandler.effectWATERUses;
        else if(aspect == FIRE)
            return ConfigHandler.effectFIREUses;
        else if(aspect == ENTROPY)
            return ConfigHandler.effectENTROPYUses;
        else if(aspect == WEATHER)
            return ConfigHandler.effectWEATHERUses;
        else if(aspect == MOTION)
            return ConfigHandler.effectMOTIONUses;
        else if(aspect == LIFE)
            return ConfigHandler.effectLIFEUses;
        else if(aspect == POISON)
            return ConfigHandler.effectPOISONUses;
        else if(aspect == ENERGY)
            return ConfigHandler.effectENERGYUses;
        else if(aspect == FLIGHT)
            return ConfigHandler.effectFLIGHTUses;
        else if(aspect == DARKNESS)
            return ConfigHandler.effectDARKNESSUses;
        else if(aspect == HEAL)
            return ConfigHandler.effectHEALUses;
        else if(aspect == SLIME)
            return ConfigHandler.effectSLIMEUses;
        else if(aspect == TRAP)
            return ConfigHandler.effectTRAPUses;
        else
            return 0;
    }

    @SideOnly(Side.CLIENT)
    public void spawnParticles()
    {
        if(ticksTillRefresh > 0)
        {
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            isWorking = true;
            int color = currentAspect.getColor();
            if(this.facing == 2 || this.facing == 3)
            {
                EntityFX particle1 = new EntityFX(worldObj, xCoord + 2 - Math.random(), yCoord + .2, zCoord + Math.random(), 0.0, Math.random() - .5, 0.0);
                EntityFX particle2 = new EntityFX(worldObj, xCoord - 2 + Math.random(), yCoord + .2, zCoord + Math.random(), 0.0, Math.random() - .5, 0.0);
                particle1.setRBGColorF(HexToRGB.HexToRedF(Integer.toHexString(color)), HexToRGB.HexToBlueF(Integer.toHexString(color)), HexToRGB.HexToGreenF(Integer.toHexString(color)));
                particle2.setRBGColorF(HexToRGB.HexToRedF(Integer.toHexString(color)), HexToRGB.HexToBlueF(Integer.toHexString(color)), HexToRGB.HexToGreenF(Integer.toHexString(color)));
                particle1.setParticleTextureIndex(133);
                particle2.setParticleTextureIndex(133);
                FMLClientHandler.instance().getClient().effectRenderer.addEffect(particle1);
                FMLClientHandler.instance().getClient().effectRenderer.addEffect(particle2);
            } else
            {
                EntityFX particle1 = new EntityFX(worldObj, xCoord + Math.random(), yCoord + .2, zCoord + 2 - Math.random(), 0.0, Math.random() - .5, 0.0);
                EntityFX particle2 = new EntityFX(worldObj, xCoord + Math.random(), yCoord + .2, zCoord - 1 + Math.random(), 0.0, Math.random() - .5, 0.0);
                particle1.setRBGColorF(HexToRGB.HexToRedF(Integer.toHexString(color)), HexToRGB.HexToBlueF(Integer.toHexString(color)), HexToRGB.HexToGreenF(Integer.toHexString(color)));
                particle2.setRBGColorF(HexToRGB.HexToRedF(Integer.toHexString(color)), HexToRGB.HexToBlueF(Integer.toHexString(color)), HexToRGB.HexToGreenF(Integer.toHexString(color)));
                particle1.setParticleTextureIndex(133);
                particle2.setParticleTextureIndex(133);
                FMLClientHandler.instance().getClient().effectRenderer.addEffect(particle1);
                FMLClientHandler.instance().getClient().effectRenderer.addEffect(particle2);
            }
        } else
        {
            isWorking = false;
        }
    }


    public void functionAIR()
    {
        List<EntityLivingBase> entityLiving = ObjectFinder.getLivingEntitiesInRange(worldObj, xCoord, yCoord, zCoord, rangeUpgrade + ConfigHandler.effectAIRRangeBoost, rangeUpgrade + ConfigHandler.effectAIRRangeBoost);
        if(refresh == ConfigHandler.effectAIRRefreshTime)
        {
            for(EntityLivingBase living : entityLiving)
            {
                if(living != null)
                {
                    living.addPotionEffect(new PotionEffect(Potion.jump.getId(), ConfigHandler.effectAIRTime, (int) (ConfigHandler.effectAIRBasePower * powerUpgrade), true));
                    living.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), ConfigHandler.effectAIRTime, (int) (ConfigHandler.effectAIRBasePower * powerUpgrade), true));
                    refresh = 0;
                    ticksTillRefresh--;
                }
            }
        } else
        {
            refresh++;
        }
    }

    public void functionWATER()
    {
        List<EntityLivingBase> entityLiving = ObjectFinder.getLivingEntitiesInRange(worldObj, xCoord, yCoord, zCoord, rangeUpgrade + ConfigHandler.effectWATERRangeBoost, rangeUpgrade + ConfigHandler.effectWATERRangeBoost);
        if(refresh == ConfigHandler.effectWATERRefreshTime)
        {
            for(EntityLivingBase living : entityLiving)
            {
                if(living != null)
                {
                    living.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), ConfigHandler.effectWATERTime, (int) (ConfigHandler.effectWATERBasePower * powerUpgrade), true));
                    refresh = 0;
                    ticksTillRefresh--;
                }
            }
        } else
        {
            refresh++;
        }
    }

    public void functionFIRE()
    {
        List<EntityLivingBase> entity = ObjectFinder.getLivingEntitiesInRange(worldObj, xCoord, yCoord, zCoord, rangeUpgrade + ConfigHandler.effectFIRERangeBoost, rangeUpgrade + ConfigHandler.effectFIRERangeBoost);
        if(refresh == ConfigHandler.effectFIRERefreshTime)
        {
            for(EntityLivingBase living : entity)
            {
                if(living != null)
                {
                    living.setFire(ConfigHandler.effectFIRETime);
                    refresh = 0;
                    ticksTillRefresh--;
                }
            }
        } else
        {
            refresh++;
        }
    }

    public void functionENTROPY()
    {
        List<EntityPlayer> entityPlayer = ObjectFinder.getPlayersInRange(worldObj, xCoord, yCoord, zCoord, rangeUpgrade + ConfigHandler.effectENTROPYRangeBoost, rangeUpgrade + ConfigHandler.effectENTROPYRangeBoost);
        if(refresh == ConfigHandler.effectENTROPYRefreshTime)
        {
            for(EntityPlayer living : entityPlayer)
            {
                if(!living.capabilities.isCreativeMode)
                    living.addPotionEffect(new PotionEffect(ModPotions.perditio.getId(), ConfigHandler.effectENTROPYTime, (int) (ConfigHandler.effectENTROPYBasePower * powerUpgrade), true));
                refresh = 0;
                ticksTillRefresh--;
            }
        } else
        {
            refresh++;
        }
    }

    public void functionWEATHER()
    {
        List<EntityLivingBase> entityLiving = ObjectFinder.getLivingEntitiesInRange(worldObj, xCoord, yCoord, zCoord, rangeUpgrade + ConfigHandler.effectWEATHERRangeBoost, rangeUpgrade + ConfigHandler.effectWEATHERRangeBoost);
        if(refresh == ConfigHandler.effectWEATHERRefreshTime)
        {
            for(EntityLivingBase living : entityLiving)
            {
                if(living != null)
                {
                    worldObj.addWeatherEffect(new EntityLightningBolt(worldObj, living.posX, living.posY, living.posZ));
                    refresh = 0;
                    ticksTillRefresh--;
                }
            }
        } else
        {
            refresh++;
        }
    }

    public void functionMOTION()
    {
        List<EntityLivingBase> entityLiving = ObjectFinder.getLivingEntitiesInRange(worldObj, xCoord, yCoord, zCoord, rangeUpgrade + ConfigHandler.effectMOTIONRangeBoost, rangeUpgrade + ConfigHandler.effectMOTIONRangeBoost);
        if(refresh == ConfigHandler.effectMOTIONRefreshTime)
        {
            for(EntityLivingBase living : entityLiving)
            {
                if(living != null)
                {
                    living.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), ConfigHandler.effectMOTIONTime, (int) (ConfigHandler.effectMOTIONBasePower * powerUpgrade), true));
                    refresh = 0;
                    ticksTillRefresh--;
                }
            }
        } else
        {
            refresh++;
        }
    }


    public void functionLIFE()
    {
        List<EntityLivingBase> entityLiving = ObjectFinder.getLivingEntitiesInRange(worldObj, xCoord, yCoord, zCoord, rangeUpgrade + ConfigHandler.effectLIFERangeBoost, rangeUpgrade + ConfigHandler.effectLIFERangeBoost);
        if(refresh == ConfigHandler.effectLIFERefreshTime)
        {
            for(EntityLivingBase living : entityLiving)
            {
                if(living != null)
                {
                    living.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), ConfigHandler.effectLIFETime, (int) (ConfigHandler.effectLIFEBasePower * powerUpgrade), false));
                    refresh = 0;
                    ticksTillRefresh--;
                }
            }
        } else
        {
            refresh++;
        }
    }

    public void functionPOISON()
    {
        List<EntityLivingBase> entityLiving = ObjectFinder.getLivingEntitiesInRange(worldObj, xCoord, yCoord, zCoord, rangeUpgrade + ConfigHandler.effectPOISONRangeBoost, rangeUpgrade + ConfigHandler.effectPOISONRangeBoost);
        if(refresh == ConfigHandler.effectPOISONRefreshTime)
        {
            for(EntityLivingBase living : entityLiving)
            {
                if(living != null)
                {
                    living.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), ConfigHandler.effectPOISONTime, (int) (ConfigHandler.effectPOISONBasePower * powerUpgrade), true));
                    refresh = 0;
                    ticksTillRefresh--;
                }
            }
        } else
        {
            refresh++;
        }
    }

    public void functionENERGY()
    {
        List<EntityLivingBase> entityLiving = ObjectFinder.getLivingEntitiesInRange(worldObj, xCoord, yCoord, zCoord, rangeUpgrade + ConfigHandler.effectENERGYRangeBoost, rangeUpgrade + ConfigHandler.effectENERGYRangeBoost);
        if(refresh == ConfigHandler.effectENERGYRefreshTime)
        {
            for(EntityLivingBase living : entityLiving)
            {
                if(living != null)
                {
                    living.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), ConfigHandler.effectENERGYTime, (int) (ConfigHandler.effectENERGYBasePower * powerUpgrade), true));
                    refresh = 0;
                    ticksTillRefresh--;
                }
            }
        } else
        {
            refresh++;
        }
    }

    public void functionFLIGHT()
    {

        List<EntityLivingBase> entityLiving = ObjectFinder.getLivingEntitiesInRange(worldObj, xCoord, yCoord, zCoord, rangeUpgrade + ConfigHandler.effectFLIGHTRangeBoost, rangeUpgrade + ConfigHandler.effectFLIGHTRangeBoost);
        if(refresh == ConfigHandler.effectFLIGHTRefreshTime)
        {
            for(EntityLivingBase living : entityLiving)
            {
                if(living != null)
                {
                    living.addPotionEffect(new PotionEffect(ModPotions.volatus.getId(), ConfigHandler.effectFLIGHTTime, (int) (ConfigHandler.effectFLIGHTBasePower * powerUpgrade), false));
                    refresh = 0;
                    ticksTillRefresh--;
                }
            }
        } else
        {
            refresh++;
        }
    }

    public void functionDARKNESS()
    {
        List<EntityPlayer> entityPlayer = ObjectFinder.getPlayersInRange(worldObj, xCoord, yCoord, zCoord, rangeUpgrade + ConfigHandler.effectDARKNESSRangeBoost, rangeUpgrade + ConfigHandler.effectDARKNESSRangeBoost);
        if(refresh == ConfigHandler.effectDARKNESSRefreshTime)
        {
            for(EntityPlayer living : entityPlayer)
            {
                if(living != null && !living.capabilities.isCreativeMode)
                {
                    living.addPotionEffect(new PotionEffect(Potion.blindness.getId(), ConfigHandler.effectDARKNESSTime, (int) (ConfigHandler.effectDARKNESSBasePower * powerUpgrade), false));
                    refresh = 0;
                    ticksTillRefresh--;
                }
            }
        } else
        {
            refresh++;
        }
    }

    public void functionHEAL()
    {
        List<EntityLivingBase> entityLiving = ObjectFinder.getLivingEntitiesInRange(worldObj, xCoord, yCoord, zCoord, rangeUpgrade + ConfigHandler.effectHEALRangeBoost, rangeUpgrade + ConfigHandler.effectHEALRangeBoost);
        if(refresh == ConfigHandler.effectHEALRefreshTime)
        {
            for(EntityLivingBase living : entityLiving)
            {
                if(living != null)
                {
                    living.addPotionEffect(new PotionEffect(Potion.heal.getId(), ConfigHandler.effectHEALTime, (int) (ConfigHandler.effectHEALBasePower * powerUpgrade), true));
                    refresh = 0;
                    ticksTillRefresh--;
                }
            }
        } else
        {
            refresh++;
        }
    }

    public void functionSLIME()
    {
        List<EntityLivingBase> entityLiving = ObjectFinder.getLivingEntitiesInRange(worldObj, xCoord, yCoord, zCoord, rangeUpgrade + ConfigHandler.effectSLIMERangeBoost, rangeUpgrade + ConfigHandler.effectSLIMERangeBoost);
        if(refresh == ConfigHandler.effectSLIMERefreshTime)
        {
            for(EntityLivingBase living : entityLiving)
            {
                if(living != null)
                {
                    living.addPotionEffect(new PotionEffect(ModPotions.limus.getId(), ConfigHandler.effectSLIMETime, (int) (ConfigHandler.effectSLIMEBasePower * powerUpgrade), true));
                    refresh = 0;
                    ticksTillRefresh--;
                }
            }
        } else
        {
            refresh++;
        }
    }

    public void functionTAINT()
    {
        List<EntityPlayer> entityPlayer = ObjectFinder.getPlayersInRange(worldObj, xCoord, yCoord, zCoord, rangeUpgrade, rangeUpgrade);
        if(refresh == 20)
        {
            for(EntityPlayer living : entityPlayer)
            {
                if(living != null && !living.capabilities.isCreativeMode)
                {

                    refresh = 0;
                    ticksTillRefresh--;
                }
            }
        } else
        {
            refresh++;
        }
    }

    public void functionTRAP()
    {
        List<EntityLivingBase> entityLiving = ObjectFinder.getLivingEntitiesInRange(worldObj, xCoord, yCoord, zCoord, rangeUpgrade + ConfigHandler.effectTRAPRangeBoost, rangeUpgrade + ConfigHandler.effectTRAPRangeBoost);
        if(refresh == ConfigHandler.effectTRAPRefreshTime)
        {
            for(EntityLivingBase living : entityLiving)
            {
                if(living != null)
                {
                    living.addPotionEffect(new PotionEffect(ModPotions.vinculum.getId(), ConfigHandler.effectTRAPTime, (int) (ConfigHandler.effectTRAPBasePower * powerUpgrade), true));
                    refresh = 0;
                    ticksTillRefresh--;
                }
            }
        } else
        {
            refresh++;
        }
    }


}