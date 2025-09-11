package net.rem.theboot.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.rem.theboot.TheBoot;
import net.rem.theboot.util.ModTags;


import java.util.List;

public class ModToolsTiers {
    public class ModToolTiers {
        public static final Tier LIGHT_BOOT = TierSortingRegistry.registerTier(
                new ForgeTier(5, 1500, 5f, 0f, 25,
                        ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.BOOT.get())),
                new ResourceLocation(TheBoot.MOD_ID, "boot"), List.of(Tiers.NETHERITE), List.of());

    }

}

