package xyz.cryptix.digital_resources.Registry.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.cryptix.digital_resources.API.UpgradeTypes;
import xyz.cryptix.digital_resources.Common.item.UpgradeItem;
import xyz.cryptix.digital_resources.DigitalResources;
import xyz.cryptix.digital_resources.Util.DRPropreties;

import java.util.ArrayList;
import java.util.List;

import static xyz.cryptix.digital_resources.Registry.item.ItemRegistry.ITEMS;

public class UpgradeRegistry {

    public static final List<Item> UPGRADES = new ArrayList<>();

    public static final DeferredRegister<Item> UPGRADES_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DigitalResources.MODID);

    public static final RegistryObject<Item> BLANK_UPGRADE = UPGRADES_REGISTRY.register("upgrade", () -> new UpgradeItem(UPGRADES, DRPropreties.MISC_PROPRETIES));

    @SuppressWarnings("unused")
    public static RegistryObject<Item> getUpgradeByType(UpgradeTypes pType) {
        return UPGRADES_REGISTRY.getEntries().stream().filter(itemRegistryObject -> itemRegistryObject.getId().getPath().equals(pType.getUpgradeType()+"_upgrade")).findFirst().get();
    }

    public static void registerUpgrades() {
        for (UpgradeTypes upgrade : UpgradeTypes.values()) {
            UPGRADES_REGISTRY.register(String.format("%s_upgrade", upgrade.getUpgradeType()), () -> new UpgradeItem(UPGRADES, DRPropreties.MISC_PROPRETIES));
        }
    }

    public static void register(IEventBus eventBus) {
        registerUpgrades();
        UPGRADES_REGISTRY.register(eventBus);
    }
}
