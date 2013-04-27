package mods.soulforge.common;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class LivingDrops {
    
    public static double rand;

    @ForgeSubscribe
    public void onEntityDrop(LivingDropsEvent event) {
        
        if (event.source.getDamageType().equals("player")) {
            
            rand = Math.random();
            
            if (event.entityLiving instanceof EntityCreeper) {
                // 5 per cent chance of drop
                if (rand <0.05d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.elemSouls, 1, 0), 0.0F);
                
                }
                //15 percent chance
                if (rand <0.15d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.lowSoul, 1), 1);
                    
                }
            }
            if (event.entityLiving instanceof EntitySkeleton) {
                // 5 per cent chance of drop
                if (rand <0.05d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.elemSouls, 1, 1), 0.0F);
                
                }
                if (rand <0.15d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.lowSoul, 1), 1);
                    
                }
            }
            if (event.entityLiving instanceof EntityZombie) {
                // 5 per cent chance of drop
                if (rand <0.05d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.elemSouls, 1, 2), 0.0F);
                
                }
                if (rand <0.15d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.lowSoul, 1), 1);
                    
                }
            }
            if (event.entityLiving instanceof EntitySpider) {
                // 5 per cent chance of drop
                if (rand <0.05d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.elemSouls, 1, 3), 0.0F);
                
                }
                if (rand <0.15d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.lowSoul, 1), 1);
                    
                }
            }
            if (event.entityLiving instanceof EntityGhast) {
                // 5 per cent chance of drop
                if (rand <0.05d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.elemSouls, 1, 4), 0.0F);
                
                }
                if (rand <0.15d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.lowSoul, 1), 1);
                    
                }
            }
            if (event.entityLiving instanceof EntityBlaze) {
                // 5 per cent chance of drop
                if (rand <0.05d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.elemSouls, 1, 5), 0.0F);
                
                }
                if (rand <0.15d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.lowSoul, 1), 1);
                    
                }
            }
            if (event.entityLiving instanceof EntityEnderman) {
                // 5 per cent chance of drop
                if (rand <0.05d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.elemSouls, 1, 6), 0.0F);
                
                }
                if (rand <0.15d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.lowSoul, 1), 1);
                    
                }
            }
            if (event.entityLiving instanceof EntitySlime) {
                // 5 per cent chance of drop
                if (rand <0.05d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.elemSouls, 1, 7), 0.0F);
                
                }
                if (rand <0.15d) {
                    
                    event.entityLiving.entityDropItem(new ItemStack(mod_soulforge.lowSoul, 1), 1);
                    
                }
            }
            
        }
    
    }
    
}
