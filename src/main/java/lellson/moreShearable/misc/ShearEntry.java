package lellson.moreShearable.misc;

import java.lang.reflect.InvocationTargetException;

import lellson.moreShearable.ShearableMobs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class ShearEntry {
	
	private Class<? extends EntityLivingBase> clazz;
	private Class<? extends EntityLivingBase> clazzSheared;
	private String name;
	private float pitch;
	private String defaultDropString;
	private boolean dropsItem = true;
	
	private boolean disable;
	private String dropString;
	
	private ItemStack dropStack = null;
	private boolean variantMeta = false;
	
	public ShearEntry(Class<? extends EntityLivingBase> clazz, Class<? extends EntityLivingBase> clazzSheared, String name, float pitch, String defaultDropString) {
		this.clazz = clazz;
		this.clazzSheared = clazzSheared;
		this.name = name;
		this.pitch = pitch;
		this.defaultDropString = defaultDropString;
	}
	
	public ShearEntry(Class<? extends EntityLivingBase> clazz, Class<? extends EntityLivingBase> clazzSheared, String name, float pitch) {
		this(clazz, clazzSheared, name, pitch, "");
		this.dropsItem = false;
	}
	
	public Class<? extends EntityLivingBase> getEntityClass() {
		return clazz;
	}
	
	public Class<? extends EntityLivingBase> getShearedEntityClass() {
		return clazz;
	}
	
	public String getName() {
		return name;
	}
	
	public ItemStack getDrop() {
		return dropStack;
	}
	
	public void initConfig() {
		disable = ShearableMobs.config.getBoolean(name.replace(" ", "") + "Disable", ShearConfig.DISABLE, false, "Set to true, to disable " + name + " shearing");
		if (dropsItem)
			dropString = ShearableMobs.config.getString(name.replace(" ", "") + "Drop", ShearConfig.DROPS, defaultDropString, "A " + name + " drops this when sheared");
	}
	
	public boolean initDropStack(boolean useDefault) {
		
		if (!dropsItem)
			return false;
		
		String[] split = useDefault ? defaultDropString.split(";") : dropString.split(";");
		
		if (split.length < 2)
			return DropError("Invalid amount of args. At least 2 args are required!");
			
		Item drop = Item.REGISTRY.getObject(new ResourceLocation(split[0]));
		if (drop == null)
			return DropError(split[0] + " is not a valid item!");
		
		int maxStacksize;
		try 
		{
			maxStacksize = Integer.parseInt(split[1]);
			
			if (maxStacksize < 1)
				return DropError("Stacksize must be at least 1!");
		}
		catch(NumberFormatException e) 
		{
			return DropError(split[1] + " is not a valid number!");
		}
		
		int meta = 0;
		if (split.length > 2)
		{
			try 
			{
				if (split[2].toUpperCase().equals("VARIANT"))
					variantMeta = true;
				else
					meta = Integer.parseInt(split[2]);
			}
			catch(NumberFormatException e) 
			{
				return DropError(split[2] + " is not a valid number!");
			}
		}
		
		this.dropStack = new ItemStack(drop, maxStacksize, meta);
		
		return true;
	}
	
	public boolean DropError(String msg) {
		FMLLog.bigWarning("Error on initialising " + name + " shear drop: " + msg + " (Line: " + dropString + ")");
		initDropStack(true);
		return false;
	}
	
	public EntityLivingBase createEntity(World world, EntityLivingBase oldEntity, EntityPlayer player) {
		
		EntityLivingBase newEntity = null;
		try {
			newEntity = ReflectionHelper.findConstructor(clazzSheared, World.class).newInstance(world);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			FMLLog.bigWarning(e.getMessage());
		}
		//newEntity.setLocationAndAngles(oldEntity.posX, oldEntity.posY, oldEntity.posZ, oldEntity.rotationYaw, oldEntity.rotationPitch);
		newEntity.setPositionAndRotation(oldEntity.posX, oldEntity.posY, oldEntity.posZ, oldEntity.rotationYaw, oldEntity.rotationPitch);
		newEntity.setHealth(oldEntity.getHealth());
		oldEntity.setDead();
		
        return newEntity;
	}
	
	public void shear(World world, ItemStack item, EntityPlayer player, EntityLivingBase oldEntity) {
		
		EntityLivingBase newEntity = createEntity(world, oldEntity, player);
		world.spawnEntity(newEntity);
        
        if (this.dropStack != null)
        {
        	int stacksize = 1 + (this.dropStack.getCount()-1 > 0 ? world.rand.nextInt(this.dropStack.getCount()) : 0);
        	int meta = this.dropStack.getMetadata();
        	
        	if (variantMeta && oldEntity instanceof EntityLlama)
        	{
        		int variant = ((EntityLlama)oldEntity).getVariant();
        		meta = variant == 2 ? 12 : variant == 3 ? 8 : 0;
        	}

        	newEntity.entityDropItem(new ItemStack(this.dropStack.getItem(), stacksize, meta), 0);
        }
        
        item.damageItem(1, player);
        newEntity.playSound(SoundEvents.ENTITY_SHEEP_SHEAR, 1.0F, pitch);
	}

	public boolean canShear(EntityLivingBase entity) {
		return !disable && !entity.isChild() && (clazzSheared == null || !clazzSheared.isInstance(entity));
	}
}
