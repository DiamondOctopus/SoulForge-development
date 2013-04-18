package mods.soulforge.common;

import mods.soulforge.common.blocks.*;
import mods.soulforge.common.items.ElemSoulGem;
import mods.soulforge.common.items.ElemSouls;
import mods.soulforge.common.items.RawMalachite;
import mods.soulforge.common.items.RefMalachite;
import mods.soulforge.common.items.SoulGemLarge;
import mods.soulforge.common.items.SoulGemLow;
import mods.soulforge.common.items.SoulGemMed;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
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
            itemMalachiteID = config.getItem("Raw Malachite", 16600).getInt();
            itemRefMalachiteID = config.getItem("Refined Malachite", 16601).getInt();
            itemSoulGemLowID = config.getItem("Soul Gem - Low", 16602).getInt();
            itemSoulGemMedID = config.getItem("Soul Gem - Medium", 16603).getInt();
            itemSoulGemLargeID = config.getItem("Soul Gem - Large", 16604).getInt();
            itemElemSoulsID = config.getItem("Elemental Souls", 16605).getInt();
            itemElemSoulGemID = config.getItem("Elemental Soul Gems", 16606).getInt();
            //Tool ID's
            
            //Block ID's
            blockSoulStoneID = config.getBlock("Soul Stone", 600).getInt();
            blockOreMalachiteID = config.getBlock("Malachite Ore", 601).getInt();
            
            config.save();

        }
        
    
    //Items
    public static Item rawMalachite;
    public static Item refMalachite;
    public static Item soulGemLow;
    public static Item soulGemMed;
    public static Item soulGemLarge;
    public static Item elemSouls;
    public static Item elemSoulGem;
    
    //Tools
    
    //Blocks
    public static Block soulStone;
    public static Block oreMalachite;
    
    @Init
    public void load(FMLInitializationEvent event) {
        
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabSoulForge", "Soul Forge");
        
        MinecraftForge.EVENT_BUS.register(new LivingDrops());
    
    //world generation
        GameRegistry.registerWorldGenerator(new SoulForgeWorldGen());
        
    //Items
        //Malachite
        rawMalachite = new RawMalachite(itemMalachiteID).setUnlocalizedName("tilemalachite");
        gameItemRegisters(rawMalachite, "rawmalachite", "Malachite");
        
        refMalachite = new RefMalachite(itemRefMalachiteID).setUnlocalizedName("tilerefmalachite");
        gameItemRegisters(refMalachite, "refmalachite", "Refined Malachite");
        
        //Soul Gems
        soulGemLow = new SoulGemLow(itemSoulGemLowID).setUnlocalizedName("tilesoulgemlow");
        gameItemRegisters(soulGemLow, "soulgemlow", "Soul Gem - Low Quality");
        
        soulGemMed = new SoulGemMed(itemSoulGemMedID).setUnlocalizedName("tilesoulgemmed");
        gameItemRegisters(soulGemMed, "soulgemmed", "Soul Gem - Medium Quality");
        
        soulGemLarge = new SoulGemLarge(itemSoulGemLargeID).setUnlocalizedName("tilesoulgemlarge");
        gameItemRegisters(soulGemLarge, "soulgemlarge", "Soul Gem - High Quality");
        
        //Elemental Souls (Metadata Item)
        elemSouls = new ElemSouls(itemElemSoulsID).setUnlocalizedName("elemsouls");
        elemSoulGem = new ElemSoulGem(itemElemSoulGemID).setUnlocalizedName("elemsoulgem");
        
    //Blocks
        //Soul Stone
        soulStone = new SoulStone(blockSoulStoneID, Material.rock).setUnlocalizedName("tilesoulstone");
        gameBlockRegisters(soulStone, "soulstone", "Soul Stone");
        
        //Malachite Ore
        oreMalachite = new OreMalachite(blockOreMalachiteID, Material.rock).setUnlocalizedName("tileoremalachite");
        gameBlockRegisters(oreMalachite, "malachiteore", "Malachite Ore");
        MinecraftForge.setBlockHarvestLevel(oreMalachite, "pickaxe", 2);
   
   //Crafting and smelting, mofo
        ItemStack refMalachiteStack = new ItemStack(refMalachite);
        ItemStack soulGemMedStack = new ItemStack(soulGemMed);
        ItemStack soulGemLargeStack = new ItemStack(soulGemLarge);
        
   //Smelting
        GameRegistry.addSmelting(rawMalachite.itemID, refMalachiteStack, 1.0F);
        
   //SoulGem Crafting
        GameRegistry.addRecipe(soulGemMedStack, new Object[] {"xxx", "x#x", "xxx", 'x', refMalachite, '#', Item.blazePowder});
        GameRegistry.addRecipe(soulGemMedStack, new Object[] {"xxx", "xxx", "xxx", 'x', soulGemLow});
        GameRegistry.addRecipe(soulGemLargeStack, new Object[] {"xxx", "xxx", "xxx", 'x', soulGemMed});
        
   //Elemental Soulgem Crafting
        //Inputs
        ItemStack elemCreeperStack = new ItemStack(elemSouls,1,0);
        ItemStack elemSkeletonStack = new ItemStack(elemSouls,1,1);
        ItemStack elemZombieStack = new ItemStack(elemSouls,1,2);
        ItemStack elemSpiderStack = new ItemStack(elemSouls,1,3);
        ItemStack elemGhastStack = new ItemStack(elemSouls,1,4);
        ItemStack elemBlazeStack = new ItemStack(elemSouls,1,5);
        ItemStack elemEndermanStack = new ItemStack(elemSouls,1,6);
        ItemStack elemSlimeStack = new ItemStack(elemSouls,1,7);
        
        //Outputs
        ItemStack elemCreeperGemStack = new ItemStack(elemSoulGem,1,0);
        ItemStack elemSkeletonGemStack = new ItemStack(elemSoulGem,1,1);
        ItemStack elemZombieGemStack = new ItemStack(elemSoulGem,1,2);
        ItemStack elemSpiderGemStack = new ItemStack(elemSoulGem,1,3);
        ItemStack elemGhastGemStack = new ItemStack(elemSoulGem,1,4);
        ItemStack elemBlazeGemStack = new ItemStack(elemSoulGem,1,5);
        ItemStack elemEndermanGemStack = new ItemStack(elemSoulGem,1,6);
        ItemStack elemSlimeGemStack = new ItemStack(elemSoulGem,1,7);
        
        //Crafting
        GameRegistry.addShapelessRecipe((elemCreeperGemStack), elemCreeperStack, soulGemLarge);
        GameRegistry.addShapelessRecipe((elemSkeletonGemStack), elemSkeletonStack, soulGemLarge);
        GameRegistry.addShapelessRecipe((elemZombieGemStack), elemZombieStack, soulGemLarge);
        GameRegistry.addShapelessRecipe((elemSpiderGemStack), elemSpiderStack, soulGemLarge);
        GameRegistry.addShapelessRecipe((elemGhastGemStack), elemGhastStack, soulGemLarge);
        GameRegistry.addShapelessRecipe((elemBlazeGemStack), elemBlazeStack, soulGemLarge);
        GameRegistry.addShapelessRecipe((elemEndermanGemStack), elemEndermanStack, soulGemLarge);
        GameRegistry.addShapelessRecipe((elemSlimeGemStack), elemSlimeStack, soulGemLarge);
        
   //Elemental Souls Language Registry
        LanguageRegistry.instance().addStringLocalization("item.elemsouls.elementalcreeper.name", "Elemental Soul - Creeper");
        LanguageRegistry.instance().addStringLocalization("item.elemsouls.elementalskeleton.name", "Elemental Soul - Skeleton");
        LanguageRegistry.instance().addStringLocalization("item.elemsouls.elementalzombie.name", "Elemental Soul - Zombie");
        LanguageRegistry.instance().addStringLocalization("item.elemsouls.elementalspider.name", "Elemental Soul - Spider");
        LanguageRegistry.instance().addStringLocalization("item.elemsouls.elementalghast.name", "Elemental Soul - Ghast");
        LanguageRegistry.instance().addStringLocalization("item.elemsouls.elementalblaze.name", "Elemental Soul - Blaze");
        LanguageRegistry.instance().addStringLocalization("item.elemsouls.elementalenderman.name", "Elemental Soul - Enderman");
        LanguageRegistry.instance().addStringLocalization("item.elemsouls.elementalslime.name", "Elemental Soul - Slime");
        LanguageRegistry.instance().addStringLocalization("item.elemsoulgem.elementalcreepergem.name", "Elemental Soul Gem - Creeper");
        LanguageRegistry.instance().addStringLocalization("item.elemsoulgem.elementalskeletongem.name", "Elemental Soul Gem - Skeleton");
        LanguageRegistry.instance().addStringLocalization("item.elemsoulgem.elementalzombiegem.name", "Elemental Soul Gem - Zombie");
        LanguageRegistry.instance().addStringLocalization("item.elemsoulgem.elementalspidergem.name", "Elemental Soul Gem - Spider");
        LanguageRegistry.instance().addStringLocalization("item.elemsoulgem.elementalghastgem.name", "Elemental Soul Gem - Ghast");
        LanguageRegistry.instance().addStringLocalization("item.elemsoulgem.elementalblazegem.name", "Elemental Soul Gem - Blaze");
        LanguageRegistry.instance().addStringLocalization("item.elemsoulgem.elementalendermangem.name", "Elemental Soul Gem - Enderman");
        LanguageRegistry.instance().addStringLocalization("item.elemsoulgem.elementalslimegem.name", "Elemental Soul Gem - Slime");
        
    }
    
    private static void gameBlockRegisters(Block i, String e, String f){
        GameRegistry.registerBlock(i,e);
        LanguageRegistry.addName(i, f);
    }  
    private static void gameItemRegisters(Item i, String e, String f){
        GameRegistry.registerItem(i,e);
        LanguageRegistry.addName(i,f);
    }
    
    //Variable Definitions
        //Items
    public static int itemMalachiteID;
    public static int itemRefMalachiteID;
    public static int itemSoulGemLowID;
    public static int itemSoulGemMedID;
    public static int itemSoulGemLargeID;
    public static int itemElemSoulsID;
    public static int itemElemSoulGemID;

        //Tools
    
        //Blocks
    public static int blockSoulStoneID;
    public static int blockOreMalachiteID;
}
