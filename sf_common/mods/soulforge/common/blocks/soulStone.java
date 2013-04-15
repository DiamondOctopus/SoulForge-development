package mods.soulforge.common.blocks;

import mods.soulforge.common.mod_soulforge;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class soulStone extends Block {

    public soulStone(int id, Material mat) {
        super(id, mat);
        this.setCreativeTab(mod_soulforge.tabSoulForge).setHardness(30.0F);//.setStepSound(soundStoneFootstep);
    }
    
    @Override
    public void registerIcons(IconRegister reg){
        this.blockIcon = reg.registerIcon("soulforge:soulstone");
    }

}