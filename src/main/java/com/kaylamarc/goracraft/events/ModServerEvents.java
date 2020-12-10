package com.kaylamarc.goracraft.events;

import com.kaylamarc.goracraft.GoraCraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// server side events
@Mod.EventBusSubscriber(modid = GoraCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class ModServerEvents {

    @SubscribeEvent
    public static void onServerChat(ServerChatEvent event) { }
}
