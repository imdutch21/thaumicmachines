package bart.thaumicmachines.core.proxy;

import bart.thaumicmachines.tileentities.TEEssentiaMachine;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by imdutch21 on 13-2-15.
 */
public class CommonProxy
{
    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TEEssentiaMachine.class, "teessentiamachine");
    }
}
