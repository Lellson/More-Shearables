package lellson.moreShearable.entity;

import lellson.moreShearable.misc.ShearEntries;
import lellson.moreShearable.misc.ShearEntry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityCowNaked extends EntityCow {

	public EntityCowNaked(World world) {
		super(world);
		this.tasks.addTask(5, new EntityAIEatGrass(this));
	}
	
	public void eatGrassBonus() {
		
		setDead();
        EntityCow entityCow = new EntityCow(this.getEntityWorld());
        entityCow.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
        entityCow.setHealth(this.getHealth());
        entityCow.renderYawOffset = renderYawOffset;
        
        this.getEntityWorld().spawnEntity(entityCow);
		
    }
}
