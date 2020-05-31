
package net.e1.jm.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.e1.jm.itemgroup.JmbacreativetabItemGroup;
import net.e1.jm.JmModElements;

import java.util.List;

@JmModElements.ModElement.Tag
public class MysteriousshardItem extends JmModElements.ModElement {
	@ObjectHolder("jm:mysteriousshard")
	public static final Item block = null;
	public MysteriousshardItem(JmModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(JmbacreativetabItemGroup.tab).maxStackSize(64));
			setRegistryName("mysteriousshard");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Mysterious Much?"));
		}
	}
}
