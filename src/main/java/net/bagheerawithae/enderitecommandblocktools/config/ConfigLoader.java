package net.bagheerawithae.enderitecommandblocktools.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.architectury.platform.Platform;
import net.bagheerawithae.enderitecommandblocktools.item.ModItems;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ConfigLoader {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
    private static final String FILENAME = "ecbtcws.json";
    private static File file;

    public ConfigLoader() {
    }

    public static void load() {
        File file = getFile();
        if (!file.exists()) {
            ModItems.EnderiteCmdToolsConfig = new EnderiteCmdToolsConfig();
            save();
        } else {
            read();
            save();
        }

    }

    private static void read() {
        ModItems.EnderiteCmdToolsConfig = get();
    }

    public static void save() {
        File file = getFile();

        try {
            FileWriter writer = new FileWriter(file);

            try {
                writer.write(GSON.toJson(ModItems.EnderiteCmdToolsConfig));
            } catch (Throwable var5) {
                try {
                    writer.close();
                } catch (Throwable var4) {
                    var5.addSuppressed(var4);
                }

                throw var5;
            }

            writer.close();
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    public static void set(EnderiteCmdToolsConfig config) {
        ModItems.EnderiteCmdToolsConfig = config;
        save();
    }

    public static EnderiteCmdToolsConfig get() {
        File file = getFile();

        EnderiteCmdToolsConfig newconfig;
        try {
            FileReader reader = new FileReader(file);

            try {
                newconfig = (EnderiteCmdToolsConfig)GSON.fromJson(reader, EnderiteCmdToolsConfig.class);
            } catch (Throwable var5) {
                try {
                    reader.close();
                } catch (Throwable var4) {
                    var5.addSuppressed(var4);
                }

                throw var5;
            }

            reader.close();
            return newconfig;
        } catch (Exception var6) {
            System.out.println("Enderite Command Block Tools config not found, creating a new one");
            newconfig = new EnderiteCmdToolsConfig();
            set(newconfig);
            return newconfig;
        }
    }

    private static File getFile() {
        if (file == null) {
            file = new File(Platform.getConfigFolder().toFile(), "ecbtcws.json");
        }

        return file;
    }
}