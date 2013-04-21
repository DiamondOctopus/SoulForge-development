package mods.soulforge.common;

import mods.soulforge.common.blocks.*;
import mods.soulforge.common.core.*;
import mods.soulforge.client.core.*;
import mods.soulforge.common.items.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "SoulForge", name = "SoulForge", version = "Alpha 0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class mod_soulforge {
    
    @SidedProxy(clientSide = "mods.soulforge.client.core.ClientProxySoulForge", serverSide = "CommonProxySoulForge")
    public static CommonProxySoulForge proxy;
    
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
            itemDiamondShardID = config.getItem("Diamond Shard", 16607).getInt();
            itemMagicDiamondID = config.getItem("Magical Diamond", 16608).getInt();
            itemMagicDiamondEmptyID = config.getItem("Magical Diamond - Empty", 16609).getInt();
            itemRuneStonesID = config.getItem("Rune Stones", 16610).getInt();
            itemZirconID = config.getItem("Zircon Gem", 16611).getInt();
            itemZirconChiselID = config.getItem("Zircon Chisel", 16612).getInt();
            itemRunicDiamondChiselID = config.getItem("Runic Diamond Chisel", 16613).getInt();
            itemMagicToolID = config.getItem("Magical Tool Handle", 16614).getInt();
            itemZirconShardID = config.getItem("Zircon Shard", 16615).getInt();
            
            // Tool ID's
            swordCreeperID = config.getItem("Elemental Sword - Creeper",16700).getInt();
            
            // Block ID's
            blockSoulStoneID = config.getBlock("Soul Stone", 600).getInt();
            blockOreMalachiteID = config.getBlock("Malachite Ore", 601).getInt();
            blockOreZirconID = config.getBlock("Zircon Ore", 602).getInt();
            
            config.save();

        }
        
    
    // Items
    public static Item rawMalachite;
    public static Item refMalachite;
    public static Item soulGemLow;
    public static Item soulGemMed;
    public static Item soulGemLarge;
    public static Item elemSouls;
    public static Item elemSoulGem;
    public static Item diamondShard;
    public static Item magicDiamond;
    public static Item magicDiamondEmpty;
    public static Item runeStones;
    public static Item zirconChisel;
    public static Item zirconGem;
    public static Item runicDiamondChisel;
    public static Item magicTool;
    public static Item zirconShard;
    
    // Tools
    public static Item swordCreeper;
    
    // Blocks
    public static Block soulStone;
    public static Block oreMalachite;
    public static Block oreZircon;
    
    // start enum tool material
    
    public static EnumToolMaterial toolElementalBase = EnumHelper.addToolMaterial("ELEMENTALBASE", 3, 1561, 8.0F, 3, 15);
    public static EnumToolMaterial toolElementalHigh = EnumHelper.addToolMaterial("ELEMENTALHIGH", 3, 2056, 10.0F, 4, 22);
    public static EnumToolMaterial toolElementalBest = EnumHelper.addToolMaterial("ELEMENTALBEST", 3, 2568, 12.0F, 5, 30);
    
    @Init
    public void load(FMLInitializationEvent event) {
        
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabSoulForge", "Soul Forge");
        
        MinecraftForge.EVENT_BUS.register(new LivingDrops());
        
        GameRegistry.registerCraftingHandler(new CraftingHandler());      

    // world generation
        GameRegistry.registerWorldGenerator(new SoulForgeWorldGen());
        
    // Tools
        zirconChisel = new ZirconChisel(itemZirconChiselID).setUnlocalizedName("toolzirconchisel");
        gameItemRegisters(zirconChisel, "zirconchisel", "Zirconium Chisel");
        
        runicDiamondChisel = new RunicDiamondChisel(itemRunicDiamondChiselID).setUnlocalizedName("toolrunicdiamondchisel");
        gameItemRegisters(runicDiamondChisel, "runicdiamondchisel", "Runic Diamond Chisel");
        
        swordCreeper = new SwordCreeper(swordCreeperID,toolElementalHigh).setUnlocalizedName("swordcreeper");
        gameItemRegisters(swordCreeper, "creepersword", "Elemental Sword - Creeper");
        
 
    //Items
        //Malachite
        rawMalachite = new RawMalachite(itemMalachiteID).setUnlocalizedName("tilemalachite");
        gameItemRegisters(rawMalachite, "rawmalachite", "Malachite");
        
        refMalachite = new RefMalachite(itemRefMalachiteID).setUnlocalizedName("tilerefmalachite");
        gameItemRegisters(refMalachite, "refmalachite", "Refined Malachite");
        
        magicTool = new MagicalTool(itemMagicToolID).setUnlocalizedName("magictoolhandle");
        gameItemRegisters(magicTool, "magicaltoolhandle", "Magical Tool Handle");
        
        //Soul Gems
        soulGemLow = new SoulGemLow(itemSoulGemLowID).setUnlocalizedName("tilesoulgemlow");
        gameItemRegisters(soulGemLow, "soulgemlow", "Soul Gem - Low Quality");
        
        soulGemMed = new SoulGemMed(itemSoulGemMedID).setUnlocalizedName("tilesoulgemmed");
        gameItemRegisters(soulGemMed, "soulgemmed", "Soul Gem - Medium Quality");
        
        soulGemLarge = new SoulGemLarge(itemSoulGemLargeID).setUnlocalizedName("tilesoulgemlarge");
        gameItemRegisters(soulGemLarge, "soulgemlarge", "Soul Gem - High Quality");
        
        //Other Items
        zirconGem = new ZirconGem(itemZirconID).setUnlocalizedName("tilezircongem");
        gameItemRegisters(zirconGem, "zircongem", "Zirconium Gem");
        
        //Elemental Souls (Metadata Item)
        elemSouls = new ElemSouls(itemElemSoulsID).setUnlocalizedName("elemsouls");
        elemSoulGem = new ElemSoulGem(itemElemSoulGemID).setUnlocalizedName("elemsoulgem");
        
        //Rune Stones (Metadata Item)
        runeStones = new RuneStones(itemRuneStonesID).setUnlocalizedName("runestones");
        
        //Magic Stuff
        diamondShard = new DiamondShard(itemDiamondShardID).setUnlocalizedName("tilediamondshard");
        gameItemRegisters(diamondShard, "diamondshard", "Diamond Shard");
        
        zirconShard = new ZirconShard(itemZirconShardID).setUnlocalizedName("tilezirconshard");
        gameItemRegisters(zirconShard, "zirconshard", "Zirconium Shard");
        
        magicDiamond = new MagicDiamond(itemMagicDiamondID).setUnlocalizedName("tilemagicaldiamond");
        gameItemRegisters(magicDiamond, "magicaldiamond", "Magically Infused Diamond");
        
        magicDiamondEmpty = new MagicDiamondEmpty(itemMagicDiamondEmptyID).setUnlocalizedName("tilemagicaldiamondempty");
        gameItemRegisters(magicDiamondEmpty, "magicaldiamondempty", "Magic Diamond - Empty");
        
    //Blocks
        //Soul Stone
        soulStone = new SoulStone(blockSoulStoneID, Material.rock).setUnlocalizedName("tilesoulstone");
        gameBlockRegisters(soulStone, "soulstone", "Soul Stone");
        
        //Malachite Ore
        oreMalachite = new OreMalachite(blockOreMalachiteID, Material.rock).setUnlocalizedName("tileoremalachite");
        gameBlockRegisters(oreMalachite, "malachiteore", "Malachite Ore");
        MinecraftForge.setBlockHarvestLevel(oreMalachite, "pickaxe", 2);
        
        oreZircon = new OreZircon(blockOreZirconID, Material.rock).setUnlocalizedName("tileorezircon");
        gameBlockRegisters(oreZircon, "zirconore", "Zirconium Ore");
        MinecraftForge.setBlockHarvestLevel(oreZircon, "pickaxe", 2);
     
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
   //Rune Stones Language Registry
        LanguageRegistry.instance().addStringLocalization("item.runestones.blankrune.name", "Blank Runestone");
        LanguageRegistry.instance().addStringLocalization("item.runestones.wardrune.name", "Warding Runestone I");
        LanguageRegistry.instance().addStringLocalization("item.runestones.wardruneii.name", "Warding Runestone II");
        LanguageRegistry.instance().addStringLocalization("item.runestones.vigilantrune.name", "Vigilant Runestone I");
        LanguageRegistry.instance().addStringLocalization("item.runestones.vigilantruneii.name", "Vigilant Runestone II");
        LanguageRegistry.instance().addStringLocalization("item.runestones.toolrune.name", "Tool Runestone I");
        LanguageRegistry.instance().addStringLocalization("item.runestones.bindingrune.name", "Binding Runestone");
        LanguageRegistry.instance().addStringLocalization("item.runestones.toolruneii.name", "Tool Runestone II");
        
        proxy.addRecipes();
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
    public static int itemDiamondShardID;
    public static int itemMagicDiamondID;
    public static int itemMagicDiamondEmptyID;
    public static int itemRuneStonesID;
    public static int itemZirconID;
    public static int itemZirconChiselID;
    public static int itemRunicDiamondChiselID;
    public static int itemMagicToolID;
    public static int itemZirconShardID;

        //Tools
    public static int swordCreeperID;
    
        //Blocks
    public static int blockSoulStoneID;
    public static int blockOreMalachiteID;
    public static int blockOreZirconID;
}
