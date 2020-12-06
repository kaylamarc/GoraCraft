package com.kaylamarc.goracraft.items;

import com.kaylamarc.goracraft.GoraCraft;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Cereal extends Item {

    public Cereal() {
        super(new Item.Properties()
                .group(GoraCraft.TAB)
                .food(new Food.Builder()
                        .hunger(6)
                        .saturation(1.7f)
                        .setAlwaysEdible()
                        .build())
        );
    }
}
