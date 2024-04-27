package net.bagheerawithae.enderitecommandblocktools.item;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class CmdEnderiteSwordItem extends SwordItem {
    public CmdEnderiteSwordItem(Tier tier, int damage, float attackSpeed, Properties properties) {
        super(tier, damage, attackSpeed, properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity LivingEntity) {
            LivingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 10, 32), player);
        }

        return super.onLeftClickEntity(stack, player, entity);
    }

    public boolean getMaxItemStackSize(ItemStack stack) {
        return this.getMaxStackSize(stack) == 1;
    }

    public boolean canBeHurtBy(DamageSource source)
    {
        return source.is(DamageTypeTags.BYPASSES_INVULNERABILITY);
    }

}
