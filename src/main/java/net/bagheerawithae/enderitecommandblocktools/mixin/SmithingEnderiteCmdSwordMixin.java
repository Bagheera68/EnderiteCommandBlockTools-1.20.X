package net.bagheerawithae.enderitecommandblocktools.mixin;

import net.bagheerawithae.enderitecommandblocktools.item.ModItems;
import net.enderitemc.enderitemod.EnderiteMod;
import net.enderitemc.enderitemod.misc.EnderiteTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.ItemTags;
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
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({SmithingMenu.class})
public abstract class SmithingEnderiteCmdSwordMixin extends ItemCombinerMenu {
    private final String ENDERITE_ARMOR_TRIM_UPGRADE_NAME = "Enderite Trim Armor Up";

    public SmithingEnderiteCmdSwordMixin(int syncId, Inventory playerInventory, ContainerLevelAccess context) {
        super(MenuType.SMITHING, syncId, playerInventory, context);
    }

    @Inject(
            at = {@At("TAIL")},
            cancellable = true,
            method = {"createResult"}
    )
    private void update(CallbackInfo info) {
        ItemStack sword = this.inputSlots.getItem(1);
        ItemStack pearls1 = this.inputSlots.getItem(0);
        ItemStack pearls2 = this.inputSlots.getItem(2);
        if ((sword.is((Item)ModItems.Enderite_Cmd_Sword.get())) && (pearls1.is(Items.ENDER_PEARL) || pearls1.isEmpty()) && pearls2.is(Items.ENDER_PEARL)) {
            int teleport_charge = pearls1.getCount() + pearls2.getCount();
            if (sword.getOrCreateTag().contains("teleport_charge")) {
                teleport_charge += sword.getOrCreateTag().getInt("teleport_charge");
            }

            if (teleport_charge > 64) {
                teleport_charge = 64;
            }

            ItemStack newSword = sword.copy();
            newSword.getOrCreateTag().putInt("teleport_charge", teleport_charge);
            this.resultSlots.setItem(0, newSword);
        }

        ItemStack outputStack = this.resultSlots.getItem(0);
        if (outputStack.is(EnderiteTag.ENDERITE_ARMOR) && outputStack.is(ItemTags.TRIMMABLE_ARMOR)) {
            CompoundTag nbt = outputStack.getOrCreateTag();
            if (nbt != null) {
                CompoundTag trim_nbt = nbt.getCompound("Trim");
                if (trim_nbt != null && trim_nbt.getString("material").equals("enderitemod:enderite")) {
                    trim_nbt.putString("material", "enderitemod:enderite_darker");
                    nbt.put("Trim", trim_nbt);
                    outputStack.setTag(nbt);
                }
            }
        }
    }
}
