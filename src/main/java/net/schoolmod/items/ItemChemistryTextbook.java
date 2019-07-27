package net.schoolmod.items;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemChemistryTextbook extends Item {

	public ItemChemistryTextbook(Properties properties) {
		super(properties);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("Transmute iron into gold").applyTextStyle(TextFormatting.AQUA));
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext ic) {
		World world = ic.getWorld();
		BlockPos bp = ic.getPos();
		BlockState bs = world.getBlockState(bp);
		if (bs.getBlock() == Blocks.IRON_BLOCK) {
			world.addParticle(ParticleTypes.LARGE_SMOKE, bp.getX() + 0.5, bp.getY() + 1, bp.getZ() + 0.5, 0.0D, 0.0D,
					0.0D);
			world.playSound(bp.getX(), bp.getY(), bp.getZ(), SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE,
					SoundCategory.BLOCKS, 0.2F + new Random().nextFloat() * 0.2F,
					0.9F + new Random().nextFloat() * 0.15F, false);

			if (!world.isRemote) {
				world.setBlockState(bp, Blocks.GOLD_BLOCK.getDefaultState());
			}
			return ActionResultType.SUCCESS;
		} else if (bs.getBlock() == Blocks.GOLD_BLOCK) {
			world.addParticle(ParticleTypes.LARGE_SMOKE, bp.getX() + 0.5, bp.getY() + 1, bp.getZ() + 0.5, 0.0D, 0.0D,
					0.0D);
			world.playSound(bp.getX(), bp.getY(), bp.getZ(), SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE,
					SoundCategory.BLOCKS, 0.2F + new Random().nextFloat() * 0.2F,
					0.9F + new Random().nextFloat() * 0.15F, false);

			if (!world.isRemote) {
				world.setBlockState(bp, Blocks.IRON_BLOCK.getDefaultState());
			}
			return ActionResultType.SUCCESS;
		} else {
			return ActionResultType.FAIL;
		}

	}
}
