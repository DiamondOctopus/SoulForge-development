package mods.soulforge.common.items;

import mods.soulforge.common.mod_soulforge;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class SFsteel extends Item {

    public SFsteel(int par1) {
        super(par1);
        this.setCreativeTab(mod_soulforge.tabSoulForge);
    }
    
    @Override
    public void updateIcons(IconRegister reg){
        this.iconIndex = reg.registerIcon("soulforge:soulForgedSteel");
    }

}
