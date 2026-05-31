package com.doitbetter.onelife.component;

import com.doitbetter.onelife.component.components.*;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ComponentRegistry {

    private static final ComponentRegistry INSTANCE = new ComponentRegistry();

    private final Map<Identifier, HandleComponent> handles = new HashMap<>();
    private final Map<Identifier, HiltComponent> hilts = new HashMap<>();
    private final Map<Identifier, PommelComponent> pommels = new HashMap<>();
    private final Map<Identifier, WrapComponent> wraps = new HashMap<>();
    private final Map<Identifier, GemComponent> gems = new HashMap<>();
    private final Map<Identifier, StaveComponent> staves = new HashMap<>();
    private final Map<Identifier, StringComponent> strings = new HashMap<>();
    private final Map<Identifier, TopCapComponent> topCaps = new HashMap<>();
    private final Map<Identifier, BottomCapComponent> bottomCaps = new HashMap<>();

    private ComponentRegistry() {}

    public static ComponentRegistry getInstance() {
        return INSTANCE;
    }

    // =========================================================================
    // REGISTRATION
    // =========================================================================

    public void registerHandle(HandleComponent component) {
        handles.put(component.id(), component);
    }

    public void registerHilt(HiltComponent component) {
        hilts.put(component.id(), component);
    }

    public void registerPommel(PommelComponent component) {
        pommels.put(component.id(), component);
    }

    public void registerWrap(WrapComponent component) {
        wraps.put(component.id(), component);
    }

    public void registerGem(GemComponent component) {
        gems.put(component.id(), component);
    }

    public void registerStave(StaveComponent component) {
        staves.put(component.id(), component);
    }

    public void registerString(StringComponent component) {
        strings.put(component.id(), component);
    }

    public void registerTopCap(TopCapComponent component) {
        topCaps.put(component.id(), component);
    }

    public void registerBottomCap(BottomCapComponent component) {
        bottomCaps.put(component.id(), component);
    }

    // =========================================================================
    // LOOKUP
    // =========================================================================

    public Optional<HandleComponent> getHandle(Identifier id) {
        return Optional.ofNullable(handles.get(id));
    }

    public Optional<HiltComponent> getHilt(Identifier id) {
        return Optional.ofNullable(hilts.get(id));
    }

    public Optional<PommelComponent> getPommel(Identifier id) {
        return Optional.ofNullable(pommels.get(id));
    }

    public Optional<WrapComponent> getWrap(Identifier id) {
        return Optional.ofNullable(wraps.get(id));
    }

    public Optional<GemComponent> getGem(Identifier id) {
        return Optional.ofNullable(gems.get(id));
    }

    public Optional<StaveComponent> getStave(Identifier id) {
        return Optional.ofNullable(staves.get(id));
    }

    public Optional<StringComponent> getString(Identifier id) {
        return Optional.ofNullable(strings.get(id));
    }

    public Optional<TopCapComponent> getTopCap(Identifier id) {
        return Optional.ofNullable(topCaps.get(id));
    }

    public Optional<BottomCapComponent> getBottomCap(Identifier id) {
        return Optional.ofNullable(bottomCaps.get(id));
    }

    // =========================================================================
    // RELOAD
    // =========================================================================

    public void clear() {
        handles.clear();
        hilts.clear();
        pommels.clear();
        wraps.clear();
        gems.clear();
        staves.clear();
        strings.clear();
        topCaps.clear();
        bottomCaps.clear();
    }
}