package mods.soulforge.common.handlers;

import mods.soulforge.common.TileEntitySoulInfuser;
import mods.soulforge.common.GUI.GUISoulInfuser;
import mods.soulforge.common.container.ContainerSoulInfuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;




//this is for chaos furnace
public class GuiHandler implements IGuiHandler{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
        
        if(tile_entity instanceof TileEntitySoulInfuser){
            return new ContainerSoulInfuser(player.inventory, (TileEntitySoulInfuser) tile_entity);
        }
        
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
        if(tile_entity instanceof TileEntitySoulInfuser){
            return new GUISoulInfuser(player.inventory, (TileEntitySoulInfuser) tile_entity);
        }
        
        
        return null;
    }

}
