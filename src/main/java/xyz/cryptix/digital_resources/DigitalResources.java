package xyz.cryptix.digital_resources;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import xyz.cryptix.digital_resources.Registry.blocks.BlockRegistry;
import xyz.cryptix.digital_resources.Registry.item.CreativeTabRegistry;
import xyz.cryptix.digital_resources.Registry.item.ItemRegistry;

@Mod(DigitalResources.MODID)
public class DigitalResources {

    public static final String MODID = "digital_resources";

    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogUtils.getLogger();

    public DigitalResources() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.register(modEventBus);
        BlockRegistry.register(modEventBus);
        CreativeTabRegistry.register(modEventBus);
    }
}
