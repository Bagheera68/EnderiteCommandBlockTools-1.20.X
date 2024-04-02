package net.bagheerawithae.enderitecommandblocktools.item;

import net.enderitemc.enderitemod.tools.EnderiteSword;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import nonamecrackers2.witherstormmod.common.item.CommandBlockSwordItem;

public class EnderiteCommandBlockSwordItem extends SwordItem {
    public EnderiteCommandBlockSwordItem(Tier tier, int damage, float attackSpeed, Properties properties) {
        super(tier, damage, attackSpeed, properties);
    }
    public boolean canBeHurtBy(DamageSource source)
    {
        return source.is(DamageTypeTags.BYPASSES_INVULNERABILITY);
    }
}
