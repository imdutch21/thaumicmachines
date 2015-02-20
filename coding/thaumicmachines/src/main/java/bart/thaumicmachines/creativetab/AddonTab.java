package bart.thaumicmachines.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by imdutch21 on 13-2-15.
 */
public class AddonTab extends CreativeTabs
{
    public AddonTab(int id, String modid)
    {
        super(id, modid);
    }

    @Override
    public Item getTabIconItem()
    {
        return Items.potato;
    }
}