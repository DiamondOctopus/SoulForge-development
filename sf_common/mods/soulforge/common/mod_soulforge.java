package mods.soulforge.common;

import mods.soulforge.common.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "SoulForge", name = "SoulForge", version = "Alpha 0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class mod_soulforge {
    
    public static CreativeTabs tabSoulForge = new CreativeTabSoulForge(CreativeTabs.getNextID(), "tabSoulForge");
    
    @PreInit
    public void PreInitEventOne(FMLPreInitializationEvent e) {
        System.out.println("SoulForge Initialized");
        
            Configuration config = new Configuration(e.getSuggestedConfigurationFile());
            
            config.load();
            
            //Item ID's
            
            //Tool ID's
            
            //Block ID's
            blockSoulStoneID = config.getBlock("Soul Stone", 600).getInt();
            blockOreMalachiteID = config.getBlock("Malachite Ore", 601).getInt();
            
            config.save();

        }
        
    
    //Items
    
    //Tools
    
    //Blocks
    public static Block soulStone;
    public static Block oreMalachite;
    
    @Init
    public void load(FMLInitializationEvent event) {
        
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabSoulForge", "Soul Forge");
    
    //Blocks
        //Soul Stone
        soulStone = new SoulStone(blockSoulStoneID, Material.rock).setUnlocalizedName("tilesoulstone");
        gameBlockRegisters(soulStone, "soulstone", "Soul Stone");
        
        //Malachite Ore
        oreMalachite = new OreMalachite(blockOreMalachiteID, Material.rock).setUnlocalizedName("tileoremalachite");
        gameBlockRegisters(oreMalachite, "malachiteore", "Malachite Ore");
        
                
    }
    
    private static void gameBlockRegisters(Block i, String e, String f){
        GameRegistry.registerBlock(i,e);
        LanguageRegistry.addName(i, f);
    }
    
    //Variable Definitions
        //Items
    
        //Tools
    
        //Blocks
    public static int blockSoulStoneID;
    public static int blockOreMalachiteID;
}
