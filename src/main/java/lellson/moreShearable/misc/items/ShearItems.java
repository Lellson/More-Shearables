package lellson.moreShearable.misc.items;

import lellson.moreShearable.ShearableMobs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ShearItems {
	
	public static Item clipper;
	public static Item pigSkin;
	public static Item polarBearHide;
	
	public static Item pigHelmet;
	public static Item pigChest;
	public static Item pigLegs;
	public static Item pigBoots;
	
	public static Item polarBearHelmet;
	public static Item polarBearChest;
	public static Item polarBearLegs;
	public static Item polarBearBoots;
	
	public static ArmorMaterial materialPig = EnumHelper.addArmorMaterial("materialPig", "materialPig", 2, new int[]{1, 3, 2, 1}, 3, SoundEvents.ENTITY_PIG_AMBIENT, 0.0F);
	public static ArmorMaterial materialPolarBear = EnumHelper.addArmorMaterial("materialPolarBear", "materialPolarBear", 10, new int[]{1, 3, 2, 1}, 13, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 5.0F);

	public static void init() {
		
		clipper = new ItemClipper().setUnlocalizedName("clipper").setRegistryName("clipper").setCreativeTab(CreativeTabs.TOOLS);
		pigSkin = new Item().setUnlocalizedName("pigSkin").setRegistryName("pigSkin").setCreativeTab(CreativeTabs.MATERIALS);
		polarBearHide = new Item().setUnlocalizedName("polarBearHide").setRegistryName("polarBearHide").setCreativeTab(CreativeTabs.MATERIALS);
		
		pigHelmet = new ItemPigArmor(EntityEquipmentSlot.HEAD).setUnlocalizedName("pigHelmet").setRegistryName("pigHelmet").setCreativeTab(CreativeTabs.COMBAT);
		pigChest = new ItemPigArmor(EntityEquipmentSlot.CHEST).setUnlocalizedName("pigChest").setRegistryName("pigChest").setCreativeTab(CreativeTabs.COMBAT);
		pigLegs = new ItemPigArmor(EntityEquipmentSlot.LEGS).setUnlocalizedName("pigLegs").setRegistryName("pigLegs").setCreativeTab(CreativeTabs.COMBAT);
		pigBoots = new ItemPigArmor(EntityEquipmentSlot.FEET).setUnlocalizedName("pigBoots").setRegistryName("pigBoots").setCreativeTab(CreativeTabs.COMBAT);
		
		polarBearHelmet = new ItemPolarBearArmor(EntityEquipmentSlot.HEAD).setUnlocalizedName("polarBearHelmet").setRegistryName("polarBearHelmet").setCreativeTab(CreativeTabs.COMBAT);
		polarBearChest = new ItemPolarBearArmor(EntityEquipmentSlot.CHEST).setUnlocalizedName("polarBearChest").setRegistryName("polarBearChest").setCreativeTab(CreativeTabs.COMBAT);
		polarBearLegs = new ItemPolarBearArmor(EntityEquipmentSlot.LEGS).setUnlocalizedName("polarBearLegs").setRegistryName("polarBearLegs").setCreativeTab(CreativeTabs.COMBAT);
		polarBearBoots = new ItemPolarBearArmor(EntityEquipmentSlot.FEET).setUnlocalizedName("polarBearBoots").setRegistryName("polarBearBoots").setCreativeTab(CreativeTabs.COMBAT);
	}
	
	public static void renderInit() {
		
		render(clipper);
		render(pigSkin);
		render(pigHelmet);
		render(pigChest);
		render(pigLegs);
		render(pigBoots);
		render(polarBearHide);
		render(polarBearHelmet);
		render(polarBearChest);
		render(polarBearLegs);
		render(polarBearBoots);
	}
	
	private static void render(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ShearableMobs.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

}
