
package net.e1.jm.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.e1.jm.itemgroup.JmbacreativetabItemGroup;
import net.e1.jm.JmModElements;

@JmModElements.ModElement.Tag
public class StonemaskItem extends JmModElements.ModElement {
	@ObjectHolder("jm:stonemaskhelmet")
	public static final Item helmet = null;
	@ObjectHolder("jm:stonemaskbody")
	public static final Item body = null;
	@ObjectHolder("jm:stonemasklegs")
	public static final Item legs = null;
	@ObjectHolder("jm:stonemaskboots")
	public static final Item boots = null;
	public StonemaskItem(JmModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 1024;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 1024}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 0;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "stonemask";
			}

			public float getToughness() {
				return 5f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(JmbacreativetabItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel();
				armorModel.bipedHead = new ModelStoneMask().head;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "jm:textures/stonemask.png";
			}
		}.setRegistryName("stonemaskhelmet"));
	}
	// Made with Blockbench 3.5.2
	// Exported for Minecraft version 1.14
	// Paste this class into your mod and generate all required imports
	public static class ModelStoneMask extends EntityModel {
		private final RendererModel head;
		private final RendererModel RightEye2;
		private final RendererModel Mask;
		private final RendererModel RightEye;
		public ModelStoneMask() {
			textureWidth = 32;
			textureHeight = 32;
			head = new RendererModel(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			RightEye2 = new RendererModel(this);
			RightEye2.setRotationPoint(-5.05F, -4.25F, -3.5F);
			head.addChild(RightEye2);
			setRotationAngle(RightEye2, 0.0F, 0.0F, 1.7453F);
			RightEye2.cubeList.add(new ModelBox(RightEye2, 7, 0, -1.0961F, -4.2566F, -0.5F, 1, 3, 1, 0.0F, true));
			Mask = new RendererModel(this);
			Mask.setRotationPoint(-2.5F, 48.5F, 4.5F);
			head.addChild(Mask);
			Mask.cubeList.add(new ModelBox(Mask, 0, 6, -0.5F, -49.5F, -8.5F, 6, 1, 1, 0.0F, false));
			Mask.cubeList.add(new ModelBox(Mask, 0, 0, -1.5F, -51.5F, -8.5F, 8, 2, 1, 0.0F, false));
			Mask.cubeList.add(new ModelBox(Mask, 1, 0, -0.5F, -55.5F, -8.5F, 7, 3, 1, 0.0F, false));
			Mask.cubeList.add(new ModelBox(Mask, 13, 13, 1.5F, -52.5F, -8.5F, 2, 1, 1, 0.0F, false));
			Mask.cubeList.add(new ModelBox(Mask, 8, 10, 1.5F, -51.5F, -8.75F, 2, 1, 1, 0.0F, false));
			Mask.cubeList.add(new ModelBox(Mask, 0, 8, 1.5F, -57.5F, -8.7F, 2, 5, 2, 0.0F, false));
			Mask.cubeList.add(new ModelBox(Mask, 11, 15, -1.5F, -53.5F, -8.5F, 1, 2, 1, 0.0F, false));
			Mask.cubeList.add(new ModelBox(Mask, 8, 12, 3.5F, -56.5F, -8.5F, 2, 1, 1, 0.0F, false));
			Mask.cubeList.add(new ModelBox(Mask, 14, 9, -1.5F, -55.5F, -8.75F, 1, 2, 1, 0.0F, false));
			Mask.cubeList.add(new ModelBox(Mask, 15, 15, -0.5F, -54.5F, -8.75F, 1, 1, 1, 0.0F, false));
			Mask.cubeList.add(new ModelBox(Mask, 6, 8, -1.5F, -56.5F, -8.75F, 3, 1, 1, 0.0F, false));
			Mask.cubeList.add(new ModelBox(Mask, 0, 15, 5.5F, -53.5F, -8.5F, 1, 2, 1, 0.0F, false));
			RightEye = new RendererModel(this);
			RightEye.setRotationPoint(5.05F, -4.25F, -3.5F);
			head.addChild(RightEye);
			setRotationAngle(RightEye, 0.0F, 0.0F, -1.7453F);
			RightEye.cubeList.add(new ModelBox(RightEye, 5, 0, 0.0961F, -4.2566F, -0.5F, 1, 3, 1, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			head.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
			super.setRotationAngles(e, f, f1, f2, f3, f4, f5);
		}
	}
}
