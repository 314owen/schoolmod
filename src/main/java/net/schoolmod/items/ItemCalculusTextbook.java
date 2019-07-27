package net.schoolmod.items;

import java.util.List;

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

public class ItemCalculusTextbook extends Item {

	public ItemCalculusTextbook(Properties properties) {
		super(properties);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("Clears out a 25x25x25 area around you").applyTextStyle(TextFormatting.AQUA));
		tooltip.add(new StringTextComponent("WARNING: Will cause lag").applyTextStyle(TextFormatting.RED));
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
			for (int x = -12; x <= 12; x++) {
				for (int y = -12; y <= 12; y++) {
					for (int z = -12; z <= 12; z++) {
						world.destroyBlock(new BlockPos(player.getPosition().getX() + x, player.getPosition().getY() + y,
								player.getPosition().getZ() + z), true);
					}
				}
			}
		}
		return new ActionResult<>(ActionResultType.SUCCESS, is);
	}
}
