package com.doitbetter.onelife.component.components;

import com.doitbetter.onelife.component.ComponentEffect;
import com.doitbetter.onelife.component.WeaponComponent;
import com.doitbetter.onelife.component.WeaponFamily;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public record HiltComponent(
        Identifier id,
        Map<WeaponFamily, List<ComponentEffect>> effectsByFamily,
        int componentDurability
) implements WeaponComponent {

    public static final Codec<HiltComponent> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Identifier.CODEC.fieldOf("id").forGetter(HiltComponent::id),
                    Codec.unboundedMap(
                            Codec.STRING.xmap(WeaponFamily::valueOf, WeaponFamily::name),
                            ComponentEffect.CODEC.listOf()
                    ).fieldOf("effects_by_family").forGetter(HiltComponent::effectsByFamily),
                    Codec.INT.fieldOf("component_durability").forGetter(HiltComponent::componentDurability)
            ).apply(instance, HiltComponent::new)
    );

    @Override
    public List<ComponentEffect> effectsFor(WeaponFamily family) {
        return effectsByFamily.getOrDefault(family, List.of());
    }

    @Override
    public boolean supportsFamily(WeaponFamily family) {
        return switch (family) {
            case BLADE_SWORD, BLADE_DAGGER, BLUNT, POLEARM -> true;
            default -> false;
        };
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