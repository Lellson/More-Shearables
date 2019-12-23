package lellson.moreShearable.entity;

import java.util.Random;

import lellson.moreShearable.misc.ShearEntries;
import lellson.moreShearable.misc.ShearEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityPigmanNaked extends EntityPigZombie {

	public EntityPigmanNaked(World world) {
		super(world);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if (ticksExisted >= 2400) {
			
			setDead();
	        EntityPigZombie entityPigman = new EntityPigZombie(this.getEntityWorld());
	        entityPigman.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
	        entityPigman.setHealth(this.getHealth());
	        entityPigman.renderYawOffset = renderYawOffset;
	        
	        if (this.getHeldItemMainhand() != null)
	        	entityPigman.setHeldItem(EnumHand.MAIN_HAND, this.getHeldItemMainhand());
	        
	        this.getEntityWorld().spawnEntity(entityPigman);	
		}
		
		Random rnd = this.getEntityWorld().rand;
		this.getEntityWorld().spawnParticle(EnumParticleTypes.SMOKE_NORMAL, posX + rand.nextDouble() - 0.5D, posY + rand.nextDouble() * 2, posZ + rand.nextDouble() - 0.5D, 0, 0, 0, 0);
	}
	
	@Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
    }
}
