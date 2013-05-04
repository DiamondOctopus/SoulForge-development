package mods.soulforge.common.blocks;

import mods.soulforge.common.mod_soulforge;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoulForge2 extends Block
{
    @SideOnly(Side.CLIENT)
    private Icon field_94385_a;
    @SideOnly(Side.CLIENT)
    private Icon field_94384_b;

    public SoulForge2(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(mod_soulforge.tabSoulForge);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return par1 == 1 ? this.field_94385_a : (par1 == 0 ? Block.blockSteel.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.field_94384_b));
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("soulforge:soulForge2_side2"); //front
        this.field_94385_a = par1IconRegister.registerIcon("soulforge:soulForge2_top"); //top
        this.field_94384_b = par1IconRegister.registerIcon("soulforge:soulForge2_side"); //side
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (!player.isSneaking()){
            player.openGui(mod_soulforge.instance, 2, world, x, y, z);
            return true;
            }
        else{
            return false;
        }
    }
}
