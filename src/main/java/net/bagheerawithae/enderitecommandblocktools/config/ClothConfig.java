package net.bagheerawithae.enderitecommandblocktools.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ClothConfig {
    public final Screen screen;
    EnderiteCmdToolsConfig DEFAULT = new EnderiteCmdToolsConfig();

    public ClothConfig(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create().setParentScreen(parent).setTitle(Component.translatable("title.ecbtcws.config"));
        EnderiteCmdToolsConfig currentConfig = ConfigLoader.get();
        builder.setSavingRunnable(() -> {
            ConfigLoader.set(currentConfig);
        });
        ConfigCategory restart = builder.getOrCreateCategory(Component.translatable("category.enderitemod.restart"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        restart.addEntry(entryBuilder.startIntField(Component.translatable("option.ecbtcws.restart.enderite_Cmd_sword.attack_damage"), currentConfig.swordDamage.enderiteCmdSwordAD + 3).setDefaultValue(this.DEFAULT.swordDamage.enderiteCmdSwordAD + 3).setMin(5).setMax(45).setTooltip(new Component[]{Component.translatable("option.enderitemod.restart.enderite_sword.attack_damage.hover")}).setSaveConsumer((newValue) -> {
            currentConfig.swordDamage.enderiteCmdSwordAD = newValue - 3;
        }).build());
        this.screen = builder.build();
    }

    public Screen getScreen() {
        return this.screen;
    }
}
