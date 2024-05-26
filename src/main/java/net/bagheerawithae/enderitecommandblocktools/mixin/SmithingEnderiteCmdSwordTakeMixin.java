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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({SmithingMenu.class})
public abstract class SmithingEnderiteCmdSwordTakeMixin extends ItemCombinerMenu {
    @Shadow
    public abstract void shrinkStackInSlot(int var1);

    public SmithingEnderiteCmdSwordTakeMixin(int syncId, Inventory playerInventory, ContainerLevelAccess context) {
        super(MenuType.SMITHING, syncId, playerInventory, context);
    }

    private void superDecrement(int i, int amount) {
        ItemStack itemStack = this.inputSlots.getItem(i);
        if (!itemStack.isEmpty()) {
            itemStack.shrink(amount);
            this.inputSlots.setItem(i, itemStack);
        }

    }

    @Inject(
            at = {@At("HEAD")},
            cancellable = true,
            method = {"onTake"}
    )
    private void nowTake(Player player, ItemStack itemStack, CallbackInfo info) {
        ItemStack sword = this.inputSlots.getItem(1);
        ItemStack pearls1 = this.inputSlots.getItem(0);
        ItemStack pearls2 = this.inputSlots.getItem(2);
        if ((sword.is((Item)ModItems.Enderite_Cmd_Sword.get())) && (pearls1.is(Items.ENDER_PEARL) || pearls1.isEmpty()) && pearls2.is(Items.ENDER_PEARL)) {
            int amountToSubstract = pearls1.getCount() + pearls2.getCount();
            int subtract1;
            if (sword.getOrCreateTag().contains("teleport_charge")) {
                subtract1 = 64 - sword.getOrCreateTag().getInt("teleport_charge");
                amountToSubstract = Math.min(subtract1, amountToSubstract);
            }

            subtract1 = Math.min(amountToSubstract, pearls1.getCount());
            this.superDecrement(0, subtract1 - 1);
            this.superDecrement(2, amountToSubstract - subtract1 - 1);
        }

    }
}
