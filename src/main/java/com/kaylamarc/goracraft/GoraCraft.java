package com.kaylamarc.goracraft;

import com.kaylamarc.goracraft.init.ModBlocks;
import com.kaylamarc.goracraft.init.ModItems;
import com.kaylamarc.goracraft.world.gen.ModOreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("goracraft")
public class GoraCraft
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "goracraft";

    public GoraCraft() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register mod blocks and items
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        ModOreGen.registerOres();
    }

    private void doClientStuff(final FMLClientSetupEvent event) { }

    /**
     * add GoraCraft creative tab
     */
    public static final ItemGroup TAB = new ItemGroup("GoraCraftTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.RUBY.get());
        }
    };

}
