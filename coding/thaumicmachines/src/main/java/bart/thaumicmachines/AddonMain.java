package bart.thaumicmachines;

import bart.thaumicmachines.blocks.ModBlocks;
import bart.thaumicmachines.core.proxy.CommonProxy;
import bart.thaumicmachines.creativetab.AddonTab;
import bart.thaumicmachines.lib.References;
import bart.thaumicmachines.lib.handler.ConfigHandler;
import bart.thaumicmachines.potion.ModPotions;
import bart.thaumicmachines.potion.PotionHandler;
import bart.thaumicmachines.research.Research;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import thaumcraft.api.potions.PotionVisExhaust;

/**
 * Created by imdutch21 on 11-2-15.
 */
@Mod(modid = References.MODID, name = References.MODNAME, version = References.VERSION, dependencies = References.DEPENDENCIES)
public class AddonMain
{
    @Instance
    public static AddonMain instance;

    @SidedProxy(clientSide = References.CLIENTPROXYLOCATION, serverSide = References.COMMONPROXYLOCATION)
    public static CommonProxy proxy;

    private static CreativeTabs addonTab = new AddonTab(CreativeTabs.getNextID(), References.MODID);

    public static CreativeTabs getCreativeTab()
    {
        return addonTab;
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        System.out.println("ThaumicMachines PreInitialization");
        ModBlocks.init();
        ModPotions.init();
        ConfigHandler.Init(event.getSuggestedConfigurationFile());


        FMLCommonHandler.instance().bus().register(new ConfigHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("ThaumicMachines Initialization");
        proxy.registerTileEntities();


        MinecraftForge.EVENT_BUS.register(new PotionHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        Research.init();
    }

}
