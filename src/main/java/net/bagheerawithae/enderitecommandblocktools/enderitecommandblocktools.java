package net.bagheerawithae.enderitecommandblocktools;

import com.mojang.logging.LogUtils;
import net.bagheerawithae.enderitecommandblocktools.item.ModCreativeModeTabs;
import net.bagheerawithae.enderitecommandblocktools.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(enderitecommandblocktools.MOD_ID)
public class enderitecommandblocktools
{
    public static final String MOD_ID = "enderitecommandblocktools";

    private static final Logger LOGGER = LogUtils.getLogger();

    public enderitecommandblocktools() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        {

        }

        if(event.getTab() == ModCreativeModeTabs.ENDERITE_COMMAND_BLOCK_TOOLS) {
            event.accept(ModItems.Enderite_Command_Block_Sword);
            event.accept(ModItems.Enderite_Command_Block_Axe);
            event.accept(ModItems.Enderite_Command_Block_shovel);
            event.accept(ModItems.Enderite_Command_Block_Pickaxe);
            event.accept(ModItems.Enderite_Command_Block_Hoe);
        }

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
