package com.kaylamarc.goracraft.init;

import com.kaylamarc.goracraft.GoraCraft;
import com.kaylamarc.goracraft.blocks.Oven;
import com.kaylamarc.goracraft.blocks.RubyBlock;
import com.kaylamarc.goracraft.blocks.RubyOreBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GoraCraft.MOD_ID);

    // Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> RUBY_ORE_BLOCK = BLOCKS.register("ruby_ore_block", RubyOreBlock::new);
    public static final RegistryObject<Block> OVEN = BLOCKS.register("oven", Oven::new);
}
