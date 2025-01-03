package xyz.cryptix.digital_resources.Datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.cryptix.digital_resources.DigitalResources;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = DigitalResources.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new BlockstateGenerator(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ItemModelGenerator(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new LanguageGenerator(packOutput, "en_us"));

        generator.addProvider(event.includeServer(), new RecipeGenerator(packOutput));

        BlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(), new BlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeServer(), new WorldGenerator(packOutput, lookupProvider));
    }
}
