package com.doitbetter.onelife.component.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.doitbetter.onelife.component.ComponentEffect;
import com.doitbetter.onelife.component.WeaponComponent;
import com.doitbetter.onelife.component.WeaponFamily;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public record BottomCapComponent(Identifier id, Map<WeaponFamily, List<ComponentEffect>> effectsByFamily, int componentDurability) implements WeaponComponent {

    public static final Codec<BottomCapComponent> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Identifier.CODEC.fieldOf("id").forGetter(BottomCapComponent::id),
                    Codec.unboundedMap(
                            Codec.STRING.xmap(WeaponFamily::valueOf, WeaponFamily::name),
                            ComponentEffect.CODEC.listOf()
                    ).fieldOf("effects_by_family").forGetter(BottomCapComponent::effectsByFamily),
                    Codec.INT.fieldOf("component_durability").forGetter(BottomCapComponent::componentDurability)
            ).apply(instance, BottomCapComponent::new)
    );

    @Override
    public List<ComponentEffect> effectsFor(WeaponFamily family) {
        return effectsByFamily.getOrDefault(family, List.of());
    }

    @Override
    public boolean supportsFamily(WeaponFamily family) {
        return family == WeaponFamily.STAFF;
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
