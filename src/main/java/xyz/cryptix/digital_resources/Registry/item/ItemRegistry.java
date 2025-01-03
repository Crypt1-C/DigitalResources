package xyz.cryptix.digital_resources.Registry.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.cryptix.digital_resources.DigitalResources;
import xyz.cryptix.digital_resources.Util.DRPropreties;

import java.util.List;
import java.util.stream.Collectors;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DigitalResources.MODID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DigitalResources.MODID);

    // Items
    public static final RegistryObject<Item> EXONULL_INGOT = ITEMS.register("exonull_ingot", () -> new Item(DRPropreties.MISC_PROPRETIES));

    public static final RegistryObject<Item> RAW_EXONULL = ITEMS.register("raw_exonull", () -> new Item(DRPropreties.MISC_PROPRETIES));

    public static final RegistryObject<Item> ECLIPTIUM_INGOT = ITEMS.register("ecliptium_ingot", () -> new Item(DRPropreties.MISC_PROPRETIES.fireResistant()));

    public static final RegistryObject<Item> LOGISTEEL_INGOT = ITEMS.register("logisteel_ingot", () -> new Item(DRPropreties.MISC_PROPRETIES));
    public static final RegistryObject<Item> LOGIC_BLEND = ITEMS.register("logic_blend", () -> new Item(DRPropreties.MISC_PROPRETIES));

    public static final RegistryObject<Item> ENERGEX_BLEND = ITEMS.register("energex_blend", () -> new Item(DRPropreties.MISC_PROPRETIES));

    public static final RegistryObject<Item> ENERGEX_INGOT = ITEMS.register("energex_ingot", () -> new Item(DRPropreties.MISC_PROPRETIES));

    // MISC
    public static final RegistryObject<Item> ENDER_PEARL_DUST = ITEMS.register("ender_pearl_dust", () -> new Item(DRPropreties.MISC_PROPRETIES));

    @SuppressWarnings("unused")
    public static List<BlockItem> getAllBlockItems() {
        return ITEMS.getEntries().stream().map(RegistryObject::get).filter(item -> item instanceof BlockItem).map(item -> (BlockItem) item).filter(blockItem -> blockItem.getBlock() instanceof Block).collect(Collectors.toList());
    }

    public static void register(IEventBus eventBus) {
        DataShardRegistry.register(eventBus);
        UpgradeRegistry.register(eventBus);
        ModuleRegistry.register(eventBus);
        ITEMS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
    }
}
