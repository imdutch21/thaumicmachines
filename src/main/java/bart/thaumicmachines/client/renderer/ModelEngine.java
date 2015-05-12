package bart.thaumicmachines.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

/**
 * NewProject - Undefined
 * Created using Tabula 4.1.1
 */
public class ModelEngine extends ModelBase
{
    public ModelRenderer Main;
    public ModelRenderer Tip;
    public ModelRenderer Nozzle1;
    public ModelRenderer Input;

    public ModelEngine()
    {
        this.textureWidth = 80;
        this.textureHeight = 80;
        this.Nozzle1 = new ModelRenderer(this, 0, 42);
        this.Nozzle1.setRotationPoint(6.0F, 6.0F, -2.0F);
        this.Nozzle1.addBox(0.0F, 0.0F, 0.0F, 4, 4, 2, 0.0F);
        this.Tip = new ModelRenderer(this, 0, 0);
        this.Tip.setRotationPoint(4.0F, 4.0F, 8.0F);
        this.Tip.addBox(0.0F, 0.0F, 0.0F, 8, 8, 5, 0.0F);
        this.Input = new ModelRenderer(this, 20, 30);
        this.Input.setRotationPoint(5.0F, 5.0F, -3.0F);
        this.Input.addBox(0.0F, 0.0F, 0.0F, 6, 6, 1, 0.0F);
        this.Main = new ModelRenderer(this, 0, 52);
        this.Main.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Main.addBox(0.0F, 0.0F, 0.0F, 16, 16, 8, 0.0F);
    }

    public void render()
    {
        float f = 1F / 16F;
        this.Nozzle1.render(f);

        this.Input.render(f);
        this.Main.render(f);
    }

    public void renderTip()
    {
        float f = 1F / 16F;
        this.Tip.render(f);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
