package mods.soulforge.common.items;

import mods.soulforge.common.mod_soulforge;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class RunicDiamondChisel extends Item {

    public RunicDiamondChisel(int par1) {
        super(par1);
        this.setCreativeTab(mod_soulforge.tabSoulForge).setMaxDamage(128).setMaxStackSize(1);
    }
    
    @Override
    public void updateIcons(IconRegister reg){
        this.iconIndex = reg.registerIcon("soulforge:runicDiamondChisel");
    }

}

