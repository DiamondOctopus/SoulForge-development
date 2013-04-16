package mods.soulforge.common.blocks;

import java.util.Random;

import mods.soulforge.common.mod_soulforge;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class OreMalachite extends Block {

    public OreMalachite(int id, Material mat) {
        super(id, mat);
        this.setCreativeTab(mod_soulforge.tabSoulForge).setHardness(15.0F).setStepSound(soundStoneFootstep);
    }
    
    public int quantityDropped(Random r){
        return 1;
    }
    
    @Override
    public void registerIcons(IconRegister reg){
        this.blockIcon = reg.registerIcon("soulforge:malachite");
    }

}
