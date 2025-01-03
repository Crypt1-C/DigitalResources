package xyz.cryptix.digital_resources.Registry.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import xyz.cryptix.digital_resources.DigitalResources;
import xyz.cryptix.digital_resources.Registry.blocks.BlockRegistry;

public class DRConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> NULLIUM_ORE_KEY = registerKey("nullium_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        register(context, NULLIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, BlockRegistry.EXONULL_ORE.get().defaultBlockState(), 9));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DigitalResources.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
