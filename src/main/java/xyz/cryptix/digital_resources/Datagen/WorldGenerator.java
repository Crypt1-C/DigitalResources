package xyz.cryptix.digital_resources.Datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.cryptix.digital_resources.DigitalResources;
import xyz.cryptix.digital_resources.Registry.worldgen.DRConfiguredFeatures;
import xyz.cryptix.digital_resources.Registry.worldgen.DRBiomeModifier;
import xyz.cryptix.digital_resources.Registry.worldgen.DRPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class WorldGenerator extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, DRConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, DRPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, DRBiomeModifier::bootstrap);

    public WorldGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(DigitalResources.MODID));
    }
}
