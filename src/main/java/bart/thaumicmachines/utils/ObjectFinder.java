package bart.thaumicmachines.utils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imdutch21 on 14-2-15.
 */
public class ObjectFinder
{

    public static List<Entity> getEntitiesInRange(World world, double posX, double posY, double posZ, double horizontalRadius, double verticalRadius)
    {
        return world.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox(posX - 0.5f, posY - 0.5f, posZ - 0.5f, posX + 0.5f, posY + 0.5f, posZ + 0.5f).expand(horizontalRadius, verticalRadius, horizontalRadius));
    }
    public static List<EntityLivingBase> getLivingEntitiesInRange(World world, double posX, double posY, double posZ, double horizontalRadius, double verticalRadius)
    {
        return world.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(posX - 0.5f, posY - 0.5f, posZ - 0.5f, posX + 0.5f, posY + 0.5f, posZ + 0.5f).expand(horizontalRadius, verticalRadius, horizontalRadius));
    }
    public static List<EntityItem> getItemsInRange(World world, double posX, double posY, double posZ, double horizontalRadius, double verticalRadius)
    {
        return world.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(posX - 0.5f, posY - 0.5f, posZ - 0.5f, posX + 0.5f, posY + 0.5f, posZ + 0.5f).expand(horizontalRadius, verticalRadius, horizontalRadius));
    }
    public static List<EntityPlayer> getPlayersInRange(World world, double posX, double posY, double posZ, double horizontalRadius, double verticalRadius)
    {
        return world.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(posX - 0.5f, posY - 0.5f, posZ - 0.5f, posX + 0.5f, posY + 0.5f, posZ + 0.5f).expand(horizontalRadius, verticalRadius, horizontalRadius));
    }
    public static List<Block> getBlocksInRange(World world, int posX, int posY, int posZ, int horizontalRadius, int verticalRadius)
    {
        int lowest = posY - verticalRadius;
        int highest = posY + verticalRadius;
        int xMin = posX - horizontalRadius;
        int xMax = posX + horizontalRadius;
        int zMin = posZ - horizontalRadius;
        int zMax = posZ + horizontalRadius;
        ArrayList<Block> arraylist = new ArrayList<Block>();

        for(int y = lowest; y <= highest; y++)
        {
            for(int x = xMin; x <= xMax; x++)
            {
                for(int z = zMin; z <= zMax; z++)
                {
                    if(world.getBlock(x, y, z) != null && !(world.getBlock(x, y, z) instanceof BlockAir))
                    {
                        arraylist.add(world.getBlock(x, y, z));
                    }
                }
            }
        }
        return arraylist;
    }
}
