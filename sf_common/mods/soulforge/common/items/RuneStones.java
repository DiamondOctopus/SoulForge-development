package mods.soulforge.common.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.soulforge.common.mod_soulforge;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

public class RuneStones extends Item {
    //List of Item Names
    public static final String[] itemMetaNames = new String [] {"blankrune", "wardrune", "wardruneii", "vigilantrune", "vigilantruneii", "toolrune", "bindingrune", "toolruneii"};
    public static final String[] itemTextures = new String [] {"runeBlank", "runeWard", "runeWard2", "runeVigilant", "runeVigilant2", "runeTool", "runeBinding", "runeTool2"};

    @SideOnly(Side.CLIENT)
    private Icon[] itemTextureSelector;
    
    public RuneStones(int par1){
        super(par1);
        this.setHasSubtypes(true);
        this.setCreativeTab(mod_soulforge.tabSoulForge).setMaxDamage(0);
    }
    @SideOnly(Side.CLIENT)

    /**
             * Gets an icon index based on an item's damage value
             */
    public Icon getIconFromDamage(int par1){
        
             int j = MathHelper.clamp_int(par1, 0, 7);
             return this.itemTextureSelector[j];
    }
    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack par1ItemStack){
        
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 7);
        return super.getUnlocalizedName() + "." + itemMetaNames[i];
    }
    @SideOnly(Side.CLIENT)

    /**
             * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
             */
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List){
             for (int j = 0; j < 8; ++j){
                     par3List.add(new ItemStack(par1, 1, j));
             }
    }
    @Override
    public void updateIcons(IconRegister par1IconRegister){
             this.itemTextureSelector = new Icon[itemTextures.length];
            
             for (int i = 0; i < itemTextures.length; ++i){
                     this.itemTextureSelector[i] = par1IconRegister.registerIcon("soulforge:" + itemTextures[i]);
             }
    }
}
