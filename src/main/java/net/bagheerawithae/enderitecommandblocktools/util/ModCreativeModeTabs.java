package net.bagheerawithae.enderitecommandblocktools.util;

import net.bagheerawithae.enderitecommandblocktools.ecbtcws;
import net.bagheerawithae.enderitecommandblocktools.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            ecbtcws.MOD_ID);

    public static RegistryObject<CreativeModeTab> COMMAND_BLOCK_TOOLS = CREATIVE_MODE_TABS.register("command_block_tools", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Enderite_Cmd_Paxel.get()))
                    .title(Component.translatable("creativemodetab.command_block_tools"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.Enderite_Cmd_Sword.get());
                        pOutput.accept(ModItems.Enderite_Cmd_Paxel.get());

                        pOutput.accept(ModItems.Enderite_Cmd_Half_tool.get());

                        pOutput.accept(ModItems.Enderite_Cmd_Pickaxe.get());
                        pOutput.accept(ModItems.Enderite_Cmd_Axe.get());
                        pOutput.accept(ModItems.Enderite_Cmd_Shovel.get());
                        pOutput.accept(ModItems.Enderite_Cmd_Hoe.get());

                        pOutput.accept(ModItems.Enderite_Cmd_Upgrade.get());

                        pOutput.accept(ModItems.Netherite_Cmd_Sword.get());

                        pOutput.accept(ModItems.Netherite_Cmd_Pickaxe.get());
                        pOutput.accept(ModItems.Netherite_Cmd_Axe.get());
                        pOutput.accept(ModItems.Netherite_Cmd_Shovel.get());
                        pOutput.accept(ModItems.Netherite_Cmd_Hoe.get());

                        pOutput.accept(ModItems.Netherite_Cmd_Upgrade.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}