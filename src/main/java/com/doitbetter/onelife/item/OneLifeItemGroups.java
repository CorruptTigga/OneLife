package com.doitbetter.onelife.item;

import com.doitbetter.onelife.OneLife;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class OneLifeItemGroups {

    public static ItemGroup GENERIC_GROUP = registerItemGroup(
            "generic_group",
            () -> new ItemStack(OneLifeItems.OAK_STICK),
            ((displayContext, entries) -> {
                entries.add(OneLifeItems.ACACIA_STICK);
                entries.add(OneLifeItems.OAK_STICK);
            }));

    /**
     * ItemGroups helper method
     * @param name The registry path name (e.g., "weapons_group")
     * @param iconSupplier A supplier providing the item stack for the tab's icon
     * @return The fully registered ItemGroup instance
     */
    private static ItemGroup registerItemGroup(String name, Supplier<ItemStack> iconSupplier, ItemGroup.EntryCollector entries) {
        Identifier id = Identifier.of(OneLife.MOD_ID, name);

        ItemGroup group = FabricItemGroup.builder()
                .icon(iconSupplier)
                .displayName(Text.translatable("itemGroup.onelife." + name))
                .entries(entries)
                .build();

        return Registry.register(Registries.ITEM_GROUP, id, group);
    }

    public static void register() {
        OneLife.LOGGER.info("Setting up Item Groups...");
    }
}
