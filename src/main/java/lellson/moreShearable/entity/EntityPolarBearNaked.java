package lellson.moreShearable.entity;

import java.util.Random;

import lellson.moreShearable.misc.ShearEntries;
import lellson.moreShearable.misc.ShearEntry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityPolarBearNaked extends EntityPolarBear {

	public EntityPolarBearNaked(World world) {
		super(world);
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		Random rnd = this.rand;
		
		if (this.isInWater() && this.ticksExisted % 200 == 0 && rnd.nextInt(3) == 0 && !this.getEntityWorld().isRemote) 
		{
			setDead();
	        EntityPolarBear entityPolarBear = new EntityPolarBear(this.getEntityWorld());
	        entityPolarBear.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
	        entityPolarBear.setHealth(this.getHealth());
	        entityPolarBear.renderYawOffset = renderYawOffset;
	        
	        spawnParticle(this, EnumParticleTypes.WATER_BUBBLE, 15);
	        this.getEntityWorld().playSound(this.posX, this.posY, this.posZ, SoundEvents.ENTITY_HORSE_EAT, SoundCategory.AMBIENT, 1.0F, 0.8F, false);
	        
	        this.getEntityWorld().spawnEntity(entityPolarBear);
		}
	}
	
	private void spawnParticle(Entity entity, EnumParticleTypes type, int amount) {
		
		Random rnd = entity.getEntityWorld().rand;
		
		for (int i = 0; i < amount; i++)
			this.getEntityWorld().spawnParticle(type, entity.posX + rnd.nextDouble() - rnd.nextDouble(), entity.posY + rnd.nextDouble(), entity.posZ + rnd.nextDouble() - rnd.nextDouble(), rnd.nextDouble() - rnd.nextDouble() + i * 0.5D, rnd.nextDouble() - rnd.nextDouble() + i * 0.5D, rnd.nextDouble() - rnd.nextDouble() + i * 0.5D, 1);
	}
}
