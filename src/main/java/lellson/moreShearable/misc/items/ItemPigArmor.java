package lellson.moreShearable.misc.items;

import java.util.List;

import lellson.moreShearable.ShearableMobs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemPigArmor extends ItemArmor {

	public ItemPigArmor(EntityEquipmentSlot type) {
		super(ShearItems.materialPig, 0, type);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {

		return slot.equals(EntityEquipmentSlot.LEGS) ? "shear:textures/models/armor/pig_layer_2.png" : "shear:textures/models/armor/pig_layer_1.png";
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		
		return material.isItemEqual(new ItemStack(ShearItems.pigSkin));
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		
		ItemStack head = player.inventory.armorItemInSlot(3);
		ItemStack chest = player.inventory.armorItemInSlot(2);
		ItemStack legs = player.inventory.armorItemInSlot(1);
		ItemStack boots = player.inventory.armorItemInSlot(0);
		
		if (!(head == null || chest == null || legs == null || boots == null)) {
			if (head.getItem() == ShearItems.pigHelmet && chest.getItem() == ShearItems.pigChest && legs.getItem() == ShearItems.pigLegs && boots.getItem() == ShearItems.pigBoots) {
				
				List<EntityPig> list = world.getEntitiesWithinAABB(EntityPig.class, player.getEntityBoundingBox().expand(5, 3, 5));
				
				for (EntityPig pig : list) {

					ShearableMobs.spawnParticle(pig, EnumParticleTypes.WATER_DROP, 1.5F, 1);
					
					pig.setAttackTarget(player);
					pig.setRevengeTarget(player);
				}
				
				List<EntityPigZombie> list2 = world.getEntitiesWithinAABB(EntityPigZombie.class, player.getEntityBoundingBox().expand(5, 3, 5));
				
				for (EntityPigZombie pigZ : list2) {
					
					pigZ.setAttackTarget(player);
					pigZ.setRevengeTarget(player);
				}	
			}
		}
	}

}
