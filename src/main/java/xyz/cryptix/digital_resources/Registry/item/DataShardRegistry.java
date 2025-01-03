package xyz.cryptix.digital_resources.Registry.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.cryptix.digital_resources.API.DResource;
import xyz.cryptix.digital_resources.Common.item.DataShardItem;
import xyz.cryptix.digital_resources.DigitalResources;
import xyz.cryptix.digital_resources.Util.DRPropreties;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataShardRegistry {

    public static final List<DataShardItem> DATA_SHARDS = new ArrayList<>();

    public static final DeferredRegister<Item> DATA_SHARDS_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DigitalResources.MODID);

    public static final RegistryObject<Item> BLANK_DATA_SHARD = DATA_SHARDS_REGISTRY.register("data_shard", () -> new DataShardItem(DATA_SHARDS, DRPropreties.MISC_PROPRETIES, 0xffffff));

    @SuppressWarnings("unused")
    public static RegistryObject<Item> getDataShardByResource(DResource pResource) {
        return DATA_SHARDS_REGISTRY.getEntries().stream().filter(itemRegistryObject -> itemRegistryObject.getId().getPath().equals(pResource.getResourceName()+"_data_shard")).findFirst().get();
    }

    private static void registerDataShards() {
        for (DResource resource : DResource.values()) {
            DATA_SHARDS_REGISTRY.register(String.format("%s_data_shard", resource.getResourceName()), () -> new DataShardItem(DATA_SHARDS, DRPropreties.MISC_PROPRETIES, resource.getResourceColor()));
        }
    }

    public static void register(IEventBus eventBus) {
        registerDataShards();
        DATA_SHARDS_REGISTRY.register(eventBus);
    }
}
