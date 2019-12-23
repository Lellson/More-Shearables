package lellson.moreShearable.entity;

import lellson.moreShearable.misc.ShearEntries;
import lellson.moreShearable.misc.ShearEntry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.world.World;

public class EntityRabbitNaked extends EntityRabbit {

	public EntityRabbitNaked(World world) {
		super(world);
		this.tasks.addTask(5, new EntityAIEatGrass(this));
	}
	
	public void eatGrassBonus() {
		
		setDead();
        EntityRabbit entityRabbit = new EntityRabbit(this.getEntityWorld());
        entityRabbit.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
        entityRabbit.setHealth(this.getHealth());
        entityRabbit.renderYawOffset = renderYawOffset;
        
        this.getEntityWorld().spawnEntity(entityRabbit);
    }
}
