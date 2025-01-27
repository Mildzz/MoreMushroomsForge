package net.mildzz.moremushrooms.item;

import net.mildzz.moremushrooms.MoreMushroomsMod;
import net.mildzz.moremushrooms.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreMushroomsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MUSHROOM_TAB = CREATIVE_MODE_TABS.register("mushrooms_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MUSHROOM.get()))
                    .title(Component.translatable("creativetab.mushrooms_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MUSHROOM.get());

                        output.accept(ModBlocks.INKY_CAP.get());
                        output.accept(ModBlocks.INKY_CAP_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
