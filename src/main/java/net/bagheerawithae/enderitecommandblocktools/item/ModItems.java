package net.bagheerawithae.enderitecommandblocktools.item;

import net.bagheerawithae.enderitecommandblocktools.ecbtcws;
import net.bagheerawithae.enderitecommandblocktools.item.custom.CmdPaxelItem;
import net.bagheerawithae.enderitecommandblocktools.util.ModTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ecbtcws.MOD_ID);

    public static final RegistryObject<Item> Enderite_Cmd_Sword = ITEMS.register("enderite_cmd_sword",
            () -> new CmdEnderiteSwordItem(ModTiers.ENDERITE_CMD, 4, -1.8F,
                    (new Item.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<AxeItem> Enderite_Cmd_Axe = ITEMS.register("enderite_cmd_axe",
            () -> new CmdAxeItem(ModTiers.ENDERITE_CMD, 0, -3.0F,
                    (new AxeItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<ShovelItem> Enderite_Cmd_Shovel = ITEMS.register("enderite_cmd_shovel",
            () -> new CmdShovelItem(ModTiers.ENDERITE_CMD, -4, -3.4F,
                    (new ShovelItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<PickaxeItem> Enderite_Cmd_Pickaxe = ITEMS.register("enderite_cmd_pickaxe",
            () -> new CmdPickaxeItem(ModTiers.ENDERITE_CMD, -4, -2.8F,
                    (new PickaxeItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<HoeItem> Enderite_Cmd_Hoe = ITEMS.register("enderite_cmd_hoe",
            () -> new CmdHoeItem(ModTiers.ENDERITE_CMD, -9, 0.0F,
                    (new HoeItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> Netherite_Cmd_Sword = ITEMS.register("netherite_cmd_sword",
            () -> new CmdNetheriteSwordItem(ModTiers.NETHERITE_CMD, 4, -2.1F,
                    (new SwordItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<AxeItem> Netherite_Cmd_Axe = ITEMS.register("netherite_cmd_axe",
            () -> new CmdAxeItem(ModTiers.NETHERITE_CMD, 3, -3.0F,
                    (new AxeItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<ShovelItem> Netherite_Cmd_Shovel = ITEMS.register("netherite_cmd_shovel",
            () -> new CmdShovelItem(ModTiers.NETHERITE_CMD, -1, -3.4F,
                    (new ShovelItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<PickaxeItem> Netherite_Cmd_Pickaxe = ITEMS.register("netherite_cmd_pickaxe",
            () -> new CmdPickaxeItem(ModTiers.NETHERITE_CMD, -1, -2.8F,
                    (new PickaxeItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<HoeItem> Netherite_Cmd_Hoe = ITEMS.register("netherite_cmd_hoe",
            () -> new CmdHoeItem(ModTiers.NETHERITE_CMD, -6, 0.0F,
                    (new HoeItem.Properties()).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> Enderite_Cmd_Paxel = ITEMS.register("enderite_cmd_paxel",
            () -> new CmdPaxelItem(ModTiers.ENDERITE_CMD, 0, -3.0F,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> Netherite_Cmd_Upgrade = ITEMS.register("netherite_cmd_upgrade",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));

    public static final RegistryObject<Item> Enderite_Cmd_Upgrade = ITEMS.register("enderite_cmd_upgrade",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));

    public static final RegistryObject<Item> Enderite_Cmd_Half_tool = ITEMS.register("enderite_cmd_half_tool",
            () -> new Item(new CmdEnderiteHalfTool.Properties().rarity(Rarity.EPIC).fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

