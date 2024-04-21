package net.bagheerawithae.enderitecommandblocktools.item.ItemParticleEffects;

import net.bagheerawithae.enderitecommandblocktools.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import nonamecrackers2.witherstormmod.common.init.WitherStormModParticleTypes;
import nonamecrackers2.witherstormmod.common.tags.WitherStormModItemTags;

public class ItemParticleEffectsNetherite {
    public static void onClientTick(TickEvent.ClientTickEvent event)
    {
        Minecraft mc = Minecraft.getInstance();
        if (event.phase == TickEvent.Phase.START)
        {
            if (!mc.isPaused() && mc.level != null)
            {
                ClientLevel world = mc.level;
                for (Entity entity : world.entitiesForRendering())
                {
                    if (entity instanceof ItemEntity)
                    {
                        ItemEntity item = (ItemEntity)entity;
                        if (item.getItem().is(ModItems.Netherite_Cmd_Upgrade.get()) || item.getItem().is(WitherStormModItemTags.COMMAND_BLOCK_TOOLS))
                        {
                            for (int i = 0; i < 2; i++)
                            {
                                double x = item.getX() + world.getRandom().nextGaussian() * 0.4D;
                                double y = item.getEyeY() + world.getRandom().nextGaussian() * 0.4D;
                                double z = item.getZ() + world.getRandom().nextGaussian() * 0.4D;
                                Vec3 delta = item.getEyePosition(1.0F).subtract(x, y, z).normalize().multiply(0.05D, 0.05D, 0.05D);
                                world.addParticle(WitherStormModParticleTypes.COMMAND_BLOCK.get(), x, y, z, delta.x(), delta.y(), delta.z());
                            }
                        }
                    }
                }
            }
        }
    }
}
