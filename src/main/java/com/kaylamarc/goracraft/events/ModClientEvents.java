package com.kaylamarc.goracraft.events;

import com.kaylamarc.goracraft.GoraCraft;
import com.kaylamarc.goracraft.util.RegistryHandler;
import net.minecraft.client.gui.screen.inventory.CraftingScreen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// Client events
@Mod.EventBusSubscriber(modid = GoraCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    // if player jumps with stick make block under then ruby block
    @SubscribeEvent // LivingEntity#func_233580_cy_() ---> LivingEntity#getPosition()
    public static void onJumpWithStick(LivingEvent.LivingJumpEvent event) {

        // get player
        LivingEntity player = event.getEntityLiving();

        // if player that jumped has stick in hand
        if (player.getHeldItemMainhand().getItem() == Items.STICK) {
            GoraCraft.LOGGER.info("Player tried to jump with a stick!"); // print info to console
            World world = player.getEntityWorld(); // get the world

            // set block under player to ruby block
            world.setBlockState(player.func_233580_cy_().add(0, -1, 0), RegistryHandler.RUBY_BLOCK.get().getDefaultState());
        }
    }

    // if player attacks cat with cereal, it makes the cat glow
    @SubscribeEvent
    public static void onDamageCat(AttackEntityEvent event) {
        // if attack entity with cereal
        if (event.getEntityLiving().getHeldItemMainhand().getItem() == RegistryHandler.CEREAL.get()) {

            // check if target is alive
            if (event.getTarget().isAlive()) {
                LivingEntity target = (LivingEntity) event.getTarget();

                // if target is a cat
                if (target instanceof CatEntity) {

                    PlayerEntity player = event.getPlayer();
                    // make cat glow
                    target.addPotionEffect(new EffectInstance(Effects.GLOWING, 10 * 20));

                    // send message to player
                    if (!event.getPlayer().getEntityWorld().isRemote()) {
                        String msg = TextFormatting.GREEN + "The cat is now supercharged!";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                    }
                }
            }
        }
    }

    // Disable opening crafting table
    @SubscribeEvent
    public static void onCraftingTable(GuiOpenEvent event) {
        if (event.isCancelable()) {
            if(event.getGui() instanceof CraftingScreen) {
                event.setCanceled(true);
                GoraCraft.LOGGER.info("Player tried to open a crafting table... dummy!");
            }
        }
    }
}
