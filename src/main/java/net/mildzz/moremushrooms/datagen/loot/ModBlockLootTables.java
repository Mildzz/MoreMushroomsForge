package net.mildzz.moremushrooms.datagen.loot;

import net.mildzz.moremushrooms.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.INKY_CAP.get());
        this.dropPottedContents(ModBlocks.POTTED_INKY_CAP.get());
        this.add(ModBlocks.INKY_CAP_BLOCK.get(),
                createMushroomBlockDrop(ModBlocks.INKY_CAP_BLOCK.get(), ModBlocks.INKY_CAP.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
