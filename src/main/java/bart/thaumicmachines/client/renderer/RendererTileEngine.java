package bart.thaumicmachines.client.renderer;

import bart.thaumicmachines.lib.References;
import bart.thaumicmachines.tileentities.TEEngine;
import bart.thaumicmachines.utils.HexToRGB;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import thaumcraft.api.aspects.Aspect;

/**
 * Created by Bart on 11-5-2015.
 */
public class RendererTileEngine extends TileEntitySpecialRenderer
{
    private static final ResourceLocation texture = new ResourceLocation(References.RESOURCESPREFIX + "textures/blocks/engine_most.png");
    private static final ResourceLocation texture2 = new ResourceLocation(References.RESOURCESPREFIX + "textures/blocks/engine_tip.png");

    private static final ModelEngine model = new ModelEngine();

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5F, y + 0.5F, z + 0.5F);
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        GL11.glTranslatef(-0.5F, -0.5F, -0.3F);
        model.render();
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5F, y + 0.5F, z + 0.5F);
        Minecraft.getMinecraft().renderEngine.bindTexture(texture2);
        GL11.glTranslatef(-0.5F, -0.5F, -0.3F);
        TEEngine tile = (TEEngine)te;
        String color = Integer.toHexString(tile.color);
        GL11.glColor3f(HexToRGB.HexToRedF(color), HexToRGB.HexToBlueF(color), HexToRGB.HexToGreenF(color));
        model.renderTip();
        GL11.glPopMatrix();
    }
}
