package lellson.moreShearable.misc;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import lellson.moreShearable.entity.EntityChickenNaked;
import lellson.moreShearable.entity.EntityCowNaked;
import lellson.moreShearable.entity.EntityLlamaNaked;
import lellson.moreShearable.entity.EntityParrotNaked;
import lellson.moreShearable.entity.EntityPigNaked;
import lellson.moreShearable.entity.EntityPigmanNaked;
import lellson.moreShearable.entity.EntityPolarBearNaked;
import lellson.moreShearable.entity.EntityRabbitNaked;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLLog;

public class ShearEntries {
	
	private static final List<ShearEntry> ENTRIES = new ArrayList<ShearEntry>();
	
	public static final ShearEntry CHICKEN = new ShearEntry(EntityChicken.class, EntityChickenNaked.class, "chicken", 1.4f, "feather;1");
	public static final ShearEntry PIG = new ShearEntry(EntityPig.class, EntityPigNaked.class, "pig", 1f, "shear:pigSkin;1");
	public static final ShearEntry COW = new ShearEntry(EntityCow.class, EntityCowNaked.class, "cow", 0.6f, "leather;2") {
		@Override
		public boolean canShear(EntityLivingBase entity) {
			return super.canShear(entity) && !(entity instanceof EntityMooshroom);
		}
	};
	public static final ShearEntry PIGMAN = new ShearEntry(EntityPigZombie.class, EntityPigmanNaked.class, "pigman", 0.6f, "rotten_flesh;1") {
		
		@Override
		public EntityLivingBase createEntity(World world, EntityLivingBase oldEntity, EntityPlayer player) {
			
			EntityLivingBase newEntity = super.createEntity(world, oldEntity, player);
			
			if (!player.isCreative() && !player.isSpectator())
			{
				((EntityPigmanNaked) newEntity).setAttackTarget(player);
				((EntityPigmanNaked) newEntity).setRevengeTarget(player);
			}
			
			for (EntityEquipmentSlot slot : EntityEquipmentSlot.values())
			{
				if (oldEntity.hasItemInSlot(slot))
				{
					newEntity.setItemStackToSlot(slot, oldEntity.getItemStackFromSlot(slot));
				}
			}
				
			return newEntity;
		}
	};
	public static final ShearEntry RABBIT = new ShearEntry(EntityRabbit.class, EntityRabbitNaked.class, "rabbit", 1.2f, "rabbit_hide;1");
	public static final ShearEntry POLAR_BEAR = new ShearEntry(EntityPolarBear.class, EntityPolarBearNaked.class, "polar bear", 0.5f, "shear:polarBearHide;3");
	public static final ShearEntry PARROT = new ShearEntry(EntityParrot.class, EntityParrotNaked.class, "parrot", 1.4f, "feather;1") {
		
		@Override
		public EntityLivingBase createEntity(World world, EntityLivingBase oldEntity, EntityPlayer player) {
			
			EntityLivingBase newEntity = super.createEntity(world, oldEntity, player);
			((EntityParrot)newEntity).setVariant(((EntityParrot)oldEntity).getVariant());
			return newEntity;
		}
		
		@Override
		public boolean canShear(EntityLivingBase entity) {
			return super.canShear(entity) && !((EntityParrot)entity).isTamed();
		}
	};
	public static final ShearEntry LLAMA = new ShearEntry(EntityLlama.class, EntityLlamaNaked.class, "llama", 0.8f, "wool;2;VARIANT") {
		
		@Override
		public EntityLivingBase createEntity(World world, EntityLivingBase oldEntity, EntityPlayer player) {
			
			EntityLivingBase newEntity = super.createEntity(world, oldEntity, player);
			((EntityLlama)newEntity).setVariant(((EntityLlama)oldEntity).getVariant());
			return newEntity;
		}
		
		@Override
		public boolean canShear(EntityLivingBase entity) {
			return super.canShear(entity) && !((EntityLlama)entity).isTame();
		}
	};
	public static final ShearEntry CREEPER = new ShearEntry(EntityCreeper.class, null, "creeper", 1f) {
		
		@Override
		public void shear(World world, ItemStack item, EntityPlayer player, EntityLivingBase entity) {
			
			world.createExplosion(entity, entity.posX, entity.posY, entity.posZ, 3, true);
			entity.setDead();
		};
	};
	
	public static List<ShearEntry> getEntries() {
		
		if (ENTRIES.isEmpty())
		{
			try 
			{
				for (Field field : ShearEntries.class.getFields())
				{
					field.setAccessible(true);
					Object obj = field.get(null);
					if (obj instanceof ShearEntry)
					{
						ENTRIES.add((ShearEntry)obj);
					}
				}
			}
			catch(IllegalArgumentException | IllegalAccessException e)
			{
				FMLLog.bigWarning(e.getMessage());
			}
		}
		
		return ENTRIES;
	}
}
