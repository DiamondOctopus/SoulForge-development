package mods.soulforge.common.GUI;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mods.soulforge.common.TileEntitySoulInfuser;
import mods.soulforge.common.container.ContainerSoulInfuser;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.StatCollector;
import net.minecraft.client.renderer.RenderEngine;

@SideOnly(Side.CLIENT)
public class GUISoulInfuser extends GuiContainer
{
    private TileEntitySoulInfuser infuserInventory;

    public GUISoulInfuser(InventoryPlayer par1InventoryPlayer, TileEntitySoulInfuser par2TileEntityFurnace)
    {
        super(new ContainerSoulInfuser(par1InventoryPlayer, par2TileEntityFurnace));
        this.infuserInventory = par2TileEntityFurnace;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        String s = this.infuserInventory.isInvNameLocalized() ? this.infuserInventory.getInvName() : StatCollector.translateToLocal(this.infuserInventory.getInvName());
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        /*this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);*/
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/mods/soulforge/textures/gui/soulinfuserGUI.png");
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        if (this.infuserInventory.isBurning())
        {
            i1 = this.infuserInventory.getBurnTimeRemainingScaled(14);
            //this is the burning flames
            this.drawTexturedModalRect(k+5, l+6+14-i1, 176, 14-i1, 14, i1);
        }

        i1 = this.infuserInventory.getCookProgressScaled(70);
        //this is the arrow
        this.drawTexturedModalRect(k + 44, l + 10, 176, 14, 60, i1);
        this.drawTexturedModalRect(k + 104, l + 10, 176, 84, 58, i1);
    }
}