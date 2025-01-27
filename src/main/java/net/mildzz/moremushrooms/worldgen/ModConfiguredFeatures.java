package net.mildzz.moremushrooms.worldgen;

import net.mildzz.moremushrooms.MoreMushroomsMod;
import net.mildzz.moremushrooms.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_INKY_CAP = registerKey("huge_inky_cap");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> pContext) {
        register(pContext, HUGE_INKY_CAP, Feature.HUGE_RED_MUSHROOM,
                new HugeMushroomFeatureConfiguration(
                        BlockStateProvider.simple((BlockState) ModBlocks.INKY_CAP_BLOCK.get()
                                .defaultBlockState().setValue(HugeMushroomBlock.DOWN, false)),
                        BlockStateProvider.simple((BlockState) ((BlockState) Blocks.MUSHROOM_STEM.defaultBlockState()
                                .setValue(HugeMushroomBlock.UP, false)).setValue(HugeMushroomBlock.DOWN, false)),
                        2));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(MoreMushroomsMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
