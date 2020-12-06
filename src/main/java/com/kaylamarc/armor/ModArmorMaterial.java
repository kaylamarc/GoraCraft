package com.kaylamarc.armor;

import com.kaylamarc.goracraft.GoraCraft;
import com.kaylamarc.goracraft.util.RegistryHandler;
import net.minecraft.client.audio.ISoundEventListener;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {

    // Ruby Armor set enum
    RUBY(GoraCraft.MOD_ID + ":ruby", 27, new int[]{4, 6, 7, 4}, 18,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {return Ingredient.fromItems(RegistryHandler.RUBY.get());});

    private static final int[] MAX_DAMAGE_ARRAY = {11, 16, 15, 13};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmt;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;

    ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmt, int enchantability,
                            SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmt = damageReductionAmt;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;

    }

    /**
     * calculates and returns armor's pieces durability
     */
    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    /**
     * gets the damage reduction
     */
    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmt[slotIn.getIndex()];
    }

    /**
     * odds for how easy it is to get good enchants
     */
    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    /**
     * sound played when armor equipped
     */
    @Nonnull
    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    /**
     * ingredient used to repair the armor
     */
    @Nonnull
    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    /**
     * name of the armor piece
     */
    @OnlyIn(Dist.CLIENT) // only access this value client side
    @Override
    @Nonnull
    public String getName() {
        return this.name;
    }

    /**
     * how tough the armor is; how much it will protect player
     */
    @Override
    public float getToughness() {
        return this.toughness;
    }
}
