package mods.soulforge.common;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class SoulForgeWorldGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        
        switch (world.provider.dimensionId){
        case -1:
            worldGenNether();
        break;
        case 0:
            worldGenSurface(world, random, chunkX*16, chunkZ*16);
        break;
        case 1:
            worldGenEnd();
        }
        
    }
    
    public void worldGenNether(){
        
    }
    
    public void worldGenSurface(World world, Random rand, int chunkX, int chunkZ){
        //to ADD ANOTHER ORE INTO THE WORLD COPY ALL OF THE FOR STATEMENT 
        //AND CHANGE THE mods.soulforge.common.mod_soulforge.<VARIABLE FROM THE BASE CLASS>.blockID 
        //10 veins in a chunk
        for(int i = 0; i<10; i++){
            
            //16 x 16 area up to y= 64
                
                int randPosX = chunkX + rand.nextInt(16);
                int randPosY = rand.nextInt(64);
                int randPosZ = chunkZ + rand.nextInt(16);
                
            //8 in a vein max
                (new WorldGenMinable(mod_soulforge.oreMalachite.blockID, 8)).generate(world,  rand, randPosX, randPosY, randPosZ);
        }
        
        // 5 veins per chunk
        for(int i = 0; i<5; i++){
            
            //16 x 16 area up to y= 14
                
                int randPosX = chunkX + rand.nextInt(16);
                int randPosY = rand.nextInt(14);
                int randPosZ = chunkZ + rand.nextInt(16);
                
            //5 in a vein max
                (new WorldGenMinable(mod_soulforge.oreZircon.blockID, 5)).generate(world,  rand, randPosX, randPosY, randPosZ);
        }
        
    }
        
    public void worldGenEnd(){
        
    }

}
