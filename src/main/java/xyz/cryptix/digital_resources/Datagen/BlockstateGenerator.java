package xyz.cryptix.digital_resources.Datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import xyz.cryptix.digital_resources.DigitalResources;
import xyz.cryptix.digital_resources.Registry.blocks.BlockRegistry;

public class BlockstateGenerator extends BlockStateProvider {

    private final ExistingFileHelper exFileHelper;

    public BlockstateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DigitalResources.MODID, exFileHelper);
        this.exFileHelper = exFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {
        generateBlockModel(BlockRegistry.EXONULL_ORE);
        generateBlockModel(BlockRegistry.EXONULL_BLOCK);
        generateBlockModel(BlockRegistry.RAW_EXONULL_BLOCK);
        generateBlockModel(BlockRegistry.ENERGEX_BLOCK);
        generateBlockModel(BlockRegistry.ECLIPTIUM_BLOCK);
        blockWithExistingModel(BlockRegistry.GLITCH_BLOCK);
    }

    private void generateBlockModel(RegistryObject<Block> pBlock) {
        // Generates a simple block model and corresponding item model
        simpleBlockWithItem(pBlock.get(), cubeAll(pBlock.get()));
    }

    private void blockWithExistingModel(RegistryObject<Block> pBlock) {
        // Use the block's registry name to create the ResourceLocation for its model
        String blockName = pBlock.getId().getPath();
        ModelFile modelFile = new ModelFile.ExistingModelFile(
                modLoc("block/" + blockName),  // Points to "assets/<modid>/block/<block_name>.json"
                exFileHelper
        );

        // Link the block and its item to the existing model
        simpleBlockWithItem(pBlock.get(), modelFile);
    }
}
