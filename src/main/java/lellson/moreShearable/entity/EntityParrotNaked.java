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

public class EntityParrotNaked extends EntityParrot {
	
	public EntityParrotNaked(World world) {
		super(world);
		this.tasks.addTask(2, new EntityAIEatGrass(this));
	}
	
	public void eatGrassBonus() {
		
		setDead();
        EntityParrot parrot = new EntityParrot(this.getEntityWorld());
        parrot.setVariant(this.getVariant());
        parrot.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
        parrot.setHealth(this.getHealth());
        parrot.renderYawOffset = renderYawOffset;
        
        this.getEntityWorld().spawnEntity(parrot);
	}
}
