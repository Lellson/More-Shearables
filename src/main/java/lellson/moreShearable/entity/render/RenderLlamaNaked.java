package lellson.moreShearable.entity.render;

import net.minecraft.client.renderer.entity.RenderLlama;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.util.ResourceLocation;

public class RenderLlamaNaked extends RenderLlama {
	
	private final ResourceLocation llamaNaked = new ResourceLocation("shear:textures/entity/llamaNaked.png");

	public RenderLlamaNaked(RenderManager render) {
		super(render);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityLlama entity)
    {
        return llamaNaked;
    }
}
