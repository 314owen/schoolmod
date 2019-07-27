package net.schoolmod;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.items.IItemHandler;
import net.schoolmod.init.ItemInit;

public class DeskRecipeManager {

	public static ArrayList<Item> textbook = new ArrayList<Item>(Arrays.asList(ItemInit.textbook, ItemInit.textbook, ItemInit.textbook, ItemInit.textbook, ItemInit.science_textbook, ItemInit.math_textbook, ItemInit.math_textbook, ItemInit.math_textbook, ItemInit.math_textbook, ItemInit.math_textbook, ItemInit.math_textbook, ItemInit.science_textbook,  ItemInit.science_textbook,  ItemInit.science_textbook,  ItemInit.science_textbook,  ItemInit.science_textbook, ItemInit.english_textbook, ItemInit.english_textbook, ItemInit.history_textbook, ItemInit.history_textbook, ItemInit.textbook, ItemInit.textbook, ItemInit.textbook, ItemInit.textbook, ItemInit.textbook));
	
	public static ArrayList<Item> itemOne = new ArrayList<Item>(Arrays.asList(Items.REDSTONE, Items.FEATHER, Items.BONE, Items.GLASS_BOTTLE, Items.GLASS, Items.REDSTONE_TORCH, Items.STONE, Items.EMERALD, Items.DIAMOND, Items.REDSTONE, Items.DAYLIGHT_DETECTOR, Items.ROTTEN_FLESH, Items.GOLD_NUGGET, Items.APPLE, Items.DIAMOND, Items.DAYLIGHT_DETECTOR, Items.ENCHANTING_TABLE, Items.PAPER, Items.COMPASS, Items.BRICK, Items.ENDER_EYE, Items.CAKE, Items.IRON_INGOT, Items.NOTE_BLOCK, Items.MINECART));
	public static ArrayList<Item> itemTwo = new ArrayList<Item>(Arrays.asList(Items.ENDER_PEARL, Items.INK_SAC, Items.EMERALD, Items.SPIDER_EYE, Items.GLASS, ItemInit.basic_calculator, ItemInit.basic_calculator, ItemInit.basic_calculator, ItemInit.graphing_calculator, Items.STONE_BUTTON, Items.COMPARATOR, Items.POPPY, ItemInit.graduated_cylinder, Items.SAND, Items.LAPIS_LAZULI, Items.CLOCK, Items.INK_SAC, Items.GHAST_TEAR, Items.MAP, Items.BREAD, Items.SUGAR, Items.BUCKET, Items.GLOWSTONE, Items.BLAZE_ROD, Items.OAK_BOAT));

	public static ArrayList<Item> productList = new ArrayList<Item>(Arrays.asList(ItemInit.math_textbook, ItemInit.english_textbook, ItemInit.history_textbook, ItemInit.science_textbook, ItemInit.graduated_cylinder, ItemInit.algebra_textbook, ItemInit.geometry_textbook, ItemInit.statistics_textbook, ItemInit.calculus_textbook, ItemInit.basic_calculator, ItemInit.graphing_calculator, ItemInit.biology_textbook, ItemInit.chemistry_textbook, ItemInit.physics_textbook, ItemInit.geology_textbook, ItemInit.astronomy_textbook, ItemInit.literature_textbook, ItemInit.composition_textbook, ItemInit.geography_textbook, ItemInit.culture_textbook, ItemInit.psychology_textbook, ItemInit.philosophy_textbook, ItemInit.business_textbook, ItemInit.music_textbook, ItemInit.language_textbook));
	
	public static Item testRecipe(IItemHandler i) {
		for (int x = 0; x < productList.size(); x++) {
			if (i.getStackInSlot(0).getItem() == textbook.get(x) && (i.getStackInSlot(1).getItem() == itemOne.get(x) && i.getStackInSlot(2).getItem() == itemTwo.get(x) || 
					(i.getStackInSlot(2).getItem() == itemOne.get(x) && i.getStackInSlot(1).getItem() == itemTwo.get(x)))) {
				return productList.get(x);
			}
		}
		
		
		return Items.AIR;
	}
}
