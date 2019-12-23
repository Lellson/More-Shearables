package lellson.moreShearable.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPigZombie;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class RenderPigmanNaked extends RenderPigZombie {
	
	private final ResourceLocation pigmanNaked = new ResourceLocation("shear:textures/entity/pigmanNaked.png");

	public RenderPigmanNaked(RenderManager render) {
		super(render);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityPigZombie texture)
    {
        return pigmanNaked;
    }

}
