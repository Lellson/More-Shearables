package lellson.moreShearable.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;

public class RenderPigNaked extends RenderPig {
	
	private final ResourceLocation pigNaked = new ResourceLocation("shear:textures/entity/pigNaked.png");

	public RenderPigNaked(RenderManager modelPig, ModelBase model, float f) {
		super(modelPig);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityPig pig)
    {
        return pigNaked;
    }

}
