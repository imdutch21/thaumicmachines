package bart.thaumicmachines.core.proxy;

import bart.thaumicmachines.client.renderer.RendererEngine;
import bart.thaumicmachines.client.renderer.RendererTileEngine;
import bart.thaumicmachines.tileentities.TEEngine;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Created by imdutch21 on 13-2-15.
 */
public class ClientProxy extends CommonProxy
{
    public void registerRenderInformation()
    {
        super.registerRenderInformation();
        RenderingRegistry.registerBlockHandler(new RendererEngine());

        ClientRegistry.bindTileEntitySpecialRenderer(TEEngine.class, new RendererTileEngine());
    }
}
