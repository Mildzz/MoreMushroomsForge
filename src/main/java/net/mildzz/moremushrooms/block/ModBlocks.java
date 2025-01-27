package net.mildzz.moremushrooms.block;

import net.mildzz.moremushrooms.MoreMushroomsMod;
import net.mildzz.moremushrooms.item.ModItems;
import net.mildzz.moremushrooms.worldgen.ModConfiguredFeatures;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MoreMushroomsMod.MOD_ID);

    public static final RegistryObject<Block> INKY_CAP = registerBlock("inky_cap",
            () -> new MushroomBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK).noCollission()
                    .randomTicks().instabreak().sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY), ModConfiguredFeatures.HUGE_INKY_CAP));

    public static final RegistryObject<Block> INKY_CAP_BLOCK = registerBlock("inky_cap_block",
            () -> new HugeMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM_BLOCK)));

public static final RegistryObject<Block> POTTED_INKY_CAP = BLOCKS.register("potted_inky_cap",
        () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT,
                INKY_CAP,
                BlockBehaviour.Properties.copy(Blocks.POTTED_RED_MUSHROOM)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
