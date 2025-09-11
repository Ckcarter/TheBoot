package net.rem.theboot;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rem.theboot.entity.custom.BootEntity;
import net.rem.theboot.item.custom.BootItem;
import org.slf4j.Logger;

import static net.rem.theboot.entity.ModEntities.ENTITY_TYPES;
import static net.rem.theboot.item.ModItems.*;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(TheBoot.MOD_ID)
public class TheBoot {

    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "theboot";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    public TheBoot() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ENTITY_TYPES.register(modEventBus);
        ITEMS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

//    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
//            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheBoot.MOD_ID);
//
//    public static final DeferredRegister<Item> ITEMS =
//            DeferredRegister.create(ForgeRegistries.ITEMS, TheBoot.MOD_ID);
//
//
//    public static final RegistryObject<Item> BOOT =
//            ITEMS.register("boot", () -> new BootItem(new Item.Properties().stacksTo(1)));
//    public static final RegistryObject<Item> LIGHT_BOOT =
//            ITEMS.register("light_boot", () -> new BootItem(new Item.Properties().stacksTo(1)));
//    public static final RegistryObject<EntityType<BootEntity>> FIREBALL_ENTITY =
//            ENTITY_TYPES.register("boot",
//                    () -> EntityType.Builder.<BootEntity>of(BootEntity::new, MobCategory.MISC)
//                            .sized(0.25F, 0.25F)
//                            .build("boot"));
//
//
//    public static final ResourceKey<DamageType> BOOT_DAMAGE_TYPE =
//            ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(TheBoot.MOD_ID, "boot"));
//
//
//
//    // Define mod id in a common place for everything to reference
//
//    // Directly reference a slf4j logger
//    public static final Logger LOGGER = LogUtils.getLogger();
//
//
//
//
//

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(BOOT);
            event.accept(LIGHT_BOOT);
        }
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }


    }
}
