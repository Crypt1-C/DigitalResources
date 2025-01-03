package xyz.cryptix.digital_resources.Registry.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.cryptix.digital_resources.API.DResource;
import xyz.cryptix.digital_resources.Common.item.DataShardItem;
import xyz.cryptix.digital_resources.Common.item.ModuleItem;
import xyz.cryptix.digital_resources.DigitalResources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleRegistry {
    public static final List<ModuleItem> MODULES = new ArrayList<>();

    public static final DeferredRegister<Item> MODULES_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DigitalResources.MODID);

    public static final RegistryObject<Item> BLANK_MODULE = MODULES_REGISTRY.register("blank_module", () -> new ModuleItem(MODULES, null, null));

    private static void registerModules() {
        for (DResource resource : DResource.values()) {
            MODULES_REGISTRY.register(String.format("%s_module", resource.getResourceName()), () -> new ModuleItem(MODULES, resource, resource.getResourceType()));
        }
    }

    public static void register(IEventBus eventBus) {
        registerModules();
        MODULES_REGISTRY.register(eventBus);
    }
}
