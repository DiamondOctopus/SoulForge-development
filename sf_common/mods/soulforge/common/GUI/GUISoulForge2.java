package mods.soulforge.common.GUI;

import org.lwjgl.opengl.GL11;

import mods.soulforge.common.container.ContainerSoulForge2;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

public class GUISoulForge2 extends GuiContainer
{

    public GUISoulForge2(InventoryPlayer inventoryplayer, World world, int i, int j, int k)
    {
            super(new ContainerSoulForge2(inventoryplayer, world, i, j, k));
    }

    public void onGuiClosed()
    {
            super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer()
    {
            fontRenderer.drawString("Soul Forge Mk II", 0, -12, 4210752);
            fontRenderer.drawString("Inventory", 8, ySize - 96 - 14, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
            //int k = mc.renderEngine.getTexture("/CraftMaster/BlueprintTableGUI.png");
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            mc.renderEngine.bindTexture("/mods/soulforge/textures/gui/soulForge2GUI.png");
            xSize = 176;
            ySize = 202;
            int l = (width - xSize) / 2;
            int i1 = (height - ySize) / 2;
            drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
    }
}