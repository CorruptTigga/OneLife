package com.doitbetter.onelife.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;

public record ComponentEffect(
        Identifier effect,
        boolean isBinary
) {
    public static final Codec<ComponentEffect> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Identifier.CODEC.fieldOf("effect").forGetter(ComponentEffect::effect),
                    Codec.BOOL.fieldOf("binary").forGetter(ComponentEffect::isBinary)
            ).apply(instance, ComponentEffect::new)
    );

    public int resolveLevel(ComponentQuality quality) {
        return isBinary ? 1 : quality.getLevel();
    }
}