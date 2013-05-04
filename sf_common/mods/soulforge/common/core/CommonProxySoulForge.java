package mods.soulforge.common.core;

import mods.soulforge.common.mod_soulforge;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxySoulForge implements IGuiHandler  {
    
    public void registerRenders(){
        
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        return null;
    }
    
    public void registerBlocks(){
        
    }
    
    
    public void addRecipes(){
        
        final int WILDCARD_VALUE = Short.MAX_VALUE;
        
        //ItemStacks
        ItemStack refMalachiteStack = new ItemStack(mod_soulforge.refMalachite);
        ItemStack soulGemMedStack = new ItemStack(mod_soulforge.soulGemMed);
        ItemStack soulGemLargeStack = new ItemStack(mod_soulforge.soulGemLarge);
        ItemStack diamondShardStack = new ItemStack(mod_soulforge.diamondShard, 4);
        ItemStack zirconShardStack = new ItemStack(mod_soulforge.zirconShard, 4);
        ItemStack magicDiamondStack = new ItemStack(mod_soulforge.magicDiamond);
        ItemStack magicDiamondEmptyStack = new ItemStack(mod_soulforge.magicDiamondEmpty);
        ItemStack magicToolCraftStack = new ItemStack(mod_soulforge.magicTool, 2);
        ItemStack magicToolStack = new ItemStack(mod_soulforge.magicTool);
        ItemStack runicSteelStack = new ItemStack(mod_soulforge.runicSteel);
        ItemStack magicZirconStack = new ItemStack(mod_soulforge.magicZircon);
        ItemStack magicZirconEmptyStack = new ItemStack(mod_soulforge.magicZirconEmpty);
        ItemStack soulForgeStack = new ItemStack(mod_soulforge.soulForge);
        //RuneStones
        ItemStack zirconChiselCraftStack = new ItemStack(mod_soulforge.zirconChisel,1,-1);
        ItemStack zirconChiselStack = new ItemStack(mod_soulforge.zirconChisel,1,WILDCARD_VALUE);
        ItemStack diamondChiselStack = new ItemStack(mod_soulforge.runicDiamondChisel,1,WILDCARD_VALUE);
        ItemStack diamondChiselCraftStack = new ItemStack(mod_soulforge.runicDiamondChisel,1,-1);
        ItemStack runeStoneBlankStack = new ItemStack(mod_soulforge.runeStones,1,0);
        ItemStack runeStoneWardStack = new ItemStack(mod_soulforge.runeStones,1,1);
        ItemStack runeStoneWard2Stack = new ItemStack(mod_soulforge.runeStones,1,2);
        ItemStack runeStoneVigilantStack = new ItemStack(mod_soulforge.runeStones,1,3);
        ItemStack runeStoneVigilant2Stack = new ItemStack(mod_soulforge.runeStones,1,4);
        ItemStack runeStoneToolStack = new ItemStack(mod_soulforge.runeStones,1,5);
        ItemStack runeStoneBindingStack = new ItemStack(mod_soulforge.runeStones,1,6);
        ItemStack runeStoneTool2Stack = new ItemStack(mod_soulforge.runeStones,1,7);
        ItemStack runeStoneArmorStack = new ItemStack(mod_soulforge.runeStones,1,8);
        ItemStack runeStoneArmor2Stack = new ItemStack(mod_soulforge.runeStones,1,9);
        //Souls & SoulGems
        ItemStack elemCreeperStack = new ItemStack(mod_soulforge.elemSouls,1,0);
        ItemStack elemSkeletonStack = new ItemStack(mod_soulforge.elemSouls,1,1);
        ItemStack elemZombieStack = new ItemStack(mod_soulforge.elemSouls,1,2);
        ItemStack elemSpiderStack = new ItemStack(mod_soulforge.elemSouls,1,3);
        ItemStack elemGhastStack = new ItemStack(mod_soulforge.elemSouls,1,4);
        ItemStack elemBlazeStack = new ItemStack(mod_soulforge.elemSouls,1,5);
        ItemStack elemEndermanStack = new ItemStack(mod_soulforge.elemSouls,1,6);
        ItemStack elemSlimeStack = new ItemStack(mod_soulforge.elemSouls,1,7);
        ItemStack elemCreeperGemStack = new ItemStack(mod_soulforge.elemSoulGem,1,0);
        ItemStack elemSkeletonGemStack = new ItemStack(mod_soulforge.elemSoulGem,1,1);
        ItemStack elemZombieGemStack = new ItemStack(mod_soulforge.elemSoulGem,1,2);
        ItemStack elemSpiderGemStack = new ItemStack(mod_soulforge.elemSoulGem,1,3);
        ItemStack elemGhastGemStack = new ItemStack(mod_soulforge.elemSoulGem,1,4);
        ItemStack elemBlazeGemStack = new ItemStack(mod_soulforge.elemSoulGem,1,5);
        ItemStack elemEndermanGemStack = new ItemStack(mod_soulforge.elemSoulGem,1,6);
        ItemStack elemSlimeGemStack = new ItemStack(mod_soulforge.elemSoulGem,1,7);
        
        //Smelting
        GameRegistry.addSmelting(mod_soulforge.rawMalachite.itemID, refMalachiteStack, 1.0F);
        
        //Crafting
        //Shapeless
        GameRegistry.addShapelessRecipe((runicSteelStack), diamondChiselStack, mod_soulforge.soulForgedSteel);
        //Shaped
        GameRegistry.addRecipe(magicDiamondEmptyStack, new Object[] {"xxx", "x#x", "xxx", 'x', mod_soulforge.diamondShard, '#', runeStoneBindingStack});
        GameRegistry.addRecipe(magicZirconEmptyStack, new Object[] {"xxx", "x#x", "xxx", 'x', mod_soulforge.zirconShard, '#', runeStoneBindingStack});
        GameRegistry.addRecipe(zirconChiselCraftStack, new Object[] {" x", "# ", '#', mod_soulforge.zirconGem, 'x', Item.stick});
        GameRegistry.addRecipe(zirconChiselCraftStack, new Object[] {"x ", " #", '#', mod_soulforge.zirconGem, 'x', Item.stick});
        GameRegistry.addRecipe(magicToolCraftStack, new Object[] {"x#x", "xyx", "x#x", 'x', mod_soulforge.refMalachite, '#', Item.blazeRod, 'y', runeStoneToolStack});
        GameRegistry.addRecipe(diamondChiselCraftStack, new Object[] {" x", "# ", '#', mod_soulforge.magicDiamond, 'x', mod_soulforge.magicTool});
        GameRegistry.addRecipe(diamondChiselCraftStack, new Object[] {"x ", " #", '#', mod_soulforge.magicDiamond, 'x', mod_soulforge.magicTool});
        GameRegistry.addRecipe(soulForgeStack, new Object[] {"xxx", "yzw", "x#x", 'x', Block.stoneBrick, 'y', runeStoneToolStack, 'w', runeStoneArmorStack, 'z', Block.anvil, '#', soulGemLargeStack});
        GameRegistry.addRecipe(soulForgeStack, new Object[] {"xxx", "yzw", "x#x", 'x', Block.stoneBrick, 'w', runeStoneToolStack, 'y', runeStoneArmorStack, 'z', Block.anvil, '#', soulGemLargeStack});
        
        //Soulgems
        GameRegistry.addRecipe(soulGemMedStack, new Object[] {"xxx", "x#x", "xxx", 'x', mod_soulforge.refMalachite, '#', Item.blazePowder});
        GameRegistry.addRecipe(soulGemMedStack, new Object[] {"xxx", "xxx", "xxx", 'x',mod_soulforge.soulGemLow});
        GameRegistry.addRecipe(soulGemLargeStack, new Object[] {"xxx", "x#x", "xxx", 'x', mod_soulforge.soulGemMed, '#', runeStoneBindingStack});
        
        //Runestones
        GameRegistry.addShapelessRecipe((diamondShardStack), zirconChiselStack, Item.diamond); GameRegistry.addShapelessRecipe((diamondShardStack), diamondChiselStack, Item.diamond);
        GameRegistry.addShapelessRecipe((zirconShardStack), diamondChiselStack, mod_soulforge.zirconGem);
        GameRegistry.addShapelessRecipe((runeStoneBlankStack), zirconChiselStack, Block.stone); GameRegistry.addShapelessRecipe((runeStoneBlankStack), diamondChiselStack, Block.stone);
        GameRegistry.addShapelessRecipe((runeStoneWardStack), zirconChiselStack, runeStoneBlankStack); GameRegistry.addShapelessRecipe((runeStoneWardStack), diamondChiselStack, runeStoneBlankStack);
        GameRegistry.addRecipe(runeStoneBindingStack, new Object[] {"x#", 'x', runeStoneWardStack, '#', zirconChiselStack}); GameRegistry.addRecipe(runeStoneBindingStack, new Object[] {"x#", 'x', runeStoneWardStack, '#', diamondChiselStack});
        GameRegistry.addRecipe(runeStoneVigilantStack, new Object [] {"#", "x", 'x', runeStoneWardStack, '#', zirconChiselStack}); GameRegistry.addRecipe(runeStoneVigilantStack, new Object [] {"#", "x", 'x', runeStoneWardStack, '#', diamondChiselStack});
        GameRegistry.addRecipe(runeStoneToolStack, new Object [] {"x", "#", 'x', runeStoneWardStack, '#', zirconChiselStack});GameRegistry.addRecipe(runeStoneToolStack, new Object [] {"x", "#", 'x', runeStoneWardStack, '#', diamondChiselStack});
        GameRegistry.addShapelessRecipe((runeStoneArmorStack), zirconChiselStack, runeStoneToolStack);GameRegistry.addShapelessRecipe((runeStoneArmorStack), diamondChiselStack, runeStoneToolStack);
        
        //Soulgems
        GameRegistry.addShapelessRecipe((elemCreeperGemStack), elemCreeperStack, mod_soulforge.soulGemLarge);
        GameRegistry.addShapelessRecipe((elemSkeletonGemStack), elemSkeletonStack, mod_soulforge.soulGemLarge);
        GameRegistry.addShapelessRecipe((elemZombieGemStack), elemZombieStack, mod_soulforge.soulGemLarge);
        GameRegistry.addShapelessRecipe((elemSpiderGemStack), elemSpiderStack, mod_soulforge.soulGemLarge);
        GameRegistry.addShapelessRecipe((elemGhastGemStack), elemGhastStack, mod_soulforge.soulGemLarge);
        GameRegistry.addShapelessRecipe((elemBlazeGemStack), elemBlazeStack, mod_soulforge.soulGemLarge);
        GameRegistry.addShapelessRecipe((elemEndermanGemStack), elemEndermanStack, mod_soulforge.soulGemLarge);
        GameRegistry.addShapelessRecipe((elemSlimeGemStack), elemSlimeStack, mod_soulforge.soulGemLarge);
        
    }
        
}
