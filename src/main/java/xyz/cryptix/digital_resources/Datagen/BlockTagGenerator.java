package xyz.cryptix.digital_resources.Datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xyz.cryptix.digital_resources.DigitalResources;
import xyz.cryptix.digital_resources.Registry.blocks.BlockRegistry;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends BlockTagsProvider {

    public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DigitalResources.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        BlockRegistry.BLOCKS.getEntries().forEach(blockRegistryObject -> {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockRegistryObject.get());
            tag(BlockTags.NEEDS_DIAMOND_TOOL).add(blockRegistryObject.get());
        });
    }
}
