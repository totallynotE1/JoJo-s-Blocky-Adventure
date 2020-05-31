
package net.e1.jm.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.e1.jm.itemgroup.JmbacreativetabItemGroup;
import net.e1.jm.JmModElements;

@JmModElements.ModElement.Tag
public class PluckswordItem extends JmModElements.ModElement {
	@ObjectHolder("jm:plucksword")
	public static final Item block = null;
	public PluckswordItem(JmModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 200;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 4;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(MysteriousshardItem.block, (int) (1)));
			}
		}, 3, 0f, new Item.Properties().group(JmbacreativetabItemGroup.tab)) {
		}.setRegistryName("plucksword"));
	}
}
