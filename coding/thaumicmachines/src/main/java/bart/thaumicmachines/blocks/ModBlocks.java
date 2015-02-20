package bart.thaumicmachines.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * Created by imdutch21 on 13-2-15.
 */
public class ModBlocks
{
    public static Block essentiaMachine;
    public static Block machineUpgrade;
    public static Block machineUpgrade2;

    public static void init()
    {
        essentiaMachine = new EssentiaMachine();
        GameRegistry.registerBlock(essentiaMachine, "essentiaMachine");
        machineUpgrade = new BlockMachineUpgrade().setBlockName("machineUpgrade");
        GameRegistry.registerBlock(machineUpgrade, BlockMachineUpgradeMeta.class, machineUpgrade.getUnlocalizedName());
        machineUpgrade2 = new BlockMachineUpgrade2().setBlockName("machineUpgrade2");
        GameRegistry.registerBlock(machineUpgrade2, BlockMachineUpgradeMeta2.class, machineUpgrade2.getUnlocalizedName());
    }

}
