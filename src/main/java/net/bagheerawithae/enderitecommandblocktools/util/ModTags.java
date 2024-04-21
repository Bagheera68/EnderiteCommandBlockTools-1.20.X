package net.bagheerawithae.enderitecommandblocktools.util;

import net.minecraft.world.level.block.Block;
import net.bagheerawithae.enderitecommandblocktools.ecbtcws;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
public static class Items {
    public static final TagKey<Item> ENDERITE_CMD_TOOLS = tag( "enderite_cmd_tools");

    private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ecbtcws.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> PAXEL_MINEABLE = tag("mineable/paxel");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ecbtcws.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
