package net.schoolmod.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemLanguageTextbook extends Item {

	public ItemLanguageTextbook(Properties properties) {
		super(properties);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("Get gifts from nearby villagers").applyTextStyle(TextFormatting.AQUA));
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
			player.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 6000, 0));	
		}
		return new ActionResult<>(ActionResultType.SUCCESS, is);
	}
}
