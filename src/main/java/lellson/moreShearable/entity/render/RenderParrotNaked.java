package lellson.moreShearable.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderParrot;
import net.minecraft.client.renderer.entity.RenderPigZombie;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.util.ResourceLocation;

public class RenderParrotNaked extends RenderParrot {
	
	private final ResourceLocation parrotNaked = new ResourceLocation("shear:textures/entity/parrotNaked.png");

	public RenderParrotNaked(RenderManager render) {
		super(render);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityParrot texture)
    {
        return parrotNaked;
    }
}
