package bart.thaumicmachines.research;

import bart.thaumicmachines.blocks.EssentiaMachine;
import bart.thaumicmachines.blocks.ModBlocks;
import bart.thaumicmachines.lib.handler.ConfigHandler;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ItemApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;

/**
 * Created by imdutch21 on 18-2-15.
 */
public class ThaumicMachinesRecipes
{
    public static InfusionRecipe recipeEssentiaVaporizer;
    public static CrucibleRecipe recipePowerUpgrade;
    public static CrucibleRecipe recipeRangeUpgrade;
    public static CrucibleRecipe recipeEfficiencyUpgrade;

    public static void Recipes()
    {
        ItemStack thaumium = ItemApi.getItem("itemResource", 2);
        ItemStack upgradeAir = ItemApi.getItem("itemGolemUpgrade", 0);
        ItemStack upgradeEarth = ItemApi.getItem("itemGolemUpgrade", 1);
        ItemStack upgradeFire = ItemApi.getItem("itemGolemUpgrade", 2);
        ItemStack upgradeWater = ItemApi.getItem("itemGolemUpgrade", 0);
        ItemStack upgradeOrder = ItemApi.getItem("itemGolemUpgrade", 1);
        ItemStack upgradeEntropy = ItemApi.getItem("itemGolemUpgrade", 2);
        ItemStack visFilter = ItemApi.getItem("itemResource", 8);

        if (ConfigHandler.enableEssentiaVaporizer && thaumium != null && visFilter != null)
            recipeEssentiaVaporizer = new InfusionRecipe("EssentiaVaporizer", new ItemStack(ModBlocks.essentiaMachine), 1, new AspectList().add(Aspect.MAGIC, 20).add(Aspect.MECHANISM, 32).add(Aspect.FIRE, 20), new ItemStack(Blocks.iron_block), new ItemStack[]{thaumium, thaumium, thaumium, thaumium, visFilter, new ItemStack(Blocks.iron_bars), new ItemStack(Blocks.iron_bars)});
        if(ConfigHandler.enablePowerUpgrade && upgradeEarth != null)
            recipePowerUpgrade = new CrucibleRecipe("PowerUpgrade", new ItemStack(ModBlocks.machineUpgrade2, 0), upgradeEarth, new AspectList().add(Aspect.MAGIC, 4).add(Aspect.MECHANISM, 10).add(Aspect.EARTH, 3));
        if(ConfigHandler.enableRangeUpgrade && upgradeWater != null)
            recipeRangeUpgrade = new CrucibleRecipe("RangeUpgrade", new ItemStack(ModBlocks.machineUpgrade, 0), upgradeWater, new AspectList().add(Aspect.MAGIC, 4).add(Aspect.MECHANISM, 10).add(Aspect.WATER, 3));
        if(ConfigHandler.enableEfficiencyUpgrade && upgradeAir != null)
            recipeEfficiencyUpgrade = new CrucibleRecipe("EfficiencyUpgrade", new ItemStack(ModBlocks.machineUpgrade, 12), upgradeAir, new AspectList().add(Aspect.MAGIC, 4).add(Aspect.MECHANISM, 10).add(Aspect.AIR, 3));
    }
}
