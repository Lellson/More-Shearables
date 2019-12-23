package lellson.moreShearable.entity;

import lellson.moreShearable.misc.ShearEntries;
import lellson.moreShearable.misc.ShearEntry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityChickenNaked extends EntityChicken {

	public EntityChickenNaked(World world) {
		super(world);
		this.tasks.addTask(5, new EntityAIEatGrass(this));
	}
	
	public void eatGrassBonus() {
		
		setDead();
        EntityChicken entityChicken = new EntityChicken(this.getEntityWorld());
        entityChicken.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
        entityChicken.setHealth(this.getHealth());
        entityChicken.renderYawOffset = renderYawOffset;
        
        this.getEntityWorld().spawnEntity(entityChicken);
    }
}
