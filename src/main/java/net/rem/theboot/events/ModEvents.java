package net.rem.theboot.events;



import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.rem.theboot.TheBoot;
import net.rem.theboot.entity.custom.BootEntity;
import net.rem.theboot.events.custom.DeathTextEvent;
import net.rem.theboot.item.ModItems;

@Mod.EventBusSubscriber(modid = TheBoot.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent event){
        if(event.getEntity() instanceof Sheep){
            if(event.getSource().getDirectEntity() instanceof Player player){
                if(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItems.BOOT.get()) {
                    TheBoot.LOGGER.info("Sheep was hit with Alexandrite Axe by " + player.getName().getString());
                }
                if(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == Items.DIAMOND) {
                    TheBoot.LOGGER.info("Sheep was hit with a DIAMOND by " + player.getName().getString());
                }else{
                    TheBoot.LOGGER.info("Sheep was hit with a U.F.O. by " + player.getName().getString());
                }
            }
        }


    }
    @SubscribeEvent
    public static void livingDeath(LivingDeathEvent event) {


        LivingEntity entity = event.getEntity();
        if (!entity.level().isClientSide() && event.getSource().getDirectEntity() instanceof BootEntity) {
            Component message = Component.literal("Hey " + entity.getDisplayName().getString() + ", Boot to the Head!");
            DeathTextEvent textEvent = new DeathTextEvent(entity, message);
            MinecraftForge.EVENT_BUS.post(textEvent);
            for (Player player : entity.level().players()) {
                player.sendSystemMessage(textEvent.getText());
            }
        }
    }

}