package com.doitbetter.onelife.component;

import com.doitbetter.onelife.OneLife;
import com.doitbetter.onelife.component.components.*;
import com.mojang.serialization.JsonOps;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class ComponentLoader {

    private static final String HANDLES_PATH = "onelife/components/handles";
    private static final String HILTS_PATH = "onelife/components/hilts";
    private static final String POMMELS_PATH = "onelife/components/pommels";
    private static final String WRAPS_PATH = "onelife/components/wraps";
    private static final String GEMS_PATH = "onelife/components/gems";
    private static final String STAVES_PATH = "onelife/components/staves";
    private static final String STRINGS_PATH = "onelife/components/strings";
    private static final String TOP_CAPS_PATH = "onelife/components/top_caps";
    private static final String BOTTOM_CAPS_PATH = "onelife/components/bottom_caps";

    public static void load(ResourceManager resourceManager) {
        ComponentRegistry registry = ComponentRegistry.getInstance();
        registry.clear();

        loadHandles(resourceManager, registry);
        loadHilts(resourceManager, registry);
        loadPommels(resourceManager, registry);
        loadWraps(resourceManager, registry);
        loadGems(resourceManager, registry);
        loadStaves(resourceManager, registry);
        loadStrings(resourceManager, registry);
        loadTopCaps(resourceManager, registry);
        loadBottomCaps(resourceManager, registry);
    }

    private static void loadHandles(ResourceManager resourceManager, ComponentRegistry registry) {
        for (Map.Entry<Identifier, ?> entry : resourceManager.findResources(HANDLES_PATH, id -> id.getPath().endsWith(".json")).entrySet()) {
            try (InputStream stream = resourceManager.getResource(entry.getKey()).get().getInputStream()) {
                JsonElement json = JsonParser.parseReader(new InputStreamReader(stream));
                HandleComponent.CODEC.parse(JsonOps.INSTANCE, json)
                        .resultOrPartial(error -> OneLife.LOGGER.warn("[OneLife - ComponentLoader] Failed to load handle {}: {}", entry.getKey(), error))
                        .ifPresent(registry::registerHandle);
            } catch (Exception e) {
                OneLife.LOGGER.error("[OneLife - ComponentLoader] Error loading handle {}: {}", entry.getKey(), e.getMessage());
            }
        }
    }

    private static void loadHilts(ResourceManager resourceManager, ComponentRegistry registry) {
        for (Map.Entry<Identifier, ?> entry : resourceManager.findResources(HILTS_PATH, id -> id.getPath().endsWith(".json")).entrySet()) {
            try (InputStream stream = resourceManager.getResource(entry.getKey()).get().getInputStream()) {
                JsonElement json = JsonParser.parseReader(new InputStreamReader(stream));
                HiltComponent.CODEC.parse(JsonOps.INSTANCE, json)
                        .resultOrPartial(error -> OneLife.LOGGER.warn("[OneLife - ComponentLoader] Failed to load hilt {}: {}", entry.getKey(), error))
                        .ifPresent(registry::registerHilt);
            } catch (Exception e) {
                OneLife.LOGGER.error("[OneLife - ComponentLoader] Error loading hilt {}: {}", entry.getKey(), e.getMessage());
            }
        }
    }

    private static void loadPommels(ResourceManager resourceManager, ComponentRegistry registry) {
        for (Map.Entry<Identifier, ?> entry : resourceManager.findResources(POMMELS_PATH, id -> id.getPath().endsWith(".json")).entrySet()) {
            try (InputStream stream = resourceManager.getResource(entry.getKey()).get().getInputStream()) {
                JsonElement json = JsonParser.parseReader(new InputStreamReader(stream));
                PommelComponent.CODEC.parse(JsonOps.INSTANCE, json)
                        .resultOrPartial(error -> OneLife.LOGGER.warn("[OneLife - ComponentLoader] Failed to load pommel {}: {}", entry.getKey(), error))
                        .ifPresent(registry::registerPommel);
            } catch (Exception e) {
                OneLife.LOGGER.error("[OneLife - ComponentLoader] Error loading pommel {}: {}", entry.getKey(), e.getMessage());
            }
        }
    }

    private static void loadWraps(ResourceManager resourceManager, ComponentRegistry registry) {
        for (Map.Entry<Identifier, ?> entry : resourceManager.findResources(WRAPS_PATH, id -> id.getPath().endsWith(".json")).entrySet()) {
            try (InputStream stream = resourceManager.getResource(entry.getKey()).get().getInputStream()) {
                JsonElement json = JsonParser.parseReader(new InputStreamReader(stream));
                WrapComponent.CODEC.parse(JsonOps.INSTANCE, json)
                        .resultOrPartial(error -> OneLife.LOGGER.warn("[OneLife - ComponentLoader] Failed to load wrap {}: {}", entry.getKey(), error))
                        .ifPresent(registry::registerWrap);
            } catch (Exception e) {
                OneLife.LOGGER.error("[OneLife - ComponentLoader] Error loading wrap {}: {}", entry.getKey(), e.getMessage());
            }
        }
    }

    private static void loadGems(ResourceManager resourceManager, ComponentRegistry registry) {
        for (Map.Entry<Identifier, ?> entry : resourceManager.findResources(GEMS_PATH, id -> id.getPath().endsWith(".json")).entrySet()) {
            try (InputStream stream = resourceManager.getResource(entry.getKey()).get().getInputStream()) {
                JsonElement json = JsonParser.parseReader(new InputStreamReader(stream));
                GemComponent.CODEC.parse(JsonOps.INSTANCE, json)
                        .resultOrPartial(error -> OneLife.LOGGER.warn("[OneLife - ComponentLoader] Failed to load gem {}: {}", entry.getKey(), error))
                        .ifPresent(registry::registerGem);
            } catch (Exception e) {
                OneLife.LOGGER.error("[OneLife - ComponentLoader] Error loading gem {}: {}", entry.getKey(), e.getMessage());
            }
        }
    }

    private static void loadStaves(ResourceManager resourceManager, ComponentRegistry registry) {
        for (Map.Entry<Identifier, ?> entry : resourceManager.findResources(STAVES_PATH, id -> id.getPath().endsWith(".json")).entrySet()) {
            try (InputStream stream = resourceManager.getResource(entry.getKey()).get().getInputStream()) {
                JsonElement json = JsonParser.parseReader(new InputStreamReader(stream));
                StaveComponent.CODEC.parse(JsonOps.INSTANCE, json)
                        .resultOrPartial(error -> OneLife.LOGGER.warn("[OneLife - ComponentLoader] Failed to load stave {}: {}", entry.getKey(), error))
                        .ifPresent(registry::registerStave);
            } catch (Exception e) {
                OneLife.LOGGER.error("[OneLife - ComponentLoader] Error loading stave {}: {}", entry.getKey(), e.getMessage());
            }
        }
    }

    private static void loadStrings(ResourceManager resourceManager, ComponentRegistry registry) {
        for (Map.Entry<Identifier, ?> entry : resourceManager.findResources(STRINGS_PATH, id -> id.getPath().endsWith(".json")).entrySet()) {
            try (InputStream stream = resourceManager.getResource(entry.getKey()).get().getInputStream()) {
                JsonElement json = JsonParser.parseReader(new InputStreamReader(stream));
                StringComponent.CODEC.parse(JsonOps.INSTANCE, json)
                        .resultOrPartial(error -> OneLife.LOGGER.warn("[OneLife - ComponentLoader] Failed to load string {}: {}", entry.getKey(), error))
                        .ifPresent(registry::registerString);
            } catch (Exception e) {
                OneLife.LOGGER.error("[OneLife - ComponentLoader] Error loading string {}: {}", entry.getKey(), e.getMessage());
            }
        }
    }

    private static void loadTopCaps(ResourceManager resourceManager, ComponentRegistry registry) {
        for (Map.Entry<Identifier, ?> entry : resourceManager.findResources(TOP_CAPS_PATH, id -> id.getPath().endsWith(".json")).entrySet()) {
            try (InputStream stream = resourceManager.getResource(entry.getKey()).get().getInputStream()) {
                JsonElement json = JsonParser.parseReader(new InputStreamReader(stream));
                TopCapComponent.CODEC.parse(JsonOps.INSTANCE, json)
                        .resultOrPartial(error -> OneLife.LOGGER.warn("[OneLife - ComponentLoader] Failed to load top cap {}: {}", entry.getKey(), error))
                        .ifPresent(registry::registerTopCap);
            } catch (Exception e) {
                OneLife.LOGGER.error("[OneLife - ComponentLoader] Error loading top cap {}: {}", entry.getKey(), e.getMessage());
            }
        }
    }

    private static void loadBottomCaps(ResourceManager resourceManager, ComponentRegistry registry) {
        for (Map.Entry<Identifier, ?> entry : resourceManager.findResources(BOTTOM_CAPS_PATH, id -> id.getPath().endsWith(".json")).entrySet()) {
            try (InputStream stream = resourceManager.getResource(entry.getKey()).get().getInputStream()) {
                JsonElement json = JsonParser.parseReader(new InputStreamReader(stream));
                BottomCapComponent.CODEC.parse(JsonOps.INSTANCE, json)
                        .resultOrPartial(error -> OneLife.LOGGER.warn("[OneLife - ComponentLoader] Failed to load bottom cap {}: {}", entry.getKey(), error))
                        .ifPresent(registry::registerBottomCap);
            } catch (Exception e) {
                OneLife.LOGGER.error("[OneLife - ComponentLoader] Error loading bottom cap {}: {}", entry.getKey(), e.getMessage());
            }
        }
    }
}