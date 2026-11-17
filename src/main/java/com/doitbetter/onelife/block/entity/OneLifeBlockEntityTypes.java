package com.doitbetter.onelife.block.entity;

import com.doitbetter.onelife.OneLife;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class OneLifeBlockEntityTypes {

    public static final BlockEntityType<TanningRackBlockEntity> TANNING_RACK = register(
            "tanning_rack",
            BlockEntityType.Builder.
    )

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, RegistryKey.of(RegistryKeys.BLOCK_ENTITY_TYPE, Identifier.of(OneLife.MOD_ID, name)), type);
    }

    public static void register() {}
}
