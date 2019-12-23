package lellson.moreShearable.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class RenderCowNaked extends RenderCow {
	
	private final ResourceLocation cowNaked = new ResourceLocation("shear:textures/entity/cowNaked.png");

	public RenderCowNaked(RenderManager render, ModelBase model, float f) {
		super(render);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityCow p_110775_1_)
    {
        return cowNaked;
    }

}
