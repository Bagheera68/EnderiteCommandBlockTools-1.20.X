package net.bagheerawithae.enderitecommandblocktools.item;

import net.bagheerawithae.enderitecommandblocktools.enderitecommandblocktools;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, enderitecommandblocktools.MOD_ID);

    public static final RegistryObject<Item> Enderite_Command_Block_Sword = ITEMS.register("enderite_command_block_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Enderite_Command_Block_Axe = ITEMS.register("enderite_command_block_axe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Enderite_Command_Block_shovel = ITEMS.register("enderite_command_block_shovel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Enderite_Command_Block_Pickaxe = ITEMS.register("enderite_command_block_pickaxe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Enderite_Command_Block_Hoe = ITEMS.register("enderite_command_block_hoe",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
