package net.e1.jm.procedures;

import net.minecraft.entity.Entity;

import net.e1.jm.JmModElements;

@JmModElements.ModElement.Tag
public class KqcollideProcedure extends JmModElements.ModElement {
	public KqcollideProcedure(JmModElements instance) {
		super(instance, 29);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Kqcollide!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			System.err.println("Failed to load dependency sourceentity for procedure Kqcollide!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((((entity.getPersistentData().getString("standMaster"))).equals("null"))) {
			entity.getPersistentData().putString("standMaster", (sourceentity.getDisplayName().getFormattedText()));
		}
		if ((((sourceentity.getDisplayName().getFormattedText())).equals((entity.getPersistentData().getString("standMaster"))))) {
			entity.rotationYaw = (float) ((sourceentity.rotationYaw));
			entity.rotationPitch = (float) ((sourceentity.rotationPitch));
		}
	}
}
