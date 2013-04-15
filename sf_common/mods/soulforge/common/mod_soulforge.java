package mods.soulforge.common;

import mods.soulforge.common.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "SoulForge", name = "SoulForge", version = "Alpha 0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class mod_soulforge {
    
    public static CreativeTabs tabSoulForge = new CreativeTabSoulForge(CreativeTabs.getNextID(), "tabSoulForge");

    public static Block soulStone;
    public int soulStoneID = 600;
    
    @Init
    public void load(FMLInitializationEvent event) {
        
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabSoulForge", "Soul Forge");
    
    //Blocks
        //Soul Stone
        soulStone = new soulStone(soulStoneID, Material.rock).setUnlocalizedName("tilesoulstone");
        gameBlockRegisters(soulStone, "soulstone", "Soul Stone");
        
                
    }
    
    private static void gameBlockRegisters(Block i, String e, String f){
        GameRegistry.registerBlock(i,e);
        LanguageRegistry.addName(i, f);
    }
}
