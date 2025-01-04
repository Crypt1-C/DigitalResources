package xyz.cryptix.digital_resources.Registry.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.cryptix.digital_resources.API.UpgradeType;
import xyz.cryptix.digital_resources.Common.item.UpgradeItem;
import xyz.cryptix.digital_resources.DigitalResources;
import xyz.cryptix.digital_resources.Util.DRPropreties;

import java.util.ArrayList;
import java.util.List;

public class UpgradeRegistry {

    public static final List<Item> UPGRADES = new ArrayList<>();

    public static final DeferredRegister<Item> UPGRADES_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DigitalResources.MODID);

    public static final RegistryObject<Item> BLANK_UPGRADE = UPGRADES_REGISTRY.register("upgrade", () -> new UpgradeItem(UPGRADES, null));

    @SuppressWarnings("unused")
    public static RegistryObject<Item> getUpgradeByType(UpgradeType pType) {
        return UPGRADES_REGISTRY.getEntries().stream().filter(itemRegistryObject -> itemRegistryObject.getId().getPath().equals(pType.getUpgradeName()+"_upgrade")).findFirst().get();
    }

    public static void registerUpgrades() {
        for (UpgradeType upgrade : UpgradeType.values()) {
            UPGRADES_REGISTRY.register(String.format("%s_upgrade", upgrade.getUpgradeName()), () -> new UpgradeItem(UPGRADES, upgrade));
        }
    }

    public static void register(IEventBus eventBus) {
        registerUpgrades();
        UPGRADES_REGISTRY.register(eventBus);
    }
}
