package com.doitbetter.onelife.component.components;

import com.doitbetter.onelife.component.ComponentEffect;
import com.doitbetter.onelife.component.WeaponComponent;
import com.doitbetter.onelife.component.WeaponFamily;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public record PommelComponent(
        Identifier id,
        Map<WeaponFamily, List<ComponentEffect>> effectsByFamily,
        int componentDurability
) implements WeaponComponent {

    public static final Codec<PommelComponent> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Identifier.CODEC.fieldOf("id").forGetter(PommelComponent::id),
                    Codec.unboundedMap(
                            Codec.STRING.xmap(WeaponFamily::valueOf, WeaponFamily::name),
                            ComponentEffect.CODEC.listOf()
                    ).fieldOf("effects_by_family").forGetter(PommelComponent::effectsByFamily),
                    Codec.INT.fieldOf("component_durability").forGetter(PommelComponent::componentDurability)
            ).apply(instance, PommelComponent::new)
    );

    @Override
    public List<ComponentEffect> effectsFor(WeaponFamily family) {
        return effectsByFamily.getOrDefault(family, List.of());
    }

    @Override
    public boolean supportsFamily(WeaponFamily family) {
        return switch (family) {
            case BLADE_SWORD, BLADE_DAGGER, BLUNT -> true;
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