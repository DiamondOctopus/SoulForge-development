package mods.soulforge.common.items;

import mods.soulforge.common.mod_soulforge;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class SwordEnderman extends ItemSword{

    public SwordEnderman(int par1, EnumToolMaterial par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.setCreativeTab(mod_soulforge.tabSoulForge);
    }
    @Override
    public void updateIcons(IconRegister reg){
        this.iconIndex = reg.registerIcon("soulforge:animEnderSword");
    }

}
