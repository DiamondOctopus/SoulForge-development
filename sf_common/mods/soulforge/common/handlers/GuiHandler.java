package mods.soulforge.common.handlers;

import mods.soulforge.common.TileEntitySoulInfuser;
import mods.soulforge.common.mod_soulforge;
import mods.soulforge.common.GUI.GUISoulForge;
import mods.soulforge.common.GUI.GUISoulForge2;
import mods.soulforge.common.GUI.GUISoulInfuser;
import mods.soulforge.common.container.ContainerSoulForge;
import mods.soulforge.common.container.ContainerSoulForge2;
import mods.soulforge.common.container.ContainerSoulInfuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;




//this is for chaos furnace
public class GuiHandler implements IGuiHandler{

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {

        TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

        switch(id)
        {

            case 0: return new ContainerSoulInfuser(player.inventory, (TileEntitySoulInfuser) tile_entity);
            case 1: return id == 1 && world.getBlockId(x, y, z) == mod_soulforge.soulForge.blockID ? new ContainerSoulForge(player.inventory, world, x, y, z) : null;
            case 2: return id == 2 && world.getBlockId(x, y, z) == mod_soulforge.soulForge2.blockID ? new ContainerSoulForge2(player.inventory, world, x, y, z) : null;
        }
        return null;
    }


    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {

        TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

        switch(id)
        {

            case 0: return new GUISoulInfuser(player.inventory, (TileEntitySoulInfuser) tile_entity);
            case 1: return id == 1 && world.getBlockId(x, y, z) == mod_soulforge.soulForge.blockID ? new GUISoulForge(player.inventory, world, x, y, z) : null;
            case 2: return id == 2 && world.getBlockId(x, y, z) == mod_soulforge.soulForge2.blockID ? new GUISoulForge2(player.inventory, world, x, y, z) : null;
        }
        return null;
    }


}
