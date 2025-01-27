package net.mildzz.moremushrooms.datagen;

import net.mildzz.moremushrooms.MoreMushroomsMod;
import net.mildzz.moremushrooms.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MoreMushroomsMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        mushroomBlockGenerator();
        blockWithItem(ModBlocks.INKY_CAP_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void mushroomBlockGenerator() {
        makeMushroom(ModBlocks.INKY_CAP, ModBlocks.POTTED_INKY_CAP);
        itemModels().withExistingParent(ForgeRegistries.BLOCKS.getKey(ModBlocks.INKY_CAP.get()).getPath(),
                modLoc("block/inky_cap"));
    }

    private void makeMushroom(RegistryObject<Block> mushroomBlock, RegistryObject<Block> potBlock) {
        simpleBlock(mushroomBlock.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(mushroomBlock.get()).getPath(),
                        blockTexture(mushroomBlock.get())).renderType("cutout"));
        simpleBlock(potBlock.get(),
                models().withExistingParent(potBlock.getId().getPath(),
                                mcLoc("block/flower_pot_cross")).renderType("cutout")
                        .texture("plant", blockTexture(mushroomBlock.get())));
    }

    // IDK if I'll need this
    private void makeMushroom(RegistryObject<Block> mushroomBlock) {
        simpleBlock(mushroomBlock.get(),
                models().cross(blockTexture(mushroomBlock.get()).getPath(),
                        blockTexture(mushroomBlock.get())).renderType("cutout"));
    }
}
