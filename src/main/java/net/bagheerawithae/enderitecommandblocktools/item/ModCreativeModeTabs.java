package net.bagheerawithae.enderitecommandblocktools.item;

import net.bagheerawithae.enderitecommandblocktools.enderitecommandblocktools;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.bagheerawithae.enderitecommandblocktools.enderitecommandblocktools.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab ENDERITE_COMMAND_BLOCK_TOOLS;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        ENDERITE_COMMAND_BLOCK_TOOLS = event.registerCreativeModeTab(new ResourceLocation(enderitecommandblocktools.MOD_ID, "enderite_command_block_tools"),
                builder -> builder.icon(() -> new ItemStack(ModItems.Enderite_Command_Block_Sword.get()))
                        .title(Component.translatable("creativemodetab.enderite_command_block_tools")));

    }
}
