package net.bagheerawithae.enderitecommandblocktools;

import com.mojang.logging.LogUtils;
import net.bagheerawithae.enderitecommandblocktools.item.ItemParticleEffects.ItemParticleEffectsEnderite;
import net.bagheerawithae.enderitecommandblocktools.item.ItemParticleEffects.ItemParticleEffectsNetherite;
import net.bagheerawithae.enderitecommandblocktools.item.ModItems;
import net.bagheerawithae.enderitecommandblocktools.util.ModCreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ecbtcws.MOD_ID)
public class ecbtcws {
    public static final String MOD_ID = "ecbtcws";

    private static final Logger LOGGER = LogUtils.getLogger();

    public ecbtcws() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);

        MinecraftForge.EVENT_BUS.addListener(ItemParticleEffectsEnderite::onClientTick);

        MinecraftForge.EVENT_BUS.addListener(ItemParticleEffectsNetherite::onClientTick);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        {

        }

        if(event.getTab() == ModCreativeModeTabs.COMMAND_BLOCK_TOOLS.get()) {
            event.accept(ModItems.Enderite_Cmd_Sword);
            event.accept(ModItems.Enderite_Cmd_Paxel);
            event.accept(ModItems.Enderite_Cmd_Half_tool);
            event.accept(ModItems.Enderite_Cmd_Pickaxe);
            event.accept(ModItems.Enderite_Cmd_Axe);
            event.accept(ModItems.Enderite_Cmd_Shovel);
            event.accept(ModItems.Enderite_Cmd_Hoe);
            event.accept(ModItems.Netherite_Cmd_Sword);
            event.accept(ModItems.Netherite_Cmd_Pickaxe);
            event.accept(ModItems.Netherite_Cmd_Axe);
            event.accept(ModItems.Netherite_Cmd_Shovel);
            event.accept(ModItems.Netherite_Cmd_Hoe);
            event.accept(ModItems.Enderite_Cmd_Upgrade);
            event.accept(ModItems.Netherite_Cmd_Upgrade);
        }

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }

    }
}
