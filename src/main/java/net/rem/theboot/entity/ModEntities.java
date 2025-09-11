package net.rem.theboot.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rem.theboot.TheBoot;
import net.rem.theboot.entity.custom.BootEntity;


public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheBoot.MOD_ID);


    public static final RegistryObject<EntityType<BootEntity>> BOOT_ENTITY =
            ENTITY_TYPES.register("boot",
                    () -> EntityType.Builder.<BootEntity>of(BootEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .build("boot"));

}
