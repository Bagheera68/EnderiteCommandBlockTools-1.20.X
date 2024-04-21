package net.bagheerawithae.enderitecommandblocktools.item;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.*;

public class CmdEnderiteHalfTool extends AxeItem {
    public CmdEnderiteHalfTool(Tier tier, int damage, float attackSpeed, Item.Properties properties) {
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
