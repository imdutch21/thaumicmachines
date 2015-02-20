package bart.thaumicmachines.research;

import bart.thaumicmachines.blocks.ModBlocks;
import bart.thaumicmachines.lib.References;
import bart.thaumicmachines.lib.handler.ConfigHandler;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

/**
 * Created by imdutch21 on 17-2-15.
 */
public class Research
{

    public static ResourceLocation background = new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png");

    public static void init()
    {
        ThaumicMachinesRecipes.Recipes();

        ResearchCategories.registerCategory("ThaumicMachines", new ResourceLocation(References.MODID, "textures/blocks/essentiamachine_front.png"), background);
        if (ConfigHandler.enableEssentiaVaporizer)
        {
            ResearchItem researchEssentiaVaporizer = new ResearchItem("EssentiaVaporizer", "ThaumicMachines", new AspectList().add(Aspect.MAGIC, 6).add(Aspect.FIRE, 3).add(Aspect.MECHANISM, 5).add(Aspect.EXCHANGE, 2), 3, 0, 2, new ItemStack(ModBlocks.essentiaMachine)).setPages(new ResearchPage("thaumicmachines_researchpage_essentiavaporizer"), new ResearchPage(ThaumicMachinesRecipes.recipeEssentiaVaporizer)).setParents("CRUCIBLE", "THAUMIUM").setSiblings("PowerUpgrade", "EfficiencyUpgrade", "RangeUpgrade");
            ResearchCategories.addResearch(researchEssentiaVaporizer);
        }
        if (ConfigHandler.enablePowerUpgrade)
        {
            ResearchItem researchPowerUpgrade = new ResearchItem("PowerUpgrade", "ThaumicMachines", new AspectList().add(Aspect.EARTH, 5).add(Aspect.MAGIC, 3).add(Aspect.MECHANISM, 6), 7, 2, 1, new ItemStack(ModBlocks.machineUpgrade2, 0)).setRound().setSecondary().setPages(new ResearchPage("thaumicmachines_researchpage_powerupgrade"), new ResearchPage(ThaumicMachinesRecipes.recipePowerUpgrade)).setParents("EssentiaVaporizer", "UPGRADEEARTH" );
            ResearchCategories.addResearch(researchPowerUpgrade);
        }
        if (ConfigHandler.enableRangeUpgrade)
        {
            ResearchItem researchRangeUpgrade = new ResearchItem("RangeUpgrade", "ThaumicMachines", new AspectList().add(Aspect.WATER, 5).add(Aspect.MAGIC, 3).add(Aspect.MECHANISM, 6), 6, 0, 1, new ItemStack(ModBlocks.machineUpgrade, 0)).setRound().setSecondary().setPages(new ResearchPage("thaumicmachines_researchpage_rangeupgrade"), new ResearchPage(ThaumicMachinesRecipes.recipeRangeUpgrade)).setParents("EssentiaVaporizer", "UPGRADEWATER");
            ResearchCategories.addResearch(researchRangeUpgrade);
        }
        if (ConfigHandler.enableEfficiencyUpgrade)
        {
            ResearchItem researchEfficiencyUpgrade = new ResearchItem("EfficiencyUpgrade", "ThaumicMachines", new AspectList().add(Aspect.AIR, 5).add(Aspect.MAGIC, 3).add(Aspect.MECHANISM, 6), 7, -2, 1, new ItemStack(ModBlocks.machineUpgrade, 6)).setRound().setSecondary().setPages(new ResearchPage("thaumicmachines_researchpage_efficiencyupgrade"), new ResearchPage(ThaumicMachinesRecipes.recipeEfficiencyUpgrade)).setParents("EssentiaVaporizer", "UPGRADEAIR");
            ResearchCategories.addResearch(researchEfficiencyUpgrade);
        }
    }
}
