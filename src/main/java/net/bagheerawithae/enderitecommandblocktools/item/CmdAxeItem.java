package net.bagheerawithae.enderitecommandblocktools.item;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class CmdAxeItem extends AxeItem {
    public CmdAxeItem(Tier tier, int damage, float attackSpeed, Properties properties) {
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
