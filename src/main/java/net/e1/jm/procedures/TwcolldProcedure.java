package net.e1.jm.procedures;

import net.minecraft.entity.Entity;

import net.e1.jm.JmModElements;

@JmModElements.ModElement.Tag
public class TwcolldProcedure extends JmModElements.ModElement {
	public TwcolldProcedure(JmModElements instance) {
		super(instance, 34);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Twcolld!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			System.err.println("Failed to load dependency sourceentity for procedure Twcolld!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (((sourceentity.getPersistentData().getDouble("jmstand")) == 0)) {
			if ((((entity.getPersistentData().getString("jmstandMaster"))).equals("null"))) {
				entity.getPersistentData().putString("jmstandMaster", (sourceentity.getDisplayName().getFormattedText()));
				sourceentity.getPersistentData().putString("jmstandID", (entity.getDisplayName().getFormattedText()));
				sourceentity.getPersistentData().putDouble("jmstand", (entity.getPersistentData().getDouble("jmstandNum")));
			}
		}
		if ((((sourceentity.getDisplayName().getFormattedText())).equals((entity.getPersistentData().getString("jmstandMaster"))))) {
			if ((((entity.getDisplayName().getFormattedText())).equals((sourceentity.getPersistentData().getString("jmstandID"))))) {
				if (((sourceentity.getPersistentData().getDouble("jmstand")) == (entity.getPersistentData().getDouble("jmstandNum")))) {
					entity.rotationYaw = (float) (Math.round((sourceentity.rotationYaw)));
					entity.rotationPitch = (float) (Math.round((sourceentity.rotationPitch)));
				}
			}
		}
	}
}
