package lellson.moreShearable.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.ResourceLocation;

public class RenderChickenNaked extends RenderChicken {
	
	private final ResourceLocation chickenNaked = new ResourceLocation("shear:textures/entity/chickenNaked.png");

	public RenderChickenNaked(RenderManager render, ModelBase model, float f) {
		super(render);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityChicken p_110775_1_)
    {
        return chickenNaked;
    }

}
