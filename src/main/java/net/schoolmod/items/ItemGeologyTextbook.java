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

public class ItemGeologyTextbook extends Item {

	public ItemGeologyTextbook(Properties properties) {
		super(properties);
		
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("Rains gemstones").applyTextStyle(TextFormatting.AQUA));
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
			for (int i = 0; i < 10; i++) {
				double x = Math.random();
				if (x < 0.2) {
					world.addEntity(new ItemEntity(world, player.getPosition().getX(), player.getPosition().getY() + 5,
							player.getPosition().getZ(), new ItemStack(Items.DIAMOND)));
				} else if (x < 0.4) {
					world.addEntity(new ItemEntity(world, player.getPosition().getX(), player.getPosition().getY() + 5,
							player.getPosition().getZ(), new ItemStack(Items.IRON_INGOT)));
				} else if (x < 0.6) {
					world.addEntity(new ItemEntity(world, player.getPosition().getX(), player.getPosition().getY() + 5,
							player.getPosition().getZ(), new ItemStack(Items.EMERALD)));
				} else if (x < 0.8) {
					world.addEntity(new ItemEntity(world, player.getPosition().getX(), player.getPosition().getY() + 5,
							player.getPosition().getZ(), new ItemStack(Items.GOLD_INGOT)));
				} else {
					world.addEntity(new ItemEntity(world, player.getPosition().getX(), player.getPosition().getY() + 5,
							player.getPosition().getZ(), new ItemStack(Items.LAPIS_LAZULI)));
				}
			}
		}
		//player.getCooldownTracker().setCooldown(this, 12000);
		return new ActionResult<>(ActionResultType.SUCCESS, is);
	}
}
