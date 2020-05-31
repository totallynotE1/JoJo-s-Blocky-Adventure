
package net.e1.jm.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.RestrictSunGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.FollowMobGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.e1.jm.itemgroup.JmbacreativetabItemGroup;
import net.e1.jm.item.VampirebloodItem;
import net.e1.jm.JmModElements;

import java.util.Random;

@JmModElements.ModElement.Tag
public class VampireEntity extends JmModElements.ModElement {
	public static EntityType entity = null;
	public VampireEntity(JmModElements instance) {
		super(instance, 7);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("vampire")
						.setRegistryName("vampire");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -14803426, -10747877, new Item.Properties().group(JmbacreativetabItemGroup.tab))
				.setRegistryName("vampire"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 20, 3, 30));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::func_223315_a);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new Modelnew_vampire(), 0.5f) {
				@Override
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("jm:textures/vampir_texture_new.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new FollowMobGoal(this, (float) 1, 10, 5));
			this.goalSelector.addGoal(2, new RestrictSunGoal(this));
			this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new LeapAtTargetGoal(this, (float) 0.8));
			this.targetSelector.addGoal(6, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(7, new MeleeAttackGoal(this, 1.2, false));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEAD;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(VampirebloodItem.block, (int) (1)));
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jm:vampire_wry"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.evoker.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.evoker.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.9);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);
		}

		public void livingTick() {
			super.livingTick();
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			Random random = this.rand;
			if (true)
				for (int l = 0; l < 5; ++l) {
					double d0 = (i + 0.5) + (random.nextFloat() - 0.5) * 1D;
					double d1 = ((j + 0.7) + (random.nextFloat() - 0.5) * 1D * 100) + 0.5;
					double d2 = (k + 0.5) + (random.nextFloat() - 0.5) * 1D;
					world.addParticle(ParticleTypes.WITCH, d0, d1, d2, 0, 0, 0);
				}
		}
	}

	// Made with Blockbench 3.5.2
	// Exported for Minecraft version 1.14
	// Paste this class into your mod and generate all required imports
	public static class Modelnew_vampire extends EntityModel {
		private final RendererModel head;
		private final RendererModel nose;
		private final RendererModel body;
		private final RendererModel arms;
		private final RendererModel leg0;
		private final RendererModel leg1;
		private final RendererModel rightarm;
		private final RendererModel leftarm;
		public Modelnew_vampire() {
			textureWidth = 64;
			textureHeight = 64;
			head = new RendererModel(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F, true));
			nose = new RendererModel(this);
			nose.setRotationPoint(0.0F, -2.0F, 0.0F);
			nose.cubeList.add(new ModelBox(nose, 24, 0, -1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F, true));
			body = new RendererModel(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 16, 20, -4.0F, 0.0F, -3.0F, 8, 9, 6, 0.0F, true));
			body.cubeList.add(new ModelBox(body, 0, 50, -4.0F, 9.0F, -3.0F, 8, 3, 6, 0.0F, true));
			body.cubeList.add(new ModelBox(body, 0, 38, -4.0F, 0.0F, -3.0F, 8, 18, 6, 0.5F, true));
			arms = new RendererModel(this);
			arms.setRotationPoint(0.0F, 2.0F, 0.0F);
			arms.cubeList.add(new ModelBox(arms, 40, 38, -4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F, true));
			arms.cubeList.add(new ModelBox(arms, 44, 22, 4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, true));
			arms.cubeList.add(new ModelBox(arms, 44, 22, -8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, true));
			leg0 = new RendererModel(this);
			leg0.setRotationPoint(2.0F, 12.0F, 0.0F);
			leg0.cubeList.add(new ModelBox(leg0, 0, 22, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));
			leg1 = new RendererModel(this);
			leg1.setRotationPoint(-2.0F, 12.0F, 0.0F);
			leg1.cubeList.add(new ModelBox(leg1, 0, 22, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
			rightarm = new RendererModel(this);
			rightarm.setRotationPoint(5.0F, 2.0F, 0.0F);
			rightarm.cubeList.add(new ModelBox(rightarm, 40, 46, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, true));
			leftarm = new RendererModel(this);
			leftarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			leftarm.cubeList.add(new ModelBox(leftarm, 40, 46, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			head.render(f5);
			nose.render(f5);
			body.render(f5);
			arms.render(f5);
			leg0.render(f5);
			leg1.render(f5);
			rightarm.render(f5);
			leftarm.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
			super.setRotationAngles(e, f, f1, f2, f3, f4, f5);
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.nose.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.nose.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leg0.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
