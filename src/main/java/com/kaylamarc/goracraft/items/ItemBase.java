package com.kaylamarc.goracraft.items;

import com.kaylamarc.goracraft.GoraCraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

    // create an item with material properties and put it in the custom creative tab
    public ItemBase() {
        super(new Item.Properties().group(GoraCraft.TAB));
    }
}
