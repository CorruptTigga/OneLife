package com.doitbetter.onelife.component;

import com.doitbetter.onelife.OneLife;
import net.minecraft.util.Identifier;

public class OneLifeEffects {

    // =========================================================================
    // WEAPON EFFECTS
    // =========================================================================
    public static final Identifier SWIFT_STRIKE = of("swift_strike");      // Dagger attack speed
    public static final Identifier STAGGER = of("stagger");                // Chance to stagger on hit
    public static final Identifier PRECISION = of("precision");            // Increased critical hit chance
    public static final Identifier CLEAVE = of("cleave");                  // Sweeping edge equivalent

    // =========================================================================
    // TOOL EFFECTS
    // =========================================================================
    public static final Identifier TEMPER = of("temper");                  // Increased durability recovery
    public static final Identifier HONE = of("hone");                      // Increased mining speed

    private static Identifier of(String path) {
        return Identifier.of(OneLife.MOD_ID, path);
    }
}