package net.schoolmod.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemPhysicsTextbook extends Item {

	public ItemPhysicsTextbook(Properties properties) {
		super(properties);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("Discover gravity").applyTextStyle(TextFormatting.AQUA));
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
			
			if (Math.random() < 0.1) {
				world.addEntity(new ItemEntity(world, player.getPosition().getX(), player.getPosition().getY() + 5, player.getPosition().getZ(), new ItemStack(Items.GOLDEN_APPLE)));
			} else {
				world.addEntity(new ItemEntity(world, player.getPosition().getX(), player.getPosition().getY() + 5, player.getPosition().getZ(), new ItemStack(Items.APPLE)));
			}
		}
		return new ActionResult<>(ActionResultType.SUCCESS, is);
	}
}
