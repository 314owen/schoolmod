package net.schoolmod.items;

import java.util.List;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.schoolmod.blocks.alphabet.BlockAlphabet;
import net.schoolmod.blocks.alphabet.WordFinder;

public class ItemCompositionTextbook extends Item {

	public ItemCompositionTextbook(Properties properties) {
		super(properties);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("Right click a word(max 5 letters)").applyTextStyle(TextFormatting.AQUA));
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext ic) {
		World world = ic.getWorld();
		BlockPos bp = ic.getPos();
		BlockState bs = world.getBlockState(bp);
		Class<?> c = bs.getBlock().getClass();
		if (c.getSuperclass() == BlockAlphabet.class) {
			System.out.println("This is the letter: " + ((BlockAlphabet) bs.getBlock()).getLetter());
			if (!world.isRemote) {

				if (world.getBlockState(new BlockPos(bp.getX() + 1, bp.getY(), bp.getZ())).getBlock().getClass()
						.getSuperclass() == BlockAlphabet.class) {
					String word = "" + ((BlockAlphabet) bs.getBlock()).getLetter();
					for (int x = 1; x < 5; x++) {
						if (world.getBlockState(new BlockPos(bp.getX() + x, bp.getY(), bp.getZ())).getBlock().getClass()
								.getSuperclass() == BlockAlphabet.class) {
							word = word + ((BlockAlphabet) world
									.getBlockState(new BlockPos(bp.getX() + x, bp.getY(), bp.getZ())).getBlock())
											.getLetter();
						} else {
							break;
						}
					}

					if (WordFinder.bigListOfWords.contains(word)) {
						for (int x = 0; x < word.length(); x++) {
							world.destroyBlock(new BlockPos(bp.getX() + x, bp.getY(), bp.getZ()), false);
						}
						WordFinder.whatToDo(word, world, ic.getPlayer(), bp);
					}

				} else if (world.getBlockState(new BlockPos(bp.getX() - 1, bp.getY(), bp.getZ())).getBlock().getClass()
						.getSuperclass() == BlockAlphabet.class) {
					String word = "" + ((BlockAlphabet) bs.getBlock()).getLetter();
					for (int x = 1; x < 5; x++) {
						if (world.getBlockState(new BlockPos(bp.getX() - x, bp.getY(), bp.getZ())).getBlock().getClass()
								.getSuperclass() == BlockAlphabet.class) {
							word = word + ((BlockAlphabet) world
									.getBlockState(new BlockPos(bp.getX() - x, bp.getY(), bp.getZ())).getBlock())
											.getLetter();
						} else {
							break;
						}
					}

					if (WordFinder.bigListOfWords.contains(word)) {
						for (int x = 0; x < word.length(); x++) {
							world.destroyBlock(new BlockPos(bp.getX() - x, bp.getY(), bp.getZ()), false);
						}
						WordFinder.whatToDo(word, world, ic.getPlayer(), bp);
					}

				} else if (world.getBlockState(new BlockPos(bp.getX(), bp.getY(), bp.getZ() + 1)).getBlock().getClass()
						.getSuperclass() == BlockAlphabet.class) {
					String word = "" + ((BlockAlphabet) bs.getBlock()).getLetter();
					for (int x = 1; x < 5; x++) {
						if (world.getBlockState(new BlockPos(bp.getX(), bp.getY(), bp.getZ() + x)).getBlock().getClass()
								.getSuperclass() == BlockAlphabet.class) {
							word = word + ((BlockAlphabet) world
									.getBlockState(new BlockPos(bp.getX(), bp.getY(), bp.getZ() + x)).getBlock())
											.getLetter();
						} else {
							break;
						}
					}
					if (WordFinder.bigListOfWords.contains(word)) {
						for (int x = 0; x < word.length(); x++) {
							world.destroyBlock(new BlockPos(bp.getX(), bp.getY(), bp.getZ() + x), false);
						}
						WordFinder.whatToDo(word, world, ic.getPlayer(), bp);
					}

				} else if (world.getBlockState(new BlockPos(bp.getX(), bp.getY(), bp.getZ() - 1)).getBlock().getClass()
						.getSuperclass() == BlockAlphabet.class) {
					String word = "" + ((BlockAlphabet) bs.getBlock()).getLetter();
					for (int x = 1; x < 5; x++) {
						if (world.getBlockState(new BlockPos(bp.getX(), bp.getY(), bp.getZ() - x)).getBlock().getClass()
								.getSuperclass() == BlockAlphabet.class) {
							word = word + ((BlockAlphabet) world
									.getBlockState(new BlockPos(bp.getX(), bp.getY(), bp.getZ() - x)).getBlock())
											.getLetter();
						} else {
							break;
						}
					}
					if (WordFinder.bigListOfWords.contains(word)) {
						for (int x = 0; x < word.length(); x++) {
							world.destroyBlock(new BlockPos(bp.getX(), bp.getY(), bp.getZ() - x), false);
						}
						WordFinder.whatToDo(word, world, ic.getPlayer(), bp);
					}
				}

			}
			return ActionResultType.SUCCESS;
		} else {
			return ActionResultType.FAIL;
		}
	}
}
