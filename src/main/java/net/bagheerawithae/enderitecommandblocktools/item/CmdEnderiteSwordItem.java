package net.bagheerawithae.enderitecommandblocktools.item;

import net.enderitemc.enderitemod.tools.EnderiteSword;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class CmdEnderiteSwordItem extends EnderiteSword {

    public int superAufladung;

    public CmdEnderiteSwordItem(Tier material, int attackDamage, float attackSpeed, Item.Properties settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Level world, List<Component> tooltip, TooltipFlag tooltipContext) {
        if (itemStack.getTag() != null && itemStack.getTag().contains("teleport_charge")) {
            String charge = itemStack.getTag().get("teleport_charge").toString();
            tooltip.add(Component.translatable("item.enderitemod.enderite_sword.charge").withStyle(new ChatFormatting[]{ChatFormatting.DARK_AQUA}).append(Component.literal(": " + charge)));
        } else {
            tooltip.add(Component.translatable("item.enderitemod.enderite_sword.charge").withStyle(new ChatFormatting[]{ChatFormatting.DARK_AQUA}).append(Component.literal(": 0")));
        }

        tooltip.add(Component.translatable("item.enderitemod.enderite_sword.tooltip1").withStyle(new ChatFormatting[]{ChatFormatting.GRAY, ChatFormatting.ITALIC}));
        tooltip.add(Component.translatable("item.enderitemod.enderite_sword.tooltip2").withStyle(new ChatFormatting[]{ChatFormatting.GRAY, ChatFormatting.ITALIC}));
        tooltip.add(Component.translatable("item.enderitemod.enderite_sword.tooltip3").withStyle(new ChatFormatting[]{ChatFormatting.GRAY, ChatFormatting.ITALIC}));
    }

    // @Override
   // public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
   //     if(entity instanceof LivingEntity LivingEntity) {
   //         LivingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 3, 55), player);
   //     }

   //     return super.onLeftClickEntity(stack, player, entity);
   // }

    public boolean getMaxItemStackSize(ItemStack stack) {
        return this.getMaxStackSize(stack) == 1;
    }

    public boolean canBeHurtBy(DamageSource source) {
        return source.is(DamageTypeTags.BYPASSES_INVULNERABILITY);
    }

}
