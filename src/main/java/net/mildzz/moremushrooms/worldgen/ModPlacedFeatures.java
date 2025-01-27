package net.mildzz.moremushrooms.worldgen;

import com.google.common.collect.ImmutableList;
import net.mildzz.moremushrooms.MoreMushroomsMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> INKY_CAP_PLACED_KEY = registerKey("inky_cap_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, INKY_CAP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HUGE_INKY_CAP),
                getMushroomPlacement(256, CountPlacement.of(138)));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MoreMushroomsMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static List<PlacementModifier> getMushroomPlacement(int pRarity, @Nullable PlacementModifier pPlacement) {
        ImmutableList.Builder<PlacementModifier> $$2 = ImmutableList.builder();
        if (pPlacement != null) {
            $$2.add(pPlacement);
        }

        if (pRarity != 0) {
            $$2.add(RarityFilter.onAverageOnceEvery(pRarity));
        }

        $$2.add(InSquarePlacement.spread());
        $$2.add(PlacementUtils.HEIGHTMAP);
        $$2.add(BiomeFilter.biome());
        $$2.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
        return $$2.build();
    }

}
