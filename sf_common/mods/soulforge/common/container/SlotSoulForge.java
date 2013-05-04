package mods.soulforge.common.container;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

public class SlotSoulForge extends Slot {
    private final IInventory craftMatrix;
    private final EntityPlayer thePlayer;
    
    private int amountCrafted;
    
    public SlotSoulForge(EntityPlayer player, IInventory par2Inventory, IInventory par3Inventory, int par4, int par5, int par6){
        super(par3Inventory, par4, par5, par6);
        this.thePlayer = player;
        this.craftMatrix = par2Inventory;
    }
    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return false;
    }
    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int par1)
    {
        if (this.getHasStack())
        {
            this.amountCrafted += Math.min(par1, this.getStack().stackSize);
        }

        return super.decrStackSize(par1);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
     * internal count then calls onCrafting(item).
     */
    protected void onCrafting(ItemStack par1ItemStack, int par2)
    {
        this.amountCrafted += par2;
        this.onCrafting(par1ItemStack);
    }
    public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
    {
        GameRegistry.onItemCrafted(par1EntityPlayer, par2ItemStack, craftMatrix);
        this.onCrafting(par2ItemStack);

        for (int var3 = 0; var3 < this.craftMatrix.getSizeInventory(); ++var3)
        {
            ItemStack var4 = this.craftMatrix.getStackInSlot(var3);

            if (var4 != null)
            {
                this.craftMatrix.decrStackSize(var3, 1);

                if (var4.getItem().hasContainerItem())
                {
                    ItemStack var5 = var4.getItem().getContainerItemStack(var4);

                    if (var5.isItemStackDamageable() && var5.getItemDamage() > var5.getMaxDamage())
                    {
                        MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(thePlayer, var5));
                        var5 = null;
                    }

                    if (var5 != null && (!var4.getItem().doesContainerItemLeaveCraftingGrid(var4) || !this.thePlayer.inventory.addItemStackToInventory(var5)))
                    {
                        if (this.craftMatrix.getStackInSlot(var3) == null)
                        {
                            this.craftMatrix.setInventorySlotContents(var3, var5);
                        }
                        else
                        {
                            this.thePlayer.dropPlayerItem(var5);
                        }
                    }
                }
            }
        }
    }

}
