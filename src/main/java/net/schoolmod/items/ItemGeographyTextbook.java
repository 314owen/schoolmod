package net.schoolmod.items;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemGeographyTextbook extends Item {

	public ItemGeographyTextbook(Properties properties) {
		super(properties);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("Teleports you to a new place").applyTextStyle(TextFormatting.AQUA));
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (stack.getDamage() > 0) {
			stack.setDamage(stack.getDamage() - 1);
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		ItemStack is = player.getHeldItem(hand);
		if (!world.isRemote && is.getMaxDamage() - is.getDamage() == is.getMaxDamage()) {
			is.setDamage(is.getMaxDamage() - 1);
			int x = player.getPosition().getX() + new Random().nextInt(500);
			int z = player.getPosition().getZ() + new Random().nextInt(500);
			int y = 0;
			for (int i = 255; i > 0; i++) {
				if (world.getBlockState(new BlockPos(x, i, z)).getBlock() != Blocks.AIR) {
					y = i;
					break;
				}
			}
			
			player.setPositionAndUpdate(x, y, z);
		}
		return new ActionResult<>(ActionResultType.SUCCESS, is);
	}
}
