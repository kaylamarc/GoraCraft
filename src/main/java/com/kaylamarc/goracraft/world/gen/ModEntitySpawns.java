package com.kaylamarc.goracraft.world.gen;

import com.kaylamarc.goracraft.init.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ModEntitySpawns {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void spawnEntities(BiomeLoadingEvent event) {

        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        // Nether spawning
        if (event.getCategory().equals(Biome.Category.NETHER)) {
            // for later
        }
        // End spawning
        else if (event.getCategory().equals(Biome.Category.THEEND)) {
            // for later
        }
        // Overworld spawning
        else {

            // do not spawn in middle of ocean
            if (!event.getCategory().equals(Biome.Category.OCEAN)) {
                event.getSpawns()
                        .withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ModEntityTypes.RACCOON.get(), 10, 1, 4));
            }
        }
    }
}
