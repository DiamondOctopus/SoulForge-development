package mods.soulforge.common.blocks;

import java.util.Random;

import mods.soulforge.common.mod_soulforge;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class OreMalachite extends Block {

    public OreMalachite(int id, Material mat) {
        super(id, mat);
        this.setCreativeTab(mod_soulforge.tabSoulForge).setHardness(5.0F).setStepSound(soundStoneFootstep);
    }
    
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1);
    }


    public int quantityDropped(Random par1Random)
    {
        return 2 + par1Random.nextInt(2);
    }
    
    public int idDropped(int par1, Random random, int zero){
        return mod_soulforge.rawMalachite.itemID;
    }
    @Override
    public void registerIcons(IconRegister reg){
        this.blockIcon = reg.registerIcon("soulforge:oreMalachite");
    }

}
