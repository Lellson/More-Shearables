package lellson.moreShearable.misc.items;

import java.util.List;

import lellson.moreShearable.ShearableMobs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class ItemPolarBearArmor extends ItemArmor {

	public ItemPolarBearArmor(EntityEquipmentSlot equipmentSlotIn) {
		super(ShearItems.materialPolarBear, 0, equipmentSlotIn);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {

		return slot.equals(EntityEquipmentSlot.LEGS) ? "shear:textures/models/armor/bear_layer_2.png" : "shear:textures/models/armor/bear_layer_1.png";
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		
		return material.isItemEqual(new ItemStack(ShearItems.polarBearHide));
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		
		ItemStack head = player.inventory.armorItemInSlot(3);;
		ItemStack chest = player.inventory.armorItemInSlot(2);
		ItemStack legs = player.inventory.armorItemInSlot(1);
		ItemStack boots = player.inventory.armorItemInSlot(0);
		
		if (!(head == null || chest == null || legs == null || boots == null)) {
			if (head.getItem() == ShearItems.polarBearHelmet && chest.getItem() == ShearItems.polarBearChest && legs.getItem() == ShearItems.polarBearLegs && boots.getItem() == ShearItems.polarBearBoots) {
				
				List<EntityPolarBear> list = world.getEntitiesWithinAABB(EntityPolarBear.class, player.getEntityBoundingBox().expand(5, 3, 5));
				
				for (EntityPolarBear bear : list) {
					
					bear.setAttackTarget(player);
					bear.setRevengeTarget(player);
				}
			}
		}
	}

}
