package net.bagheerawithae.enderitecommandblocktools.util;

import com.google.common.base.Supplier;
import net.enderitemc.enderitemod.EnderiteMod;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import nonamecrackers2.witherstormmod.common.init.WitherStormModItems;

public enum ModTiers implements Tier
{
    ENDERITE_CMD(7, 0, 65F, 12F, 70, () ->
            Ingredient.of(Items.NETHERITE_INGOT)),
    NETHERITE_CMD(6, 0, 24F, 9F, 52, () ->
            Ingredient.of(Items.NETHERITE_INGOT));

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    private ModTiers(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> ingredient)
    {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = ingredient;
    }

    @Override
    public int getUses()
    {
        return this.uses;
    }

    @Override
    public float getSpeed()
    {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus()
    {
        return this.damage;
    }

    @Override
    public int getLevel()
    {
        return this.level;
    }

    @Override
    public int getEnchantmentValue()
    {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return this.repairIngredient.get();
    }
}