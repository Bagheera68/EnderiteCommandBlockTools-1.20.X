package net.bagheerawithae.enderitecommandblocktools.item;

import net.enderitemc.enderitemod.tools.EnderiteSword;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;
import java.util.Objects;


public class CmdEnderiteSwordItem extends SwordItem {

    public int superAufladung;

    public CmdEnderiteSwordItem(Tier material, int attackDamage, float attackSpeed, Item.Properties settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player playerEntity, InteractionHand hand) {
        if (playerEntity.isShiftKeyDown()) {
            Double distance = 45.0;
            double yaw = (double)playerEntity.yHeadRot;
            double pitch = (double)playerEntity.getXRot();
            double temp = Math.cos(Math.toRadians(pitch));
            double dX = temp * -Math.sin(Math.toRadians(yaw));
            double dY = -Math.sin(Math.toRadians(pitch));
            double dZ = temp * Math.cos(Math.toRadians(yaw));
            Vec3 position = playerEntity.position().add(0.0, playerEntity.getEyeY() - playerEntity.getY(), 0.0);
            Vec3 endPosition = new Vec3(position.x + dX * distance, position.y + dY * distance, position.z + dZ * distance);
            BlockPos blockPos = BlockPos.containing(endPosition.x, endPosition.y, endPosition.z);
            BlockPos[] blockPoses = new BlockPos[]{blockPos, blockPos.above(), blockPos};
            double down = endPosition.y;
            double maxDown = down - distance - 1.0 > (double)world.getMinBuildHeight() ? down - distance - 1.0 : (double)world.getMinBuildHeight();
            double up = endPosition.y + 1.0;
            double maxUp = 128.0;
            if (playerEntity.getCommandSenderWorld().dimensionType().respawnAnchorWorks()) {
                maxUp = up + distance - 1.0 < 127.0 ? up + distance - 1.0 : 127.0;
            } else {
                maxUp = up + distance - 1.0 < (double)world.getMaxBuildHeight() ? up + distance - 1.0 : (double)world.getMaxBuildHeight();
            }

            double near = distance;
            int slot = 0;
            if (playerEntity.getItemInHand(hand).getOrCreateTag().contains("teleport_charge")) {
                slot = Integer.parseInt(playerEntity.getItemInHand(hand).getOrCreateTag().get("teleport_charge").getAsString());
            }

            if (!world.hasChunkAt(blockPos) || slot <= 0 && !playerEntity.getAbilities().instabuild) {
                return new InteractionResultHolder(InteractionResult.FAIL, playerEntity.getItemInHand(hand));
            } else {
                int foundSpace = 0;

                while(foundSpace == 0 && ((double)blockPoses[0].getY() > maxDown || (double)blockPoses[1].getY() < maxUp)) {
                    if ((double)blockPoses[0].getY() > maxDown) {
                        if (this.checkBlocks(world, blockPoses[0])) {
                            foundSpace = 1;
                        } else {
                            --down;
                            blockPoses[0] = blockPoses[0].below();
                        }
                    }

                    if ((double)blockPoses[1].getY() < maxUp) {
                        if (this.checkBlocks(world, blockPoses[1])) {
                            foundSpace = 2;
                        } else {
                            ++up;
                            blockPoses[1] = blockPoses[1].above();
                        }
                    }

                    if (near > 2.0) {
                        if (this.checkBlocks(world, blockPoses[2])) {
                            foundSpace = 3;
                        } else {
                            --near;
                            blockPoses[2] = blockPoses[2].offset((int)Math.floor(-dX), (int)Math.floor(-dY), (int)Math.floor(-dZ));
                        }
                    }
                }

                if (foundSpace == 0 && !world.getBlockState(blockPos).blocksMotion() && !world.getBlockState(blockPos.above()).blocksMotion()) {
                    foundSpace = 4;
                }

                if (foundSpace > 0 && position.y + dY * near < maxUp && position.y + dY * near > maxDown) {
                    playerEntity.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                    switch (foundSpace) {
                        case 1:
                            playerEntity.randomTeleport(endPosition.x, down > maxDown ? down : maxDown, endPosition.z, true);
                            break;
                        case 2:
                            playerEntity.randomTeleport(endPosition.x, up < maxUp ? up : maxUp, endPosition.z, true);
                            break;
                        case 4:
                            near = distance / 2.0;
                        case 3:
                            down = position.y + dY * near;
                            down = down > (double)world.getMinBuildHeight() ? down : (double)(world.getMinBuildHeight() + 1);
                            playerEntity.randomTeleport(position.x + dX * near, down, position.z + dZ * near, true);
                    }

                    playerEntity.getCooldowns().addCooldown(this, 20);
                    if (!playerEntity.getAbilities().instabuild) {
                        playerEntity.getItemInHand(hand).getOrCreateTag().putInt("teleport_charge", slot - 1);
                    }

                    world.broadcastEntityEvent(playerEntity, (byte)46);
                    world.playSound((Player)null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
                    playerEntity.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }

                return new InteractionResultHolder(InteractionResult.SUCCESS, playerEntity.getItemInHand(hand));
            }
        } else {
            return new InteractionResultHolder(InteractionResult.FAIL, playerEntity.getItemInHand(hand));
        }
    }

    protected boolean checkBlocks(Level world, BlockPos pos) {
        return world.getBlockState(pos.below()).blocksMotion() && !world.getBlockState(pos).blocksMotion() && !world.getBlockState(pos.above()).blocksMotion();
    }

    public void appendHoverText(ItemStack itemStack, Level world, List<Component> tooltip, TooltipFlag tooltipContext) {
        if (itemStack.getOrCreateTag().contains("teleport_charge")) {
            String charge = itemStack.getOrCreateTag().get("teleport_charge").toString();
            tooltip.add(Component.translatable("item.enderitemod.enderite_sword.charge").withStyle(new ChatFormatting[]{ChatFormatting.DARK_PURPLE}).append(Component.literal(": " + charge)));
        } else {
            tooltip.add(Component.translatable("item.enderitemod.enderite_sword.charge").withStyle(new ChatFormatting[]{ChatFormatting.DARK_PURPLE}).append(Component.literal(": 0")));
        }

        tooltip.add(Component.translatable("item.enderitemod.enderite_sword.tooltip1").withStyle(new ChatFormatting[]{ChatFormatting.BLUE, ChatFormatting.ITALIC}));
        tooltip.add(Component.translatable("item.enderitemod.enderite_sword.tooltip2").withStyle(new ChatFormatting[]{ChatFormatting.BLUE, ChatFormatting.ITALIC}));
        tooltip.add(Component.translatable("item.enderitemod.enderite_sword.tooltip3").withStyle(new ChatFormatting[]{ChatFormatting.BLUE, ChatFormatting.ITALIC}));
    }

    public void onCraftedBy(ItemStack stack, Level world, Player player) {
    }

    public boolean isEnchantable(ItemStack stack) {
        return this.getMaxStackSize(stack) == 1;
    }

    public boolean canBeHurtBy(DamageSource source) {
        return source.is(DamageTypeTags.BYPASSES_INVULNERABILITY);
    }
}
