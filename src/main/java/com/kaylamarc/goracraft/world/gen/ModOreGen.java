package com.kaylamarc.goracraft.world.gen;

import com.kaylamarc.goracraft.GoraCraft;
import com.kaylamarc.goracraft.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = GoraCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        // Check biome for worlds
        for (Biome biome : ForgeRegistries.BIOMES) {

            // Nether generation
            if(biome.getCategory() == Biome.Category.NETHER) {
                // for later
            }
            // The End Generation
            else if(biome.getCategory() == Biome.Category.THEEND) {
                // for later
            }
            // Overworld Generations
            else {
                // Extreme Hills Generation
                if(biome.getCategory() == Biome.Category.EXTREME_HILLS) {
                    genOre(biome, 15, 8, 5, 40,
                            OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                            ModBlocks.RUBY_ORE_BLOCK.get().getDefaultState(), 5);
                }
                // Savanna Generation
                else if(biome.getCategory() == Biome.Category.SAVANNA) {
                    genOre(biome, 3, 8, 5, 40,
                            OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                            ModBlocks.RUBY_ORE_BLOCK.get().getDefaultState(), 3);
                }
                // Swamp Generation
                else if(biome.getCategory() == Biome.Category.SWAMP) {
                    genOre(biome, 15, 8, 5, 40,
                            OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                            ModBlocks.RUBY_ORE_BLOCK.get().getDefaultState(), 7);
                }
                // Rest of Biomes generation
                else {
                    genOre(biome, 2, 8, 5, 40,
                            OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                            ModBlocks.RUBY_ORE_BLOCK.get().getDefaultState(), 2);
                }
            }
        }
    }

    // Registers to add feature (0re) to a biome
    public static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max,
                              OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockState, int size) {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockState, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }
}
