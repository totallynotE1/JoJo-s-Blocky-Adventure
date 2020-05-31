package net.e1.jm.procedures;

import net.minecraft.entity.Entity;

import net.e1.jm.JmModElements;

@JmModElements.ModElement.Tag
public class TwtickProcedure extends JmModElements.ModElement {
	public TwtickProcedure(JmModElements instance) {
		super(instance, 32);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Twtick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getPersistentData().getBoolean("jm_standAttack")) == (false))
				|| (((entity.getPersistentData().getBoolean("jm_standAttack2")) == (false))
						|| ((entity.getPersistentData().getBoolean("jm_standAttack3")) == (false))))) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							(("execute as ") + "" + ((entity.getPersistentData().getString("jm_standMaster"))) + "" + (" at @s run tp @e[name=") + ""
									+ ((entity.getDisplayName().getFormattedText())) + "" + ("] ^-1.1 ^ ^-0.25")));
				}
			}
		} else if (((entity.getPersistentData().getBoolean("jm_standAttack")) == (true))) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							(("execute as ") + "" + ((entity.getPersistentData().getString("jm_standMaster"))) + "" + (" at @s run tp @e[name=") + ""
									+ ((entity.getDisplayName().getFormattedText())) + "" + ("] ^ ^ ^1.25")));
				}
			}
		}
	}
}
