package xyz.cryptix.digital_resources.Registry.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.cryptix.digital_resources.DigitalResources;
import xyz.cryptix.digital_resources.Registry.item.ItemRegistry;

import java.util.function.Supplier;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DigitalResources.MODID);

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ItemRegistry.BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static final RegistryObject<Block> EXONULL_ORE = registerBlock("exonull_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops().strength(4.5F, 3.0F)));
    public static final RegistryObject<Block> RAW_EXONULL_BLOCK = registerBlock("raw_exonull_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> EXONULL_BLOCK = registerBlock("exonull_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops().strength(10.0F, 50.0F)));
    public static final RegistryObject<Block> ECLIPTIUM_BLOCK = registerBlock("ecliptium_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.LODESTONE).strength(2.4F, 2.0F)));
    public static final RegistryObject<Block> ENERGEX_BLOCK = registerBlock("energex_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).emissiveRendering((pState, pLevel, pPos) -> true).lightLevel(blockState -> 10)));
    public static final RegistryObject<Block> GLITCH_BLOCK = registerBlock("glitch_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).emissiveRendering((pState, pLevel, pPos) -> true).lightLevel(blockState -> 15)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
