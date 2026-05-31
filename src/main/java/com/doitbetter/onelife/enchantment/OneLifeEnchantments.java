package com.doitbetter.onelife.enchantment;

import com.doitbetter.onelife.OneLife;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class OneLifeEnchantments {

    // =========================================================================
    // WEAPON ENCHANTMENTS
    // =========================================================================
    public static final RegistryKey<Enchantment> SWIFT_STRIKE = of("swift_strike");
    public static final RegistryKey<Enchantment> STAGGER = of("stagger");
    public static final RegistryKey<Enchantment> PRECISION = of("precision");
    public static final RegistryKey<Enchantment> CLEAVE = of("cleave");
    public static final RegistryKey<Enchantment> BLEED = of("bleed");
    public static final RegistryKey<Enchantment> PENETRATE = of("penetrate");
    public static final RegistryKey<Enchantment> CRIPPLE = of("cripple");
    public static final RegistryKey<Enchantment> STUN = of("stun");

    // =========================================================================
    // TOOL ENCHANTMENTS
    // =========================================================================
    public static final RegistryKey<Enchantment> TEMPER = of("temper");
    public static final RegistryKey<Enchantment> HONE = of("hone");

    // =========================================================================
    // UNIVERSAL ENCHANTMENTS
    // =========================================================================
    public static final RegistryKey<Enchantment> WARDING = of("warding");
    public static final RegistryKey<Enchantment> TRACKING = of("tracking");
    public static final RegistryKey<Enchantment> RESONANCE = of("resonance");

    private static RegistryKey<Enchantment> of(String path) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(OneLife.MOD_ID, path));
    }
}