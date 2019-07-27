package net.schoolmod.items;

import java.util.List;
import java.util.Random;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
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
import net.schoolmod.init.BlockInit;

public class ItemLiteratureTextbook extends Item {
	
	public ItemLiteratureTextbook(Properties properties) {
		super(properties);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("Discover some letters").applyTextStyle(TextFormatting.AQUA));
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
		BlockPos pos = player.getPosition();
		if (!world.isRemote && is.getMaxDamage() - is.getDamage() == is.getMaxDamage()) {
			is.setDamage(is.getMaxDamage() - 1);
			for (int x = 0; x < 5; x++) {
				switch (new Random().nextInt(26)) {
				case 0:	
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_a)));
					break;
				case 1:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_b)));
					break;
				case 2:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_c)));
					break;
				case 3:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_d)));
					break;
				case 4:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_e)));
					break;
				case 5:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_f)));
					break;
				case 6:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_g)));
					break;
				case 7:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_h)));
					break;
				case 8:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_i)));
					break;
				case 9:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_j)));
					break;
				case 10:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_k)));
					break;
				case 11:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_l)));
					break;
				case 12:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_m)));
					break;
				case 13:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_n)));
					break;
				case 14:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_o)));
					break;
				case 15:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_p)));
					break;
				case 16:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_q)));
					break;
				case 17:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_r)));
					break;
				case 18:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_s)));
					break;
				case 19:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_t)));
					break;
				case 20:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_u)));
					break;
				case 21:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_v)));
					break;
				case 22:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_w)));
					break;
				case 23:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_x)));
					break;
				case 24:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_y)));
					break;
				case 25:
					world.addEntity(new ItemEntity(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(BlockInit.letter_z)));
					break;
				}
			}
		}
		return new ActionResult<>(ActionResultType.SUCCESS, is);

	}
}
