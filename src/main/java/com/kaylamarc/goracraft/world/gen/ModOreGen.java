package com.kaylamarc.goracraft.world.gen;

import com.kaylamarc.goracraft.GoraCraft;
import com.kaylamarc.goracraft.init.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class ModOreGen {

    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();

    public static void registerOres() {
        // Overworld Ore Register
        overworldOres.add(register("ruby_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.RUBY_ORE_BLOCK.get().getDefaultState(), 7)) //Vein Size
                .range(16).square() // Spawn height start
                .func_242731_b(64))); // Chunk spawn frequency
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void generateOres(BiomeLoadingEvent event) {

        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        // FOR LATER
        // Nether generation
        if (event.getCategory().equals(Biome.Category.NETHER)) {
//            for(ConfiguredFeature<?, ?> ore : netherOres){
//                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
//            }
        }

        // FOR LATER
        // End generation
        if (event.getCategory().equals(Biome.Category.THEEND)) {
//            for(ConfiguredFeature<?, ?> ore : endOres){
//                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
//            }
        }

        // Overworld generation
        for (ConfiguredFeature<?, ?> ore : overworldOres) {
            if (ore != null) {
                generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, GoraCraft.MOD_ID + ":" + name, configuredFeature);
    }
}
