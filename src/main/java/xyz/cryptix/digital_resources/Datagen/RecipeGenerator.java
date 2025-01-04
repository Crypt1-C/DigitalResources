package xyz.cryptix.digital_resources.Datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import xyz.cryptix.digital_resources.Common.item.ProgramItem;
import xyz.cryptix.digital_resources.Registry.blocks.BlockRegistry;
import xyz.cryptix.digital_resources.Registry.item.DataShardRegistry;
import xyz.cryptix.digital_resources.Registry.item.ItemRegistry;
import xyz.cryptix.digital_resources.Registry.item.ProgramRegistry;
import xyz.cryptix.digital_resources.Registry.item.UpgradeRegistry;

import java.util.List;
import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {
    private static final TagKey<Item> ENDER_PEARL_DUST_TAG = ItemTags.create(new ResourceLocation("forge", "dusts/ender_pearl"));

    public RecipeGenerator(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        // ecliptium block
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ItemRegistry.ECLIPTIUM_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, BlockRegistry.ECLIPTIUM_BLOCK.get().asItem());

        // energex block
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ItemRegistry.ENERGEX_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, BlockRegistry.ENERGEX_BLOCK.get().asItem());

        // exonull block
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ItemRegistry.EXONULL_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, BlockRegistry.EXONULL_BLOCK.get().asItem());

        // exonull block
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ItemRegistry.LOGISTEEL_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, BlockRegistry.LOGISTEEL_BLOCK.get().asItem());

        // raw exonull block
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ItemRegistry.RAW_EXONULL.get(), RecipeCategory.BUILDING_BLOCKS, BlockRegistry.RAW_EXONULL_BLOCK.get().asItem());

        //exonull from (exonull ore / raw exonull)

        oreSmelting(consumer, List.of(BlockRegistry.EXONULL_ORE.get()), RecipeCategory.MISC, ItemRegistry.EXONULL_INGOT.get(),0.8f,250, "exonull");
        oreBlasting(consumer, List.of(BlockRegistry.EXONULL_ORE.get()), RecipeCategory.MISC, ItemRegistry.EXONULL_INGOT.get(),0.8f,250, "exonull");

        oreSmelting(consumer, List.of(ItemRegistry.RAW_EXONULL.get()), RecipeCategory.MISC, ItemRegistry.EXONULL_INGOT.get(),1.7f,300, "exonull");
        oreBlasting(consumer, List.of(ItemRegistry.RAW_EXONULL.get()), RecipeCategory.MISC, ItemRegistry.EXONULL_INGOT.get(),2.4f,150, "exonull");

        // energex ingot
        smeltingResultFromBase(consumer, ItemRegistry.ENERGEX_INGOT.get(), ItemRegistry.ENERGEX_BLEND.get());

        // Blank Module
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ProgramRegistry.UNINITIALIZED_PROGRAM.get(), 1)
                .define('#', ItemRegistry.EXONULL_INGOT.get())
                .define('*', Items.GOLD_NUGGET)
                .define('Q', Items.QUARTZ)
                .define('G', BlockRegistry.GLITCH_BLOCK.get())
                .pattern("###")
                .pattern("QG*")
                .pattern("###")
                .unlockedBy("has_exonull", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.EXONULL_INGOT.get()).build()))
                .save(consumer);

        // Modules recipes
        ProgramRegistry.PROGRAMS.stream().filter(programItem -> !programItem.equals(ProgramRegistry.UNINITIALIZED_PROGRAM.get())).forEach(module -> moduleRecipe(consumer, module));

        // Blank Upgrade
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UpgradeRegistry.BLANK_UPGRADE.get(), 1)
                .define('#', ItemRegistry.EXONULL_INGOT.get())
                .define('N', Items.NETHERITE_INGOT)
                .pattern("###")
                .pattern("#N#")
                .pattern("###")
                .unlockedBy("has_exonull", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.EXONULL_INGOT.get()).build()))
                .save(consumer);

        // Upgrades recipes
        UpgradeRegistry.UPGRADES_REGISTRY.getEntries().forEach(upgrade -> { if (!upgrade.equals(UpgradeRegistry.BLANK_UPGRADE)) { upgradeRecipe(consumer, upgrade); } });

        // LOGISTEEL BLEND
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.LOGIC_BLEND.get(), 1)
                .requires(Items.REDSTONE)
                .requires(ItemRegistry.ENDER_PEARL_DUST.get())
                .unlockedBy("has_ender_dust", inventoryTrigger(ItemPredicate.Builder.item().of(ENDER_PEARL_DUST_TAG).build()))
                .save(consumer);

        // ENERGETIC BLEND
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.ENERGEX_BLEND.get(), 3)
                .requires(ItemRegistry.EXONULL_DUST.get())
                .requires(ItemRegistry.GOLD_DUST.get())
                .requires(ItemRegistry.COPPER_DUST.get())
                .requires(Items.BLAZE_POWDER)
                .requires(Items.GLOWSTONE_DUST)
                .requires(Items.REDSTONE)
                .unlockedBy("has_exonull_dust", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.EXONULL_DUST.get()).build()))
                .save(consumer);

        // Missing Block
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BlockRegistry.GLITCH_BLOCK.get(), 1)
                .define('X', BlockRegistry.EXONULL_BLOCK.get())
                .define('#', BlockRegistry.ECLIPTIUM_BLOCK.get())
                .pattern("X#")
                .pattern("#X")
                .unlockedBy("has_exonull", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.EXONULL_INGOT.get()).build()))
                .unlockedBy("has_ecliptium", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.ECLIPTIUM_INGOT.get()).build()))
                .save(consumer);

        /*
        // Resource Simulator Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.SIMULATOR_BLOCK.get(), 1)
                .define('V', BlockRegistry.ECLIPTIUM_BLOCK.get())
                .define('N', ItemRegistry.EXONULL_INGOT.get())
                .define('G', Items.BLACK_STAINED_GLASS_PANE)
                .pattern("VVV")
                .pattern("NGN")
                .pattern("VVV")
                .unlockedBy("has_exonull", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.EXONULL_INGOT.get()).build()))
                .unlockedBy("has_ecliptium", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.ECLIPTIUM_INGOT.get()).build()))
                .save(consumer);

        // Resource Encoder Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.ENCODER_BLOCK.get(), 1)
                .define('V', BlockRegistry.ECLIPTIUM_BLOCK.get())
                .define('N', ItemRegistry.LOGISTEEL_INGOT.get())
                .define('G', Items.BLACK_STAINED_GLASS_PANE)
                .pattern("VVV")
                .pattern("NGN")
                .pattern("VVV")
                .unlockedBy("has_exonull", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.EXONULL_INGOT.get()).build()))
                .unlockedBy("has_ecliptium", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.ECLIPTIUM_INGOT.get()).build()))
                .unlockedBy("has_logisteel", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.LOGISTEEL_INGOT.get()).build()))
                .save(consumer);

        */
    }

    private void moduleRecipe(Consumer<FinishedRecipe> consumer, ProgramItem pItem) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pItem, 1)
                .requires(ProgramRegistry.UNINITIALIZED_PROGRAM.get())
                .requires(DataShardRegistry.getDataShardByResource(pItem.getResource()).get())
                .unlockedBy("has_blank_module", inventoryTrigger(ItemPredicate.Builder.item().of(ProgramRegistry.UNINITIALIZED_PROGRAM.get()).build()))
                .save(consumer);
    }

    private void upgradeRecipe(Consumer<FinishedRecipe> consumer, RegistryObject<Item> pItem) {
        Item ingredient;
        String upgrade_name = pItem.getId().getPath().replace("_upgrade","");

        switch (upgrade_name) {
            case "speed" -> ingredient = Items.SUGAR;
            case "stack" -> ingredient = Items.LAPIS_BLOCK;
            default -> ingredient = Items.AIR;
        }

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pItem.get(), 1)
                .define('#', ingredient)
                .define('B', UpgradeRegistry.BLANK_UPGRADE.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("###")
                .unlockedBy("has_blank_upgrade", inventoryTrigger(ItemPredicate.Builder.item().of(UpgradeRegistry.BLANK_UPGRADE.get()).build()))
                .save(consumer);
    }

}
