package lellson.moreShearable.proxy;

import lellson.moreShearable.entity.EntityChickenNaked;
import lellson.moreShearable.entity.EntityCowNaked;
import lellson.moreShearable.entity.EntityLlamaNaked;
import lellson.moreShearable.entity.EntityParrotNaked;
import lellson.moreShearable.entity.EntityPigNaked;
import lellson.moreShearable.entity.EntityPigmanNaked;
import lellson.moreShearable.entity.EntityPolarBearNaked;
import lellson.moreShearable.entity.EntityRabbitNaked;
import lellson.moreShearable.entity.render.RenderChickenNaked;
import lellson.moreShearable.entity.render.RenderCowNaked;
import lellson.moreShearable.entity.render.RenderLlamaNaked;
import lellson.moreShearable.entity.render.RenderParrotNaked;
import lellson.moreShearable.entity.render.RenderPigNaked;
import lellson.moreShearable.entity.render.RenderPigmanNaked;
import lellson.moreShearable.entity.render.RenderPolarBearNaked;
import lellson.moreShearable.entity.render.RenderRabbitNaked;
import lellson.moreShearable.misc.items.ShearItems;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelParrot;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelPolarBear;
import net.minecraft.client.model.ModelRabbit;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderParrot;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ShearClient extends ShearCommon {
	
	@Override
	public void registerRenderers() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityChickenNaked.class, new IRenderFactory() {

			@Override
			public Render createRenderFor(RenderManager manager) {

				return new RenderChickenNaked(manager, new ModelChicken(), 0.3F);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPigNaked.class, new IRenderFactory() {

			@Override
			public Render createRenderFor(RenderManager manager) {

				return new RenderPigNaked(manager, new ModelPig(), 0.5F);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityCowNaked.class, new IRenderFactory() {

			@Override
			public Render createRenderFor(RenderManager manager) {

				return new RenderCowNaked(manager, new ModelCow(), 0.5F);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPigmanNaked.class, new IRenderFactory() {

			@Override
			public Render createRenderFor(RenderManager manager) {

				return new RenderPigmanNaked(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityRabbitNaked.class, new IRenderFactory() {

			@Override
			public Render createRenderFor(RenderManager manager) {

				return new RenderRabbitNaked(manager, new ModelRabbit(), 0.3F);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPolarBearNaked.class, new IRenderFactory() {

			@Override
			public Render createRenderFor(RenderManager manager) {

				return new RenderPolarBearNaked(manager, new ModelPolarBear(), 0.6F);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityParrotNaked.class, new IRenderFactory() {

			@Override
			public Render createRenderFor(RenderManager manager) {

				return new RenderParrotNaked(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityLlamaNaked.class, new IRenderFactory() {

			@Override
			public Render createRenderFor(RenderManager manager) {

				return new RenderLlamaNaked(manager);
			}
		});
	}
	
	@Override
	public void itemRenderers() {
		ShearItems.renderInit();
	}
}
