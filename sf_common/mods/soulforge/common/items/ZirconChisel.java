package mods.soulforge.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.soulforge.common.mod_soulforge;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class ZirconChisel extends Item {

    public ZirconChisel(int par1) {
        super(par1);
        this.setCreativeTab(mod_soulforge.tabSoulForge).setMaxDamage(32).setMaxStackSize(1);
    }
    
    @Override
    public void updateIcons(IconRegister reg){
        this.iconIndex = reg.registerIcon("soulforge:zirconChisel");
    }

}
