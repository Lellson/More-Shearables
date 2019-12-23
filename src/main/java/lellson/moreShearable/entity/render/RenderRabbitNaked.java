package lellson.moreShearable.entity.render;

import lellson.moreShearable.entity.EntityRabbitNaked;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderRabbit;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.util.ResourceLocation;

public class RenderRabbitNaked extends RenderRabbit {

	private final ResourceLocation rabbitNaked = new ResourceLocation("shear:textures/entity/rabbitNaked.png");

	public RenderRabbitNaked(RenderManager render, ModelBase model, float f) {
		super(render);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityRabbit texture)
    {
        return rabbitNaked;
    }

}

