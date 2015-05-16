package bart.thaumicmachines.blocks;

import bart.thaumicmachines.AddonMain;
import bart.thaumicmachines.lib.References;
import bart.thaumicmachines.tileentities.TEEngine;
import bart.thaumicmachines.utils.HexToRGB;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;

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

    @Override
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        System.out.println(HexToRGB.HexToRedF(Integer.toHexString(Aspect.AIR.getColor())) + "," + HexToRGB.HexToBlueF(Integer.toHexString(Aspect.AIR.getColor())) + "," +  HexToRGB.HexToGreenF(Integer.toHexString(Aspect.AIR.getColor())));
        return true;
    }
}

