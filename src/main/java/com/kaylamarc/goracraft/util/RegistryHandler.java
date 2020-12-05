package com.kaylamarc.goracraft.util;

import com.kaylamarc.goracraft.GoraCraft;
import com.kaylamarc.goracraft.blocks.BlockItemBase;
import com.kaylamarc.goracraft.blocks.RubyBlock;
import com.kaylamarc.goracraft.blocks.RubyOreBlock;
import com.kaylamarc.goracraft.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// all items, blocks, items (in deferred registries)
public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, GoraCraft.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, GoraCraft.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus()); // register items
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus()); // register blocks
    }

    // Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);

    // Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> RUBY_ORE_BLOCK = BLOCKS.register("ruby_ore_block", RubyOreBlock::new);

    // Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block_item", () -> new BlockItemBase(RUBY_BLOCK.get()));
    public static final RegistryObject<Item> RUBY_ORE_BLOCK_ITEM = ITEMS.register("ruby_ore_block_item", () -> new BlockItemBase(RUBY_ORE_BLOCK.get()));
}
