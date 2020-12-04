package com.kaylamarc.goracraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

    // create an item with material properties
    public ItemBase() {
        super(new Item.Properties().group(ItemGroup.MATERIALS));
    }
}
