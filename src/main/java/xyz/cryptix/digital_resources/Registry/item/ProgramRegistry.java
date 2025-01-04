package xyz.cryptix.digital_resources.Registry.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.cryptix.digital_resources.API.DResource;
import xyz.cryptix.digital_resources.Common.item.ProgramItem;
import xyz.cryptix.digital_resources.DigitalResources;

import java.util.ArrayList;
import java.util.List;

public class ProgramRegistry {
    public static final List<ProgramItem> PROGRAMS = new ArrayList<>();

    public static final DeferredRegister<Item> PROGRAM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DigitalResources.MODID);

    public static final RegistryObject<Item> UNINITIALIZED_PROGRAM = PROGRAM_REGISTRY.register("uninitialized_program", () -> new ProgramItem(PROGRAMS, null));

    private static void registerPrograms() {
        for (DResource resource : DResource.values()) {
            PROGRAM_REGISTRY.register(String.format("%s_program", resource.getResourceName()), () -> new ProgramItem(PROGRAMS, resource));
        }
    }

    public static void register(IEventBus eventBus) {
        registerPrograms();
        PROGRAM_REGISTRY.register(eventBus);
    }
}
