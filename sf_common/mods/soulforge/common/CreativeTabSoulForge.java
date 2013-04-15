package mods.soulforge.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabSoulForge extends CreativeTabs {

    public CreativeTabSoulForge(int par1, String par2Str) {
        super(par1, par2Str);
    }
    
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex() {
        return Block.anvil.blockID;
    }
    
    public String getTranslatedTablabels(){
        return "Soul Forge";
    }
}
