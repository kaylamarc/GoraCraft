package com.kaylamarc.goracraft.items;

import com.kaylamarc.goracraft.GoraCraft;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;

public class Pizza extends Item {

    public Pizza() {
        super(new Item.Properties()
                .group(GoraCraft.TAB)
                .food(new Food.Builder()
                        .hunger(10)
                        .saturation(6.0f)
                        .effect(new EffectInstance(Effects.SLOWNESS, 300, 2), 1)
                        .build())
        );
    }
}