package lellson.moreShearable.misc;

import java.util.Iterator;
import java.util.List;

import lellson.moreShearable.ShearableMobs;
import lellson.moreShearable.entity.EntityCowNaked;
import lellson.moreShearable.misc.items.ShearItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ShearEvents {

	public static boolean canUseVanillaShears;
	
	@SubscribeEvent
	public void livingDrops(LivingDropsEvent event) {
		
		for (ShearEntry entry : ShearEntries.getEntries())
			if (entry.getShearedEntityClass().isInstance(event.getEntityLiving()))
				removeDrop(event.getDrops(), entry.getDrop());
	}

	private void removeDrop(List<EntityItem> drops, ItemStack item) {
		
		if (item == null)
			return;
		
		Iterator<EntityItem> it = drops.iterator();
		
		while(it.hasNext())
		{
			EntityItem eitem = it.next();
			if (eitem.getItem().isItemEqual(item))
				it.remove();
		}
	}
	
	@SubscribeEvent
	public void onRightclickEntity(PlayerInteractEvent.EntityInteract event) {
		
		if (canUseVanillaShears && event.getSide() == Side.SERVER && !event.getWorld().isRemote && event.getTarget() instanceof EntityLivingBase && !event.getItemStack().isEmpty() && !event.getItemStack().isItemEqualIgnoreDurability(new ItemStack(ShearItems.clipper))) 
		{
			EntityLivingBase entity = (EntityLivingBase) event.getTarget();
			for (ShearEntry entry : ShearEntries.getEntries())
			{
				if (entry.getEntityClass().isInstance(entity) && entry.canShear(entity))
				{
					entry.shear(event.getWorld(), event.getItemStack(), event.getEntityPlayer(), entity);
				}
			}
		}
	}
}
