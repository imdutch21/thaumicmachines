package bart.thaumicmachines.blocks;

import bart.thaumicmachines.AddonMain;
import bart.thaumicmachines.lib.References;
import bart.thaumicmachines.tileentities.TEEssentiaMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by imdutch21 on 14-2-15.
 */
public class EssentiaMachine extends Block implements ITileEntityProvider
{

    public IIcon top;
    public IIcon bottom;
    public IIcon front;
    public IIcon sides;
    public IIcon sides_active;

    protected EssentiaMachine()
    {
        super(Material.anvil);
        this.setCreativeTab(AddonMain.getCreativeTab());
        this.setHardness(4f);
        this.setBlockName(References.MODID + ".essentiamachine");

    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new TEEssentiaMachine();
    }

    @Override
    public boolean hasTileEntity(int meta)
    {
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
    {
        int facing = MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
        TEEssentiaMachine tile = (TEEssentiaMachine) world.getTileEntity(x, y, z);
        if (facing == 0)
            tile.facing = 2;
        else if (facing == 1)
            tile.facing = 5;
        else if (facing == 2)
            tile.facing = 3;
        else if (facing == 3)
            tile.facing = 4;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.front = iconRegister.registerIcon(References.RESOURCESPREFIX + "essentiamachine_front");
        this.top = iconRegister.registerIcon(References.RESOURCESPREFIX + "essentiamachine_top");
        this.bottom = iconRegister.registerIcon(References.RESOURCESPREFIX + "essentiamachine_bottom");
        this.sides = iconRegister.registerIcon(References.RESOURCESPREFIX + "essentiamachine_side_inactive");
        this.sides_active = iconRegister.registerIcon(References.RESOURCESPREFIX + "essentiamachine_side_active");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess access, int x, int y, int z, int side)
    {

        TEEssentiaMachine tile = (TEEssentiaMachine) access.getTileEntity(x, y, z);
        if (side == 0)
        {
            return this.bottom;
        } else if (side == 1)
        {
            return this.top;
        } else if ((side == 2 && tile.facing == 3) || (side == 3 && tile.facing == 2) || (side == 5 && tile.facing == 4) || (side == 4 && tile.facing == 5))
        {
            return this.front;
        } else if (side != tile.facing)
        {
            return (tile.isWorking ? this.sides_active : this.sides);
        } else
        {
            return this.front;
        }
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        if (side == 0)
            return this.bottom;
        else if (side == 1)
            return this.top;
        else if (side == 3 || side == 2)
            return this.front;
        else
            return this.sides;
    }
}
