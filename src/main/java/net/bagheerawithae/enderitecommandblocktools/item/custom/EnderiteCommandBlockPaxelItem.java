package net.bagheerawithae.enderitecommandblocktools.item.custom;

import net.bagheerawithae.enderitecommandblocktools.util.ModTags;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Vanishable;

public class EnderiteCommandBlockPaxelItem extends DiggerItem implements Vanishable {
    public EnderiteCommandBlockPaxelItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, ModTags.Blocks.PAXEL_MINEABLE, pProperties);
    }
    public boolean canBeHurtBy(DamageSource source)
    {
        return source.is(DamageTypeTags.BYPASSES_INVULNERABILITY);
    }
}
