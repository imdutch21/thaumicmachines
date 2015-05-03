package bart.thaumicmachines.utils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockLever;
import net.minecraft.world.World;

/**
 * Created by Bart on 3-5-2015.
 */
public class ActivatingBlocks
{
    public static void ActivateLever(Block block, World world, int x, int y, int z)
    {
        if(block instanceof BlockLever)
        {
            int i1 = world.getBlockMetadata(x, y, z);
            int j1 = i1 & 7;
            int k1 = 8 - (i1 & 8);
            world.setBlockMetadataWithNotify(x, y, z, j1 + k1, 3);
            world.playSoundEffect((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "random.click", 0.3F, k1 > 0 ? 0.6F : 0.5F);
            world.notifyBlocksOfNeighborChange(x, y, z, block);

            if(j1 == 1)
            {
                world.notifyBlocksOfNeighborChange(x - 1, y, z, block);
            } else if(j1 == 2)
            {
                world.notifyBlocksOfNeighborChange(x + 1, y, z, block);
            } else if(j1 == 3)
            {
                world.notifyBlocksOfNeighborChange(x, y, z - 1, block);
            } else if(j1 == 4)
            {
                world.notifyBlocksOfNeighborChange(x, y, z + 1, block);
            } else if(j1 != 5 && j1 != 6)
            {
                if(j1 == 0 || j1 == 7)
                {
                    world.notifyBlocksOfNeighborChange(x, y + 1, z, block);
                }
            } else
            {
                world.notifyBlocksOfNeighborChange(x, y - 1, z, block);
            }
        }
    }

    public static void ActivateButton(Block block, World world, int x, int y, int z)
    {
        int i1 = world.getBlockMetadata(x, y, z);
        int j1 = i1 & 7;
        int k1 = 8 - (i1 & 8);

        world.setBlockMetadataWithNotify(x, y, z, j1 + k1, 3);
        world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
        world.playSoundEffect((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "random.click", 0.3F, 0.6F);
        world.notifyBlocksOfNeighborChange(x, y, z, block);

        if(i1 == 1)
        {
            world.notifyBlocksOfNeighborChange(x - 1, y, z, block);
        } else if(i1 == 2)
        {
            world.notifyBlocksOfNeighborChange(x + 1, y, z, block);
        } else if(i1 == 3)
        {
            world.notifyBlocksOfNeighborChange(x, y, z - 1, block);
        } else if(i1 == 4)
        {
            world.notifyBlocksOfNeighborChange(x, y, z + 1, block);
        } else
        {
            world.notifyBlocksOfNeighborChange(x, y - 1, z, block);
        }
        world.scheduleBlockUpdate(x, y, z, block, block.tickRate(world));


    }
}
