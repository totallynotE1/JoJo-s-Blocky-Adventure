
package net.e1.jm.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.e1.jm.itemgroup.JmbacreativetabItemGroup;
import net.e1.jm.JmModElements;

@JmModElements.ModElement.Tag
public class VampirefleshItem extends JmModElements.ModElement {
	@ObjectHolder("jm:vampireflesh")
	public static final Item block = null;
	public VampirefleshItem(JmModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(JmbacreativetabItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(2).saturation(0.1f).setAlwaysEdible().meat().build()));
			setRegistryName("vampireflesh");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 50;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
