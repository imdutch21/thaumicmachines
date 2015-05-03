package bart.thaumicmachines.blocks;

import bart.thaumicmachines.AddonMain;
import bart.thaumicmachines.lib.References;
import bart.thaumicmachines.tileentities.TEEssentiaMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.common.util.RotationHelper;

import java.util.List;
import java.util.Random;

/**
 * Created by imdutch21 on 16-2-15.
 */
public class BlockMachineUpgrade extends Block
{
    public IIcon efficiency;
    public IIcon range;

    public BlockMachineUpgrade()
    {
        super(Material.anvil);
        this.setCreativeTab(AddonMain.getCreativeTab());
        this.setBlockTextureName(References.RESOURCESPREFIX + "testthing");
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int x, int y, int z)
    {
        switch (iBlockAccess.getBlockMetadata(x, y, z))
        {
            //down
            case 0:
            case 6:
            {
                this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 0.125F, 0.875F);
                break;
            }
            //up
            case 1:
            case 7:
            {
                this.setBlockBounds(0.125F, 0.875F, 0.125F, 0.875F, 1.0F, 0.875F);
                break;
            }
            //north
            case 2:
            case 8:
            {
                this.setBlockBounds(0.125F, 0.125F, 0.0F, 0.875F, 0.875F, 0.125F);
                break;
            }
            //east
            case 3:
            case 9:
            {
                this.setBlockBounds(0.0F, 0.125F, 0.125F, 0.125F, 0.875F, 0.875F);
                break;
            }
            //south
            case 4:
            case 10:
            {
                this.setBlockBounds(0.125F, 0.125F, 0.875F, 0.875F, 0.875F, 1.0F);
                break;
            }
            //west
            case 5:
            case 11:
            {
                this.setBlockBounds(0.875F, 0.125F, 0.125F, 1.0F, 0.875F, 0.875F);
                break;
            }
            default:
                this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 0.125F, 0.875F);
        }
    }




    @SuppressWarnings({"unchecked", "rawtypes"})
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item id, CreativeTabs tab, List list)
    {

        list.add(new ItemStack(id, 1, 0));
        list.add(new ItemStack(id, 1, 6));
    }

    @Override
    public Item getItemDropped(int quantity, Random rand, int meta)
    {
        switch (meta)
        {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return new ItemStack(ModBlocks.machineUpgrade, 1, 0).getItem();
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return new ItemStack(ModBlocks.machineUpgrade, 1, 6).getItem();
        }
        return null;
    }

    public boolean isValidPlace(World world, int x, int y, int z)
    {
        //checks if the block is on the right position based on the meta
        int meta = world.getBlockMetadata(x, y, z);
        return ((meta == 0 || meta == 6 ) && world.getBlock(x, y - 1, z) instanceof EssentiaMachine) || ((meta == 1 || meta == 7 ) && world.getBlock(x, y + 1, z) instanceof EssentiaMachine) || ((meta == 2 || meta == 8 ) && world.getBlock(x, y, z - 1) instanceof EssentiaMachine) || ((meta == 3 || meta == 9 ) && world.getBlock(x - 1, y, z) instanceof EssentiaMachine) || ((meta == 4 || meta == 10 ) && world.getBlock(x, y, z + 1) instanceof EssentiaMachine) || ((meta == 5 || meta == 11 ) && world.getBlock(x + 1, y, z) instanceof EssentiaMachine);
    }


    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        if (!isValidPlace(world, x, y, z))
        {
            int meta = world.getBlockMetadata(x, y, z);
            if (meta <= 5)
            {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            } else if (meta <= 11)
            {
                this.dropBlockAsItem(world, x, y, z, 6, 0);
                world.setBlockToAir(x, y, z);
            }
        }
    }

    @Override
    public int damageDropped(int meta)
    {
        return meta;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta)
    {

        if (meta <= 5 )
        {
            if (side == 1 && world.getBlock(x, y - 1, z) instanceof EssentiaMachine)
                return 0;
            else if (side == 0 && world.getBlock(x, y + 1, z) instanceof EssentiaMachine)
                return 1;
            else if (side == 3 && world.getBlock(x, y, z - 1) instanceof EssentiaMachine)
                return 2;
            else if (side == 5 && world.getBlock(x - 1, y, z) instanceof EssentiaMachine)
                return 3;
            else if (side == 2 && world.getBlock(x, y, z + 1) instanceof EssentiaMachine)
                return 4;
            else if (side == 4 && world.getBlock(x + 1, y, z) instanceof EssentiaMachine)
                return 5;
            else if (world.getBlock(x, y - 1, z) instanceof EssentiaMachine)
                return 0;
            else if (world.getBlock(x, y + 1, z) instanceof EssentiaMachine)
                return 1;
            else if (world.getBlock(x, y, z - 1) instanceof EssentiaMachine)
                return 2;
            else if (world.getBlock(x - 1, y, z) instanceof EssentiaMachine)
                return 3;
            else if (world.getBlock(x, y, z + 1) instanceof EssentiaMachine)
                return 4;
            else if (world.getBlock(x + 1, y, z) instanceof EssentiaMachine)
                return 5;
        } else if (meta >= 6 && meta <= 11 )
        {
            if (side == 1 && world.getBlock(x, y - 1, z) instanceof EssentiaMachine)
                return 6;
            else if (side == 0 && world.getBlock(x, y + 1, z) instanceof EssentiaMachine)
                return 7;
            else if (side == 3 && world.getBlock(x, y, z - 1) instanceof EssentiaMachine)
                return 8;
            else if (side == 5 && world.getBlock(x - 1, y, z) instanceof EssentiaMachine)
                return 9;
            else if (side == 2 && world.getBlock(x, y, z + 1) instanceof EssentiaMachine)
                return 10;
            else if (side == 4 && world.getBlock(x + 1, y, z) instanceof EssentiaMachine)
                return 11;
            else if (world.getBlock(x, y - 1, z) instanceof EssentiaMachine)
                return 6;
            else if (world.getBlock(x, y + 1, z) instanceof EssentiaMachine)
                return 7;
            else if (world.getBlock(x, y, z - 1) instanceof EssentiaMachine)
                return 8;
            else if (world.getBlock(x - 1, y, z) instanceof EssentiaMachine)
                return 9;
            else if (world.getBlock(x, y, z + 1) instanceof EssentiaMachine)
                return 10;
            else if (world.getBlock(x + 1, y, z) instanceof EssentiaMachine)
                return 11;
        }

        return meta;
    }

    @Override
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 0.125F, 0.875F);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return (world.getBlock(x, y, z).isReplaceable(world, x, y, z) && (world.getBlock(x , y -1, z) instanceof EssentiaMachine || world.getBlock(x , y + 1, z) instanceof EssentiaMachine ||world.getBlock(x + 1, y, z) instanceof EssentiaMachine || world.getBlock(x - 1, y, z) instanceof EssentiaMachine || world.getBlock(x, y, z + 1) instanceof EssentiaMachine || world.getBlock(x, y, z - 1) instanceof EssentiaMachine));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.efficiency = iconRegister.registerIcon(References.RESOURCESPREFIX + "upgradeefficiency");
        this.range = iconRegister.registerIcon(References.RESOURCESPREFIX + "upgraderange");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess access, int x, int y, int z, int side)
    {
        int meta = access.getBlockMetadata(x, y, z);
        if (meta <= 5)
            return this.range;
        else
            return this.efficiency;
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        if (meta <= 5)
            return this.range;
        else
            return this.efficiency;
    }
}
