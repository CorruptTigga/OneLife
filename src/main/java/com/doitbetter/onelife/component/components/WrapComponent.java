package com.doitbetter.onelife.component.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.doitbetter.onelife.component.ComponentEffect;
import com.doitbetter.onelife.component.WeaponComponent;
import com.doitbetter.onelife.component.WeaponFamily;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public record WrapComponent(
        Identifier id,
        Map<WeaponFamily, List<ComponentEffect>> effectsByFamily,
        int componentDurability
) implements WeaponComponent {

    public static final Codec<WrapComponent> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Identifier.CODEC.fieldOf("id").forGetter(WrapComponent::id),
                    Codec.unboundedMap(
                            Codec.STRING.xmap(WeaponFamily::valueOf, WeaponFamily::name),
                            ComponentEffect.CODEC.listOf()
                    ).fieldOf("effects_by_family").forGetter(WrapComponent::effectsByFamily),
                    Codec.INT.fieldOf("component_durability").forGetter(WrapComponent::componentDurability)
            ).apply(instance, WrapComponent::new)
    );

    @Override
    public List<ComponentEffect> effectsFor(WeaponFamily family) {
        return effectsByFamily.getOrDefault(family, List.of());
    }

    @Override
    public boolean supportsFamily(WeaponFamily family) {
        return true; // Wraps support everything
    }

    @Override
    public int getComponentDurability() {
        return componentDurability;
    }

    @Override
    public Identifier getId() {
        return id;
    }
}