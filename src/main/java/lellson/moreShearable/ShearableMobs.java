package lellson.moreShearable;

import java.util.Random;

import lellson.moreShearable.entity.EntityChickenNaked;
import lellson.moreShearable.entity.EntityCowNaked;
import lellson.moreShearable.entity.EntityLlamaNaked;
import lellson.moreShearable.entity.EntityParrotNaked;
import lellson.moreShearable.entity.EntityPigNaked;
import lellson.moreShearable.entity.EntityPigmanNaked;
import lellson.moreShearable.entity.EntityPolarBearNaked;
import lellson.moreShearable.entity.EntityRabbitNaked;
import lellson.moreShearable.misc.ShearConfig;
import lellson.moreShearable.misc.ShearEntries;
import lellson.moreShearable.misc.ShearEntry;
import lellson.moreShearable.misc.ShearEvents;
import lellson.moreShearable.misc.ShearRegistry;
import lellson.moreShearable.misc.items.ShearItems;
import lellson.moreShearable.proxy.ShearCommon;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = ShearableMobs.MODID, name = ShearableMobs.MODNAME, version = "1.1.2")
public class ShearableMobs {
	
	public static final String MODID = "shear";
	public static final String MODNAME = "More Shearables";
	
	@SidedProxy(clientSide = "lellson.moreShearable.proxy.ShearClient", serverSide = "lellson.moreShearable.proxy.ShearCommon")
	public static ShearCommon proxy;
	
	public static Configuration config;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		ShearItems.init();
		MinecraftForge.EVENT_BUS.register(new ShearRegistry());
		MinecraftForge.EVENT_BUS.register(new ShearEvents());
		proxy.registerRenderers();
		
		int entityId = 0;
		
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "ChickenNaked"), EntityChickenNaked.class, "ChickenNaked", ++entityId, this, 80, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "CowNaked"), EntityCowNaked.class, "CowNaked", ++entityId, this, 80, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "PigNaked"), EntityPigNaked.class, "PigNaked", ++entityId, this, 80, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "PigmanNaked"), EntityPigmanNaked.class, "PigmanNaked", ++entityId, this, 80, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "RabbitNaked"), EntityRabbitNaked.class, "RabbitNaked", ++entityId, this, 80, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "PolarBearNaked"), EntityPolarBearNaked.class, "PolarBearNaked", ++entityId, this, 80, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "ParrotNaked"), EntityParrotNaked.class, "ParrotNaked", ++entityId, this, 80, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(MODID, "LlamaNaked"), EntityLlamaNaked.class, "LlamaNaked", ++entityId, this, 80, 1, true);
		
		config = new Configuration(event.getSuggestedConfigurationFile());
		ShearConfig.sync();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		proxy.itemRenderers();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		for (ShearEntry entry : ShearEntries.getEntries())
			entry.initDropStack(false);
	}
	
	public static void spawnParticle(Entity entity, EnumParticleTypes type, float spread, int amount) {
		
		for (int i = 0; i < amount; i++) {
			Random rnd = entity.getEntityWorld().rand; 
			double moveX = (rnd.nextDouble() - 0.5D) * 2.0D * spread;
			double moveY = -rnd.nextDouble() * spread;
			double moveZ = (rnd.nextDouble() - 0.5D) * 2.0D * spread;
			entity.getEntityWorld().spawnParticle(type, entity.posX + (rnd.nextDouble() - 0.5D) * (double)entity.width, entity.posY + rnd.nextDouble() * (double)entity.height - 0.25D, entity.posZ + (rnd.nextDouble() - 0.5D) * (double)entity.width, moveX, moveY, moveZ, new int[0]);
		}
	}
	
	public static void spawnParticle(Entity entity, EnumParticleTypes type, int amount) {
		spawnParticle(entity, type, 1, amount);
	}
	
	public static void spawnParticle(Entity entity, EnumParticleTypes type) {
		spawnParticle(entity, type, 1);
	}

}
