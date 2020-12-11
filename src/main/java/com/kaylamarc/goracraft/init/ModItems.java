package com.kaylamarc.goracraft.init;

import com.kaylamarc.goracraft.GoraCraft;
import com.kaylamarc.goracraft.blocks.BlockItemBase;
import com.kaylamarc.goracraft.items.Cereal;
import com.kaylamarc.goracraft.items.Cheese;
import com.kaylamarc.goracraft.items.ItemBase;
import com.kaylamarc.goracraft.items.Pizza;
import com.kaylamarc.goracraft.util.enums.ModArmorMaterial;
import com.kaylamarc.goracraft.util.enums.ModItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;



public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GoraCraft.MOD_ID);

    // Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<Cereal> CEREAL = ITEMS.register("cereal", Cereal::new);
    public static final RegistryObject<Cheese> CHEESE = ITEMS.register("cheese", Cheese::new);
    public static final RegistryObject<Pizza> PIZZA = ITEMS.register("pizza", Pizza::new);

    // Tools
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModItemTier.RUBY, 2, -1.7f, new Item.Properties().group(GoraCraft.TAB)));
    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModItemTier.RUBY, 0, -2.8f, new Item.Properties().group(GoraCraft.TAB)));
    public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModItemTier.RUBY, 6, -3.1f, new Item.Properties().group(GoraCraft.TAB)));
    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModItemTier.RUBY, 0.6f, -3.0f, new Item.Properties().group(GoraCraft.TAB)));
    public static final RegistryObject<HoeItem> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModItemTier.RUBY, -3,-1.0f, new Item.Properties().group(GoraCraft.TAB)));

    // Armor
    public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(GoraCraft.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(GoraCraft.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(GoraCraft.TAB)));
    public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(GoraCraft.TAB)));

    // Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block_item",
            () -> new BlockItemBase(ModBlocks.RUBY_BLOCK.get()));
    public static final RegistryObject<Item> RUBY_ORE_BLOCK_ITEM = ITEMS.register("ruby_ore_block_item",
            () -> new BlockItemBase(ModBlocks.RUBY_ORE_BLOCK.get()));
    public static final RegistryObject<Item> OVEN_BLOCK_ITEM = ITEMS.register("oven_block_item",
            () -> new BlockItemBase(ModBlocks.OVEN.get()));
}