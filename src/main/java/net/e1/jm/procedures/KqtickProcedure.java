package net.e1.jm.procedures;

import net.minecraft.entity.Entity;

import net.e1.jm.JmModElements;

@JmModElements.ModElement.Tag
public class KqtickProcedure extends JmModElements.ModElement {
	public KqtickProcedure(JmModElements instance) {
		super(instance, 27);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Kqtick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						(("execute as ") + "" + ((entity.getPersistentData().getString("standMaster"))) + ""
								+ (" at @s run tp @e[type=jm:kq,limit=1,distance=1.5..,sort=nearest] ^-1.1 ^ ^-0.25 facing ^ ^ ^.65")));
			}
		}
	}
}
