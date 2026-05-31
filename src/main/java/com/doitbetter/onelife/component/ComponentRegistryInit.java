package com.doitbetter.onelife.component;

import com.doitbetter.onelife.OneLife;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

public class ComponentRegistryInit {

    public static void register() {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(
                new SimpleSynchronousResourceReloadListener() {
                    @Override
                    public Identifier getFabricId() {
                        return Identifier.of(OneLife.MOD_ID, "components");
                    }

                    @Override
                    public void reload(ResourceManager resourceManager) {
                        OneLife.LOGGER.info("[OneLife - ComponentRegistry] Reloading component definitions...");
                        long start = System.currentTimeMillis();

                        ComponentLoader.load(resourceManager);

                        long duration = System.currentTimeMillis() - start;
                        OneLife.LOGGER.info("[OneLife - ComponentRegistry] Component reload complete in {}ms.", duration);
                    }
                }
        );
    }
}