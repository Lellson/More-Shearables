package lellson.moreShearable.entity;

import lellson.moreShearable.misc.ShearEntries;
import lellson.moreShearable.misc.ShearEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityPigNaked extends EntityPig {

	public EntityPigNaked(World world) {
		super(world);
		this.tasks.addTask(5, new EntityAIEatGrass(this));
		this.setAIMoveSpeed(0.0F);
	}
	
	public void eatGrassBonus() {
		
		setDead();
        EntityPig entityPig = new EntityPig(this.getEntityWorld());
        entityPig.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
        entityPig.setHealth(this.getHealth());
        entityPig.renderYawOffset = renderYawOffset;
        
        if (this.getSaddled()) {
        	entityPig.setSaddled(true);
        }
        
        this.getEntityWorld().spawnEntity(entityPig);
		
    }
}
