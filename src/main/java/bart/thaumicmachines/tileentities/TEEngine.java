package bart.thaumicmachines.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import thaumcraft.api.aspects.Aspect;

/**
 * Created by Bart on 11-5-2015.
 */
public class TEEngine extends TileEntity
{
    public Aspect currentAspect = null;
    public int color = (currentAspect != null? currentAspect.getColor():0x818181);

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        if(currentAspect.getName() != null)
            nbt.setString("aspect", currentAspect.getName());
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        if(nbt.getString("aspect") != null)
            currentAspect = Aspect.getAspect(nbt.getString("aspect"));
    }
}
