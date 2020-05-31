package net.e1.jm.procedures;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.e1.jm.item.MysteriousswordItem;
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
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Twcolld!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		World world = (World) dependencies.get("world");
		if ((((entity.getPersistentData().getString("jm_standMaster"))).equals("null"))) {
			if (((sourceentity.getPersistentData().getDouble("jm_stand")) == 0)) {
				if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(MysteriousswordItem.block, (int) (1)).getItem())) {
					entity.getPersistentData().putString("jm_standMaster", (sourceentity.getDisplayName().getFormattedText()));
					sourceentity.getPersistentData().putString("jm_standID", (entity.getDisplayName().getFormattedText()));
					sourceentity.getPersistentData().putDouble("jm_stand", (entity.getPersistentData().getDouble("jm_standNum")));
				} else if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(MysteriousswordItem.block, (int) (1)).getItem())) {
					entity.getPersistentData().putString("jm_standMaster", (sourceentity.getDisplayName().getFormattedText()));
					sourceentity.getPersistentData().putString("jm_standID", (entity.getDisplayName().getFormattedText()));
					sourceentity.getPersistentData().putDouble("jm_stand", (entity.getPersistentData().getDouble("jm_standNum")));
				} else {
					if (sourceentity instanceof PlayerEntity && !world.isRemote) {
						((PlayerEntity) sourceentity).sendStatusMessage(
								new StringTextComponent("an error occured because you tried to summon a stand that you do not own!"), (false));
					}
					entity.remove();
				}
			} else {
				if (sourceentity instanceof PlayerEntity && !world.isRemote) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("You Already Have A Stand"), (false));
				}
				entity.remove();
			}
		}
		if ((((sourceentity.getDisplayName().getFormattedText())).equals((entity.getPersistentData().getString("jm_standMaster"))))) {
			if ((((entity.getDisplayName().getFormattedText())).equals((sourceentity.getPersistentData().getString("jm_standID"))))) {
				if (((sourceentity.getPersistentData().getDouble("jm_stand")) == (entity.getPersistentData().getDouble("jm_standNum")))) {
					entity.rotationYaw = (float) (Math.round((sourceentity.rotationYaw)));
					entity.rotationPitch = (float) (Math.round((sourceentity.rotationPitch)));
				}
			}
		}
	}
}
