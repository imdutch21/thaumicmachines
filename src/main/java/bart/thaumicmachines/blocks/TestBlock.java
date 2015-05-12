package bart.thaumicmachines.blocks;

import bart.thaumicmachines.AddonMain;
import bart.thaumicmachines.lib.References;
import bart.thaumicmachines.tileentities.TEEngine;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Bart on 11-5-2015.
 */
public class TestBlock extends Block implements ITileEntityProvider
{

    public TestBlock()
    {
        super(Material.rock);
        this.setBlockName(References.MODID + ".baseBlock");
        this.setCreativeTab(AddonMain.getCreativeTab());
    }


    /*@SideOnly(Side.CLIENT)
    public int getRenderColor(int p_149741_1_)
    {
        return 0x3cd4fc;
    }

    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return 0x3cd4fc;
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
    {
        return 0x3cd4fc;
    }*/

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new TEEngine();
    }


}

