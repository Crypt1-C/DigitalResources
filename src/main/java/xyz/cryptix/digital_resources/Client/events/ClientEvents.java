package xyz.cryptix.digital_resources.Client.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.cryptix.digital_resources.DigitalResources;
import xyz.cryptix.digital_resources.Registry.item.DataShardRegistry;
import xyz.cryptix.digital_resources.Registry.item.ProgramRegistry;

@Mod.EventBusSubscriber(modid = DigitalResources.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onItemColorHandlerEvent(final RegisterColorHandlersEvent.Item event) {
        DataShardRegistry.DATA_SHARDS.forEach(shard -> event.register(shard::getColor, shard));
        ProgramRegistry.PROGRAMS.forEach(module -> event.register(module::getColor, module));
    }

}