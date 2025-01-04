package xyz.cryptix.digital_resources.Registry.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import xyz.cryptix.digital_resources.DigitalResources;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DigitalResources.MODID);

    @SuppressWarnings("unused")
    public static final RegistryObject<CreativeModeTab> MISC_TAB = CREATIVE_TABS.register("misc",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("item_group." + DigitalResources.MODID + ".misc"))
                    .icon(() -> new ItemStack(ItemRegistry.EXONULL_INGOT.get()))
                    .displayItems((pParameters, pOutput) -> {
                        ItemRegistry.ITEMS.getEntries().stream().map(RegistryObject::get).forEach(pOutput::accept);
                        ItemRegistry.BLOCK_ITEMS.getEntries().stream().map(RegistryObject::get).forEach(pOutput::accept);
                    })
                    .build()
    );

    @SuppressWarnings("unused")
    public static final RegistryObject<CreativeModeTab> DATA_SHARDS_TAB = CREATIVE_TABS.register("data_shards",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("item_group." + DigitalResources.MODID + ".data_shards"))
                    .icon(() -> new ItemStack(DataShardRegistry.BLANK_DATA_SHARD.get()))
                    .displayItems((pParameters, pOutput) -> DataShardRegistry.DATA_SHARDS_REGISTRY.getEntries().stream()
                            .map(RegistryObject::get)
                            .forEach(pOutput::accept))
                    .build()
    );

    @SuppressWarnings("unused")
    public static final RegistryObject<CreativeModeTab> UPGRADES_TAB = CREATIVE_TABS.register("upgrades",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("item_group." + DigitalResources.MODID + ".upgrades"))
                    .icon(() -> new ItemStack(UpgradeRegistry.BLANK_UPGRADE.get()))
                    .displayItems((pParameters, pOutput) -> UpgradeRegistry.UPGRADES_REGISTRY.getEntries().stream()
                            .map(RegistryObject::get)
                            .forEach(pOutput::accept))
                    .build()
    );

    @SuppressWarnings("unused")
    public static final RegistryObject<CreativeModeTab> MODULES_TAB = CREATIVE_TABS.register("programs",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("item_group." + DigitalResources.MODID + ".programs"))
                    .icon(() -> new ItemStack(ProgramRegistry.UNINITIALIZED_PROGRAM.get()))
                    .displayItems((pParameters, pOutput) -> ProgramRegistry.PROGRAM_REGISTRY.getEntries().stream()
                            .map(RegistryObject::get)
                            .forEach(pOutput::accept))
                    .build()
    );

    public static void register(IEventBus eventBus)
    {
        CREATIVE_TABS.register(eventBus);
    }
}
