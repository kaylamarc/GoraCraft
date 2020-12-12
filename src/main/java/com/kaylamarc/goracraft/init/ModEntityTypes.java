package com.kaylamarc.goracraft.init;

import com.kaylamarc.goracraft.GoraCraft;
import com.kaylamarc.goracraft.entities.RaccoonEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, GoraCraft.MOD_ID);

    // Entity Types
    public static final RegistryObject<EntityType<RaccoonEntity>> RACCOON = ENTITY_TYPES.register("raccoon",
            () -> EntityType.Builder.create(RaccoonEntity::new, EntityClassification.CREATURE)
                    .size(0.6f, 0.7f)
                    .build(new ResourceLocation(GoraCraft.MOD_ID, "raccoon").toString()));
}
