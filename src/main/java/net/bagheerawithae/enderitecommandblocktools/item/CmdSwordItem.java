package net.bagheerawithae.enderitecommandblocktools.item;

import net.enderitemc.enderitemod.tools.EnderiteSword;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class CmdSwordItem extends SwordItem {
    public CmdSwordItem(Tier tier, int damage, float attackSpeed, Properties properties) {
        super(tier, damage, attackSpeed, properties);
    }

    public boolean getMaxItemStackSize(ItemStack stack) {
        return this.getMaxStackSize(stack) == 1;
    }

    public boolean canBeHurtBy(DamageSource source)
    {
        return source.is(DamageTypeTags.BYPASSES_INVULNERABILITY);
    }

}
