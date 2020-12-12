package com.kaylamarc.goracraft.client.render;

import com.kaylamarc.goracraft.GoraCraft;
import com.kaylamarc.goracraft.client.model.RaccoonModel;
import com.kaylamarc.goracraft.entities.RaccoonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.util.ResourceLocation;

public class RaccoonRenderer extends MobRenderer<RaccoonEntity, RaccoonModel<RaccoonEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(GoraCraft.MOD_ID, "textures/entity/raccoon.png");

    public RaccoonRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RaccoonModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(RaccoonEntity entity) {
        return TEXTURE;
    }
}
