package lellson.moreShearable.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPolarBear;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.util.ResourceLocation;

public class RenderPolarBearNaked extends RenderPolarBear {
	
	private final ResourceLocation bearNaked = new ResourceLocation("shear:textures/entity/polarBearNaked.png");

	public RenderPolarBearNaked(RenderManager modelBear, ModelBase model, float f) {
		super(modelBear);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityPolarBear entity) {

		return bearNaked;
	}

}
