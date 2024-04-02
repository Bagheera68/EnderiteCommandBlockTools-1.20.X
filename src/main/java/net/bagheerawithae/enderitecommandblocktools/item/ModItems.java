package net.bagheerawithae.enderitecommandblocktools.item;

import net.bagheerawithae.enderitecommandblocktools.ecbtcws;
import net.bagheerawithae.enderitecommandblocktools.item.custom.EnderiteCommandBlockPaxelItem;
import net.bagheerawithae.enderitecommandblocktools.util.EnderiteCommandBlockToolsItemTier;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ecbtcws.MOD_ID);

    public static final RegistryObject<Item> Enderite_Command_Block_Sword = ITEMS.register("enderite_command_block_sword",
            () -> new EnderiteCommandBlockSwordItem(EnderiteCommandBlockToolsItemTier.ENDERITE_CMD, 7, -1.5F,
                    (new Item.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<AxeItem> Enderite_Command_Block_Axe = ITEMS.register("enderite_command_block_axe",
            () -> new EnderiteCommandBlockAxeItem(EnderiteCommandBlockToolsItemTier.ENDERITE_CMD, 0, -3.0F,
                    (new AxeItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<EnderiteCommandBlockPaxelItem> Enderite_Command_Block_Paxel = ITEMS.register("enderite_command_block_paxel",
            () -> new EnderiteCommandBlockPaxelItem(EnderiteCommandBlockToolsItemTier.ENDERITE_CMD, 0, -3.0F,
                    (new EnderiteCommandBlockPaxelItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<ShovelItem> Enderite_Command_Block_Shovel = ITEMS.register("enderite_command_block_shovel",
            () -> new EnderiteCommandBlockShovelItem(EnderiteCommandBlockToolsItemTier.ENDERITE_CMD, -4, -3.4F,
                    (new ShovelItem.Properties()).fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<PickaxeItem> Enderite_Command_Block_Pickaxe = ITEMS.register("enderite_command_block_pickaxe",
            () -> new EnderiteCommandBlockPickaxeItem(EnderiteCommandBlockToolsItemTier.ENDERITE_CMD, -4, -2.8F,
                    (new PickaxeItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<HoeItem> Enderite_Command_Block_Hoe = ITEMS.register("enderite_command_block_hoe",
            () -> new EnderiteCommandBlockHoeItem(EnderiteCommandBlockToolsItemTier.ENDERITE_CMD, -9, 0.0F,
                    (new HoeItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> Netherite_Command_Block_Sword = ITEMS.register("netherite_command_block_sword",
            () -> new EnderiteCommandBlockSwordItem(EnderiteCommandBlockToolsItemTier.NETHERITE_CMD, 4, -2.0F,
                    (new SwordItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<AxeItem> Netherite_Command_Block_Axe = ITEMS.register("netherite_command_block_axe",
            () -> new EnderiteCommandBlockAxeItem(EnderiteCommandBlockToolsItemTier.NETHERITE_CMD, 3, -3.0F,
                    (new AxeItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<ShovelItem> Netherite_Command_Block_Shovel = ITEMS.register("netherite_command_block_shovel",
            () -> new EnderiteCommandBlockShovelItem(EnderiteCommandBlockToolsItemTier.NETHERITE_CMD, -1, -3.4F,
                    (new ShovelItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<PickaxeItem> Netherite_Command_Block_Pickaxe = ITEMS.register("netherite_command_block_pickaxe",
            () -> new EnderiteCommandBlockPickaxeItem(EnderiteCommandBlockToolsItemTier.NETHERITE_CMD, -1, -2.8F,
                    (new PickaxeItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<HoeItem> Netherite_Command_Block_Hoe = ITEMS.register("netherite_command_block_hoe",
            () -> new EnderiteCommandBlockHoeItem(EnderiteCommandBlockToolsItemTier.NETHERITE_CMD, -6, 0.0F,
                    (new HoeItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> Netherite_Command_Block_Upgrade = ITEMS.register("netherite_command_block_upgrade",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));

    public static final RegistryObject<Item> Enderite_Command_Block_Upgrade = ITEMS.register("enderite_command_block_upgrade",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

