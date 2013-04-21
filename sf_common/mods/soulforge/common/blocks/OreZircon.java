package mods.soulforge.common.blocks;

import java.util.Random;

import mods.soulforge.common.mod_soulforge;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class OreZircon extends Block {

    public OreZircon(int par1, Material par2Material) {
        super(par1, par2Material);
        this.setCreativeTab(mod_soulforge.tabSoulForge).setHardness(5.0F).setStepSound(soundStoneFootstep);
    }
    
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1);
    }
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    
    public int idDropped(int par1, Random random, int zero){
        return mod_soulforge.zirconGem.itemID;
    }
    
    @Override
    public void registerIcons(IconRegister reg){
        this.blockIcon = reg.registerIcon("soulforge:oreZircon");
    }

}
