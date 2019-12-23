package lellson.moreShearable.misc;

import java.io.File;

import lellson.moreShearable.ShearableMobs;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ShearConfig {
	
	public static final String GENERAL = "GENERAL";
	public static final String DISABLE = "DISABLE";
	public static final String DROPS = "DROPS";

	public static void sync() {
		
		ShearableMobs.config.load();
		
		ShearableMobs.config.addCustomCategoryComment(GENERAL, "General settings");
		ShearableMobs.config.addCustomCategoryComment(DISABLE, "Disable shearing of entities");
		ShearableMobs.config.addCustomCategoryComment(DROPS, "Mob Drops\nFormat: modid:itemName;maxamount;meta\nmeta is optional. VARIANT only works for llamas and changes the meta depending on the llama variant");
		
		ShearEvents.canUseVanillaShears = ShearableMobs.config.getBoolean("canUseVanillaShears", GENERAL, false, "If true vanilla shears can be used to shear entities");
		
		for (ShearEntry entry : ShearEntries.getEntries())
			entry.initConfig();
		
		if (ShearableMobs.config.hasChanged()) {
			ShearableMobs.config.save();
		}
	}
}
