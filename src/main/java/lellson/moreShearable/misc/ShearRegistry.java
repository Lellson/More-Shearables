package lellson.moreShearable.misc;

import java.util.List;

import lellson.moreShearable.ShearableMobs;
import lellson.moreShearable.misc.items.ShearItems;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber(modid = ShearableMobs.MODID)
public class ShearRegistry {

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(ShearItems.clipper);
		registry.register(ShearItems.pigBoots);
		registry.register(ShearItems.pigChest);
		registry.register(ShearItems.pigHelmet);
		registry.register(ShearItems.pigLegs);
		registry.register(ShearItems.pigSkin);
		registry.register(ShearItems.polarBearBoots);
		registry.register(ShearItems.polarBearChest);
		registry.register(ShearItems.polarBearHelmet);
		registry.register(ShearItems.polarBearHide);
		registry.register(ShearItems.polarBearLegs);
	}
}
