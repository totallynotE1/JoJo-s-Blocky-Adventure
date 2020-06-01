package net.e1.jm.procedures;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.e1.jm.JmModElements;

@JmModElements.ModElement.Tag
public class TwclckProcedure extends JmModElements.ModElement {
	public TwclckProcedure(JmModElements instance) {
		super(instance, 35);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Twclck!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			System.err.println("Failed to load dependency sourceentity for procedure Twclck!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Twclck!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		World world = (World) dependencies.get("world");
		if (entity instanceof PlayerEntity && !world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(
					new StringTextComponent((("stand ID (Debug/Dev Use Only)= ") + "" + ((sourceentity.getDisplayName().getFormattedText())))),
					(false));
		}
		if (entity instanceof PlayerEntity && !world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(
					new StringTextComponent((("stand Master= ") + "" + ((sourceentity.getPersistentData().getString("jmstandMaster"))))), (false));
		}
	}
}
