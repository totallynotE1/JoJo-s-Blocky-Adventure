
package net.e1.jm.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.block.BlockState;

import net.e1.jm.procedures.TwtickProcedure;
import net.e1.jm.procedures.TwspwnProcedure;
import net.e1.jm.procedures.TwcolldProcedure;
import net.e1.jm.procedures.TwclckProcedure;
import net.e1.jm.JmModElements;

import com.mojang.blaze3d.platform.GlStateManager;

@JmModElements.ModElement.Tag
public class TwEntity extends JmModElements.ModElement {
	public static EntityType entity = null;
	public TwEntity(JmModElements instance) {
		super(instance, 31);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(0.6f, 1.8f)).build("tw")
						.setRegistryName("tw");
		elements.entities.add(() -> entity);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new ModelKillerQueen(), 0.5f) {
				{
					this.addLayer(new GlowingLayer<>(this));
				}
				@Override
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("jm:textures/kq.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(true);
			enablePersistence();
			this.moveController = new FlyingMovementController(this);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void fall(float l, float d) {
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof ArrowEntity)
				return false;
			if (source.getImmediateSource() instanceof PlayerEntity)
				return false;
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata,
				CompoundNBT tag) {
			ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				TwspwnProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		public boolean processInteract(PlayerEntity sourceentity, Hand hand) {
			super.processInteract(sourceentity, hand);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("sourceentity", sourceentity);
				$_dependencies.put("world", world);
				TwclckProcedure.executeProcedure($_dependencies);
			}
			return true;
		}

		@Override
		public void baseTick() {
			super.baseTick();
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				TwtickProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public void onCollideWithPlayer(PlayerEntity sourceentity) {
			super.onCollideWithPlayer(sourceentity);
			Entity entity = this;
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("sourceentity", sourceentity);
				$_dependencies.put("world", world);
				TwcolldProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.8);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10000);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
			if (this.getAttribute(SharedMonsterAttributes.FLYING_SPEED) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.8);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		private static final ResourceLocation GLOW_TEXTURE = new ResourceLocation("jm:textures/kq.png");
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(T entityIn, float l1, float l2, float l3, float l4, float l5, float l6, float l7) {
			this.bindTexture(GLOW_TEXTURE);
			GlStateManager.enableBlend();
			GlStateManager.disableAlphaTest();
			GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
			if (entityIn.isInvisible())
				GlStateManager.depthMask(false);
			else
				GlStateManager.depthMask(true);
			int i = 61680;
			int j = i % 65536;
			int k = i / 65536;
			com.mojang.blaze3d.platform.GLX.glMultiTexCoord2f(com.mojang.blaze3d.platform.GLX.GL_TEXTURE1, (float) j, (float) k);
			GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			GameRenderer gamerenderer = Minecraft.getInstance().gameRenderer;
			gamerenderer.setupFogColor(true);
			((EntityModel<T>) this.getEntityModel()).render(entityIn, l1, l2, l4, l5, l6, l7);
			gamerenderer.setupFogColor(false);
			i = entityIn.getBrightnessForRender();
			j = i % 65536;
			k = i / 65536;
			com.mojang.blaze3d.platform.GLX.glMultiTexCoord2f(com.mojang.blaze3d.platform.GLX.GL_TEXTURE1, (float) j, (float) k);
			this.func_215334_a(entityIn);
			GlStateManager.depthMask(true);
			GlStateManager.disableBlend();
			GlStateManager.enableAlphaTest();
		}

		public boolean shouldCombineTextures() {
			return false;
		}
	}

	// Made with Blockbench 3.5.2
	// Exported for Minecraft version 1.14
	// Paste this class into your mod and generate all required imports
	public static class ModelKillerQueen extends EntityModel {
		private final RendererModel HEAD;
		private final RendererModel Shape7;
		private final RendererModel Shape5;
		private final RendererModel Shape6;
		private final RendererModel Bodybase;
		private final RendererModel Shape10;
		private final RendererModel Shape3;
		private final RendererModel leftleg;
		private final RendererModel rightleg;
		private final RendererModel leftarm;
		private final RendererModel rightarm;
		private final RendererModel body;
		private final RendererModel Shape4;
		private final RendererModel Shape2;
		private final RendererModel Shape1;
		private final RendererModel Shape8;
		public ModelKillerQueen() {
			textureWidth = 128;
			textureHeight = 128;
			HEAD = new RendererModel(this);
			HEAD.setRotationPoint(0.0F, 1.0F, 0.0F);
			Shape7 = new RendererModel(this);
			Shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
			HEAD.addChild(Shape7);
			Shape7.cubeList.add(new ModelBox(Shape7, 32, 0, -4.0F, -14.0F, -2.0F, 1, 3, 5, 0.0F, false));
			Shape5 = new RendererModel(this);
			Shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
			HEAD.addChild(Shape5);
			Shape5.cubeList.add(new ModelBox(Shape5, 0, 0, -4.0F, -11.0F, -4.0F, 8, 8, 8, 0.0F, false));
			Shape6 = new RendererModel(this);
			Shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
			HEAD.addChild(Shape6);
			Shape6.cubeList.add(new ModelBox(Shape6, 32, 0, 3.0F, -14.0F, -2.0F, 1, 3, 5, 0.0F, false));
			Bodybase = new RendererModel(this);
			Bodybase.setRotationPoint(0.0F, 0.0F, 0.0F);
			Shape10 = new RendererModel(this);
			Shape10.setRotationPoint(3.0F, 18.0F, -5.0F);
			Bodybase.addChild(Shape10);
			setRotationAngle(Shape10, 0.0F, -0.1745F, 0.0F);
			Shape10.cubeList.add(new ModelBox(Shape10, 36, 103, -2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F, false));
			Shape3 = new RendererModel(this);
			Shape3.setRotationPoint(-3.0F, 18.0F, -2.0F);
			Bodybase.addChild(Shape3);
			Shape3.cubeList.add(new ModelBox(Shape3, 36, 103, -2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F, false));
			leftleg = new RendererModel(this);
			leftleg.setRotationPoint(2.0F, 10.0F, -3.0F);
			Bodybase.addChild(leftleg);
			setRotationAngle(leftleg, -0.2618F, -0.1745F, 0.0F);
			leftleg.cubeList.add(new ModelBox(leftleg, 53, 103, -1.5F, 0.0F, -2.0F, 4, 9, 4, 0.0F, false));
			rightleg = new RendererModel(this);
			rightleg.setRotationPoint(-2.0F, 10.0F, -3.0F);
			Bodybase.addChild(rightleg);
			setRotationAngle(rightleg, 0.0873F, 0.0F, 0.0F);
			rightleg.cubeList.add(new ModelBox(rightleg, 53, 103, -2.5F, 0.0F, -2.0F, 4, 9, 4, 0.0F, false));
			leftarm = new RendererModel(this);
			leftarm.setRotationPoint(5.0F, 0.0F, 0.0F);
			Bodybase.addChild(leftarm);
			setRotationAngle(leftarm, 0.0F, 0.0F, -0.2618F);
			leftarm.cubeList.add(new ModelBox(leftarm, 67, 73, 0.0F, 1.0F, -3.0F, 4, 12, 4, 0.0F, true));
			rightarm = new RendererModel(this);
			rightarm.setRotationPoint(-6.0F, 0.0F, 0.0F);
			Bodybase.addChild(rightarm);
			setRotationAngle(rightarm, 0.0F, 0.0F, 0.2618F);
			rightarm.cubeList.add(new ModelBox(rightarm, 67, 73, -3.0F, 1.0F, -2.0F, 4, 12, 4, 0.0F, false));
			body = new RendererModel(this);
			body.setRotationPoint(0.0F, -0.5F, -1.0F);
			Bodybase.addChild(body);
			setRotationAngle(body, -0.5236F, 0.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 16, 16, -5.5F, 0.0F, -3.0F, 11, 6, 5, 0.0F, false));
			Shape4 = new RendererModel(this);
			Shape4.setRotationPoint(0.0F, -2.0F, -4.0F);
			Bodybase.addChild(Shape4);
			Shape4.cubeList.add(new ModelBox(Shape4, 36, 91, -10.0F, 0.0F, 0.0F, 20, 5, 6, 0.0F, false));
			Shape2 = new RendererModel(this);
			Shape2.setRotationPoint(0.0F, 9.0F, -4.0F);
			Bodybase.addChild(Shape2);
			Shape2.cubeList.add(new ModelBox(Shape2, 36, 79, -4.5F, -1.0F, -3.0F, 9, 4, 6, 0.0F, false));
			Shape1 = new RendererModel(this);
			Shape1.setRotationPoint(0.0F, 6.0F, -5.0F);
			Bodybase.addChild(Shape1);
			Shape1.cubeList.add(new ModelBox(Shape1, 18, 28, -3.5F, -3.4667F, -1.0F, 7, 7, 4, 0.0F, false));
			Shape8 = new RendererModel(this);
			Shape8.setRotationPoint(0.0F, 10.0F, -7.0F);
			Bodybase.addChild(Shape8);
			Shape8.cubeList.add(new ModelBox(Shape8, 46, 74, -2.0F, 1.0F, 0.0F, 4, 4, 1, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			HEAD.render(f5);
			Bodybase.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
			super.setRotationAngles(e, f, f1, f2, f3, f4, f5);
			this.HEAD.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.HEAD.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
