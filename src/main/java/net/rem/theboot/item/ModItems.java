package net.rem.theboot.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rem.theboot.TheBoot;
import net.rem.theboot.item.custom.BootItem;


public class ModItems {






    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheBoot.MOD_ID);

    public static final RegistryObject<Item> BOOT = ITEMS.register("boot",
            () -> new BootItem(new Item.Properties()));

    public static final RegistryObject<Item> LIGHT_BOOT = ITEMS.register("light_boot",
            () -> new BootItem(new Item.Properties()));


    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TheBoot.MOD_ID);



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }





}
