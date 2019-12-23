package lellson.moreShearable.misc.items;

import lellson.moreShearable.ShearableMobs;
import lellson.moreShearable.misc.ShearEntries;
import lellson.moreShearable.misc.ShearEntry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLLog;

public class ItemClipper extends ItemShears {
	
	@Override
	public boolean itemInteractionForEntity(ItemStack item, EntityPlayer player, EntityLivingBase entity, EnumHand hand) {
		super.itemInteractionForEntity(item, player, entity, hand);
		
		World world = entity.getEntityWorld();
		
		if (!world.isRemote) {
			
			for (ShearEntry entry : ShearEntries.getEntries())
			{
				if (entry.getEntityClass().isInstance(entity) && entry.canShear(entity))
				{
					entry.shear(world, item, player, entity);
				}
			}
		}
		
		return false;
	}
}
