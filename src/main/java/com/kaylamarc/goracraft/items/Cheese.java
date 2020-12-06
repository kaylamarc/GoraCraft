package com.kaylamarc.goracraft.items;

import com.kaylamarc.goracraft.GoraCraft;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class Cheese extends Item {

    public Cheese() {
        super(new Item.Properties()
                .group(GoraCraft.TAB)
                .food(new Food.Builder()
                        .hunger(2)
                        .saturation(0.0f)
                        .build())
        );
    }
}