package mods.soulforge.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesSoulInfuser
{
    private static final RecipesSoulInfuser smeltingBase = new RecipesSoulInfuser();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final RecipesSoulInfuser smelting()
    {
        return smeltingBase;
    }
    
    

    private RecipesSoulInfuser()
    {
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
        ItemStack soulGemMedStack = new ItemStack(mod_soulforge.soulGemMed);
        ItemStack soulGemLargeStack = new ItemStack(mod_soulforge.soulGemLarge);
        ItemStack magicDiamondStack = new ItemStack(mod_soulforge.magicDiamond);
        ItemStack magicZirconStack = new ItemStack(mod_soulforge.magicZircon);
        ItemStack magicEssenceStack = new ItemStack(mod_soulforge.magicEssence);
       //  this.addSmelting(thingtobesmelted, thingtorecieve, exp);
        this.addSmelting(mod_soulforge.lowSoul.itemID, new ItemStack(Block.sand), 0.7F);
        this.addSmelting(mod_soulforge.elemSouls.itemID, 0, elemCreeperGemStack, 0.7F);
        this.addSmelting(mod_soulforge.elemSouls.itemID, 1, elemSkeletonGemStack, 0.7F);
        this.addSmelting(mod_soulforge.elemSouls.itemID, 2, elemZombieGemStack, 0.7F);
        this.addSmelting(mod_soulforge.elemSouls.itemID, 3, elemSpiderGemStack, 0.7F);
        this.addSmelting(mod_soulforge.elemSouls.itemID, 4, elemGhastGemStack, 0.7F);
        this.addSmelting(mod_soulforge.elemSouls.itemID, 5, elemBlazeGemStack, 0.7F);
        this.addSmelting(mod_soulforge.elemSouls.itemID, 6, elemEndermanGemStack, 0.7F);
        this.addSmelting(mod_soulforge.elemSouls.itemID, 7, elemSlimeGemStack, 0.7F);
        this.addSmelting(mod_soulforge.magicDiamondEmpty.itemID, magicDiamondStack, 0.7F);
        this.addSmelting(mod_soulforge.magicZirconEmpty.itemID, magicZirconStack, 0.7F);
        this.addSmelting(Item.blazePowder.itemID, magicEssenceStack, 0.7F);
        
    }

    /**
     * Adds a smelting recipe.
     */
    public void addSmelting(int par1, ItemStack par2ItemStack, float par3)
    {
        this.smeltingList.put(Integer.valueOf(par1), par2ItemStack);
        this.experienceList.put(Integer.valueOf(par2ItemStack.itemID), Float.valueOf(par3));
    }


    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    /**
     * A metadata sensitive version of adding a furnace recipe.
     */
    public void addSmelting(int itemID, int metadata, ItemStack itemstack, float experience)
    {
        metaSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
        metaExperience.put(Arrays.asList(itemID, metadata), experience);
    }

    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)smeltingList.get(Integer.valueOf(item.itemID));
    }

    /**
     * Grabs the amount of base experience for this item to give when pulled from the furnace slot.
     */
    public float getExperience(ItemStack item)
    {
        if (item == null || item.getItem() == null)
        {
            return 0;
        }
        float ret = item.getItem().getSmeltingExperience(item);
        if (ret < 0 && metaExperience.containsKey(Arrays.asList(item.itemID, item.getItemDamage())))
        {
            ret = metaExperience.get(Arrays.asList(item.itemID, item.getItemDamage()));
        }
        if (ret < 0 && experienceList.containsKey(item.itemID))
        {
            ret = ((Float)experienceList.get(item.itemID)).floatValue();
        }
        return (ret < 0 ? 0 : ret);
    }

    public Map<List<Integer>, ItemStack> getMetaSmeltingList()
    {
        return metaSmeltingList;
    }
}