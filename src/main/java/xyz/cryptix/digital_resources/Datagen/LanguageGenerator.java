package xyz.cryptix.digital_resources.Datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.text.WordUtils;
import xyz.cryptix.digital_resources.DigitalResources;
import xyz.cryptix.digital_resources.Registry.item.DataShardRegistry;
import xyz.cryptix.digital_resources.Registry.item.ItemRegistry;
import xyz.cryptix.digital_resources.Registry.item.ModuleRegistry;
import xyz.cryptix.digital_resources.Registry.item.UpgradeRegistry;

import java.util.Objects;

public class LanguageGenerator extends LanguageProvider {
    public LanguageGenerator(PackOutput output, String locale) {
        super(output, DigitalResources.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        ItemRegistry.ITEMS.getEntries().stream()
                .map(RegistryObject::get)
                .map(ForgeRegistries.ITEMS::getKey)
                .filter(Objects::nonNull)
                .map(ResourceLocation::getPath)
                .forEach(path -> add(String.format("item.digital_resources.%s", path), WordUtils.capitalize(path.replace("_"," "))));

        ItemRegistry.BLOCK_ITEMS.getEntries().stream()
                .map(RegistryObject::get)
                .map(ForgeRegistries.ITEMS::getKey)
                .filter(Objects::nonNull)
                .map(ResourceLocation::getPath)
                .forEach(path -> add(String.format("block.digital_resources.%s", path), WordUtils.capitalize(path.replace("_"," "))));

        DataShardRegistry.DATA_SHARDS_REGISTRY.getEntries().stream()
                .map(RegistryObject::get)
                .map(ForgeRegistries.ITEMS::getKey)
                .filter(Objects::nonNull)
                .map(ResourceLocation::getPath)
                .forEach(path -> add(String.format("item.digital_resources.%s", path), WordUtils.capitalize(path.replace("_"," "))));

        UpgradeRegistry.UPGRADES_REGISTRY.getEntries().stream()
                .map(RegistryObject::get)
                .map(ForgeRegistries.ITEMS::getKey)
                .filter(Objects::nonNull)
                .map(ResourceLocation::getPath)
                .forEach(path -> add(String.format("item.digital_resources.%s", path), WordUtils.capitalize(path.replace("_"," "))));

        ModuleRegistry.MODULES_REGISTRY.getEntries().stream()
                .map(RegistryObject::get)
                .map(ForgeRegistries.ITEMS::getKey)
                .filter(Objects::nonNull)
                .map(ResourceLocation::getPath)
                .forEach(path -> add(String.format("item.digital_resources.%s", path), WordUtils.capitalize(path.replace("_"," "))));

        add("item_group.digital_resources.data_shards", "Digital Resources: Data Shards");
        add("item_group.digital_resources.modules", "Digital Resources: Modules");
        add("item_group.digital_resources.upgrades", "Digital Resources: Upgrades");
        add("item_group.digital_resources.misc", "Digital Resources: Misc");

        add("item.tooltip.shift", "Press [Shift] For More Info");

        add("item.data_shard.tooltip", "Contains Resource Data For: ");
        add("item.module.tooltip", "Contains Resource Data For: ");

        add("item.upgrade.blank.tooltip", "Just a Blank Upgrade");
        add("item.upgrade.speed.tooltip", "Upgrades Machine Speed By x2");
        add("item.upgrade.stack.tooltip", "Upgrades Machine Output By x4");
        add("item.upgrade.energy.tooltip", "Machine No Longer Requires Energy");
        add("item.digital_resources.nullium_ore.JEIdesc", "Can Only Be Found In The End");
        add("item.digital_resources.voidium_ingot.jei", "Obtained By Right Clicking Nullium Ingot On Bedrock");

        add("digital_resources.jei.resource_simulator","Resource Simulating");
        add("digital_resources.jei.encoder","Resource Encoding");

        //add("digital_resources.ritual.success","The Devs Relent, Offering Accepted");
        //add("digital_resources.ritual.fail","The Devs Remain Silent, Offering Rejected.");

        /*
        add("resource_simulator.gui.module","Module: ");
        add("resource_simulator.gui.count","Count: ");
        add("resource_simulator.gui.energy","RF/FE Cost: ");
        add("resource_simulator.gui.no_module","Insert Module To Begin Simulation...");

        add("resource_simulator.run.0", "> Launching Simulation");
        add("resource_simulator.run.1", "> Simulation ID: ");
        add("resource_simulator.run.2", "> Loading Resource From Module");
        add("resource_simulator.run.3", "> Assessing Resource Value");
        add("resource_simulator.run.4", "> Discovering Composition");
        add("resource_simulator.run.5", "> Materializing Data");
        add("resource_simulator.run.6", "> Processing Results...");

        add("sound.resource_simulator.working","Resource Simulator Working");
        add("sound.resource_simulator.done","Resource Simulator Done");
        add("sound.resource_encoder.working","Resource Encoder Working");
        */
    }
}
