package net.e1.jm.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.Entity;

import net.e1.jm.entity.TwEntity;
import net.e1.jm.JmModElements;

@JmModElements.ModElement.Tag
public class TwspwnProcedure extends JmModElements.ModElement {
	public TwspwnProcedure(JmModElements instance) {
		super(instance, 33);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Twspwn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putString("jmstandMaster", "null");
		entity.setCustomName(new StringTextComponent((("" + (Math.random())).replace(".", ""))));
		if ((entity instanceof TwEntity.CustomEntity)) {
			entity.getPersistentData().putDouble("jm_standNum", 1);
		}
	}
}
