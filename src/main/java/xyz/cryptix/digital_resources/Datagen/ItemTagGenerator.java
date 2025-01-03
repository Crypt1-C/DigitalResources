package xyz.cryptix.digital_resources.Datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;
import xyz.cryptix.digital_resources.DigitalResources;
import xyz.cryptix.digital_resources.Registry.blocks.BlockRegistry;
import xyz.cryptix.digital_resources.Registry.item.ItemRegistry;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends ItemTagsProvider {


    public ItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, p_275729_, p_275322_, DigitalResources.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // ingots
        addKey(ItemRegistry.LOGISTEEL_INGOT.get(), new ResourceLocation("forge", "ingots/logisteel"));
        addKey(ItemRegistry.EXONULL_INGOT.get(), new ResourceLocation("forge", "ingots/exonull"));
        addKey(ItemRegistry.ECLIPTIUM_INGOT.get(), new ResourceLocation("forge", "ingots/ecliptium"));
        addKey(ItemRegistry.ENERGEX_INGOT.get(), new ResourceLocation("forge", "ingots/energex"));
        // storage blocks
        addKey(BlockRegistry.EXONULL_BLOCK.get().asItem(), new ResourceLocation("forge", "storage_blocks/exonull"));
        addKey(BlockRegistry.EXONULL_BLOCK.get().asItem(), new ResourceLocation("forge", "storage_blocks"));
        addKey(BlockRegistry.RAW_EXONULL_BLOCK.get().asItem(), new ResourceLocation("forge", "storage_blocks/raw_exonull"));
        addKey(BlockRegistry.RAW_EXONULL_BLOCK.get().asItem(), new ResourceLocation("forge", "storage_blocks"));
        addKey(BlockRegistry.ECLIPTIUM_BLOCK.get().asItem(), new ResourceLocation("forge", "storage_blocks/ecliptium"));
        addKey(BlockRegistry.ECLIPTIUM_BLOCK.get().asItem(), new ResourceLocation("forge", "storage_blocks"));
        addKey(BlockRegistry.ENERGEX_BLOCK.get().asItem(), new ResourceLocation("forge", "storage_blocks/energex"));
        addKey(BlockRegistry.ENERGEX_BLOCK.get().asItem(), new ResourceLocation("forge", "storage_blocks"));
        // other
        addKey(Items.CLAY_BALL, new ResourceLocation("forge", "clay"));
        addKey(ItemRegistry.ENDER_PEARL_DUST.get(), new ResourceLocation("forge", "dusts/ender_pearl"));
    }

    private void addKey(Item pItem, ResourceLocation pResourceLocation) {
        TagKey<Item> key = Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).createTagKey(pResourceLocation);
        tag(key).add(pItem);
    }
}
