package bart.thaumicmachines.blocks;

import bart.thaumicmachines.lib.References;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by imdutch21 on 16-2-15.
 */
public class BlockMachineUpgradeMeta extends ItemBlock
{
    public BlockMachineUpgradeMeta(Block block) {
        super(block);
        setHasSubtypes(true);
    }
    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0:case 1:case 2:case 3:case 4:case 5:{
                name = "rangeupgrade";
                break;
            }
            case 6:case 7:case 8:case 9:case 10:case 11:{
                name = "efficiencyupgrade";
                break;
            }
            default:
                name = "null";
        }
        return getUnlocalizedName() + "." + References.MODID + "." + name;
    }
    @Override
    public int getMetadata(int meta) {
        return meta;
    }
}
