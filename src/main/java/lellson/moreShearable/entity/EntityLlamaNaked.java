package lellson.moreShearable.entity;

import lellson.moreShearable.misc.ShearEntries;
import lellson.moreShearable.misc.ShearEntry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityLlamaNaked extends EntityLlama {

	public EntityLlamaNaked(World world) {
		super(world);
		this.tasks.addTask(5, new EntityAIEatGrass(this));
	}
	
	public void eatGrassBonus() {
		
		setDead();
        EntityLlama llama = new EntityLlama(this.getEntityWorld());
        llama.setVariant(this.getVariant());
        llama.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
        llama.setHealth(this.getHealth());
        llama.renderYawOffset = renderYawOffset;
        
        this.getEntityWorld().spawnEntity(llama);
    }
	
	@Override
	public boolean canEatGrass() {
		return true;
	}
}
