package xyz.cryptix.digital_resources.Datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import xyz.cryptix.digital_resources.Common.item.ModuleItem;
import xyz.cryptix.digital_resources.DigitalResources;
import xyz.cryptix.digital_resources.Registry.item.DataShardRegistry;
import xyz.cryptix.digital_resources.Registry.item.ItemRegistry;
import xyz.cryptix.digital_resources.Registry.item.ModuleRegistry;
import xyz.cryptix.digital_resources.Registry.item.UpgradeRegistry;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DigitalResources.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModuleRegistry.MODULES.forEach(this::moduleItem);
        ItemRegistry.ITEMS.getEntries().forEach(this::simpleItem);
        UpgradeRegistry.UPGRADES_REGISTRY.getEntries().forEach(this::upgradeItem);
        DataShardRegistry.DATA_SHARDS_REGISTRY.getEntries().forEach(this::dataShardItem);
    }

    private void simpleItem(RegistryObject<Item> pItem) {
        withExistingParent(pItem.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", modLoc(String.format("item/%s", pItem.getId().getPath())));
    }

    private void upgradeItem(RegistryObject<Item> pItem) {
        String item_name = pItem.getId().getPath().replace("_upgrade","");
        withExistingParent(pItem.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/upgrades/upgrade"))
                .texture("layer1", modLoc(String.format("item/upgrades/%s", item_name)));
    }

    private void dataShardItem(RegistryObject<Item> pItem) {
        withExistingParent(pItem.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/blank_data_shard"));
    }

    private void moduleItem(ModuleItem pItem) {
        String module_name = String.format("%s_module", pItem.getResourceName());
        if (pItem == ModuleRegistry.BLANK_MODULE.get()) {
            withExistingParent(module_name, mcLoc("item/generated"))
                    .texture("layer0", modLoc("item/module"));
        } else {
            String resource_type = pItem.getResourceType().getName();
            withExistingParent(module_name, mcLoc("item/generated"))
                    .texture("layer0", modLoc("item/module"))
                    .texture("layer1", modLoc(String.format("item/resources/%s", resource_type)));
        }
    }

    @SuppressWarnings("unused")
    private ItemModelBuilder handheldItem(RegistryObject<Item> pItem) {
        return withExistingParent(pItem.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(DigitalResources.MODID,"item/"+pItem.getId().getPath()));
    }
}
