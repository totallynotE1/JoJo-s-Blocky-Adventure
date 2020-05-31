
package net.e1.jm.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effect;

import net.e1.jm.JmModElements;

@JmModElements.ModElement.Tag
public class Jmcooldown1Potion extends JmModElements.ModElement {
	@ObjectHolder("jm:jmcooldown_1")
	public static final Effect potion = null;
	public Jmcooldown1Potion(JmModElements instance) {
		super(instance, 38);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}
	public static class EffectCustom extends Effect {
		private final ResourceLocation potionIcon;
		public EffectCustom() {
			super(EffectType.NEUTRAL, -13421569);
			setRegistryName("jmcooldown_1");
			potionIcon = new ResourceLocation("jm:textures/activatedmask_texture.png");
		}

		@Override
		public String getName() {
			return "effect.jmcooldown_1";
		}

		@Override
		public boolean isBeneficial() {
			return false;
		}

		@Override
		public boolean isInstant() {
			return false;
		}

		@Override
		public boolean shouldRenderInvText(EffectInstance effect) {
			return false;
		}

		@Override
		public boolean shouldRenderHUD(EffectInstance effect) {
			return false;
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
