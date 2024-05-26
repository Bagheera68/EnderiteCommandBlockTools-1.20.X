package net.bagheerawithae.enderitecommandblocktools.mixin;

import net.bagheerawithae.enderitecommandblocktools.item.ModItems;
import net.enderitemc.enderitemod.EnderiteMod;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SmithingMenu;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({SmithingMenu.class})
public abstract class SmithingEnderiteCmdSwordOutputMixin extends ItemCombinerMenu {
    public SmithingEnderiteCmdSwordOutputMixin(int syncId, Inventory playerInventory, ContainerLevelAccess context) {
        super(MenuType.SMITHING, syncId, playerInventory, context);
    }

    @Inject(
            at = {@At("TAIL")},
            cancellable = true,
            method = {"mayPickup"}
    )
    private void alwaysTakeable(Player player, boolean present, CallbackInfoReturnable<Boolean> info) {
        if (this.resultSlots.getItem(0).is((Item) ModItems.Enderite_Cmd_Sword.get())) {
            info.setReturnValue(true);
        }

    }
}
