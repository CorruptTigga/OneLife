package com.doitbetter.onelife.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;

public record AttachedComponent(Identifier componentId, ComponentQuality quality) {
    public static final Codec<AttachedComponent> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        Identifier.CODEC.fieldOf("componentId").forGetter(AttachedComponent::componentId),
                        Codec.STRING.xmap(ComponentQuality::valueOf, ComponentQuality::name)
                                .fieldOf("quality").forGetter(AttachedComponent::quality)
                ).apply(instance, AttachedComponent::new)
            );
}
