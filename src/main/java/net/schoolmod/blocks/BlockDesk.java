package net.schoolmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.schoolmod.DeskRecipeManager;
import net.schoolmod.init.ItemInit;

public class BlockDesk extends Block {

	public static final DirectionProperty FACING = BlockStateProperties.FACING;

	public BlockDesk(Properties b) {
		super(b);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext c) {
		return this.getDefaultState().with(FACING, c.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	@Override
	public void harvestBlock(World world, PlayerEntity player, BlockPos pos, BlockState state, TileEntity te,
			ItemStack stack) {
		LazyOptional<IItemHandler> ih = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
		if (!world.isRemote) {
			ih.ifPresent(h -> {
				world.addEntity(
						new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, h.getStackInSlot(0)));
				world.addEntity(
						new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, h.getStackInSlot(1)));
				world.addEntity(
						new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, h.getStackInSlot(2)));
				h.extractItem(0, 1, false);
				h.extractItem(1, 1, false);
				h.extractItem(2, 1, false);
				te.markDirty();
			});
		}
		super.harvestBlock(world, player, pos, state, te, stack);
	}

	@Override
	public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockRayTraceResult hit) {

		TileEntityDesk te = (TileEntityDesk) world.getTileEntity(pos);
		BlockPos above = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
		ItemStack i = player.getHeldItem(hand);

		LazyOptional<IItemHandler> ih = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
		if (i.isEmpty() && player.isSneaking()) { // TAKE OUT
			ih.ifPresent(h -> {
				world.addEntity(new ItemEntity(world, above.getX() + 0.5, above.getY(), above.getZ() + 0.5,
						h.getStackInSlot(0)));
				world.addEntity(new ItemEntity(world, above.getX() + 0.5, above.getY(), above.getZ() + 0.5,
						h.getStackInSlot(1)));
				world.addEntity(new ItemEntity(world, above.getX() + 0.5, above.getY(), above.getZ() + 0.5,
						h.getStackInSlot(2)));

				h.extractItem(0, 1, false);
				h.extractItem(1, 1, false);
				h.extractItem(2, 1, false);
				te.markDirty();
			});
			return true;
		} else if (i.isEmpty() && !player.isSneaking()) { // FINISH CRAFTING

			ih.ifPresent(h -> {
				System.out.println("test");
				if (DeskRecipeManager.testRecipe(h) != Items.AIR) {
					world.addEntity(new ItemEntity(world, above.getX() + 0.5, above.getY(), above.getZ() + 0.5,
							new ItemStack(DeskRecipeManager.testRecipe(h))));
					h.extractItem(0, 1, false);
					h.extractItem(1, 1, false);
					h.extractItem(2, 1, false);

					te.markDirty();
				}
			});

			return true;

		} else if (!player.isSneaking()) {
			ih.ifPresent(h -> {
				if (h.getStackInSlot(0).isEmpty() && (i.getItem() == ItemInit.textbook
						|| i.getItem() == ItemInit.science_textbook || i.getItem() == ItemInit.math_textbook
						|| i.getItem() == ItemInit.english_textbook || i.getItem() == ItemInit.history_textbook)) {
					h.insertItem(0, new ItemStack(i.getItem(), 1), false);
					te.markDirty();
					i.shrink(1);
				}
				if (i.getItem() != ItemInit.textbook && i.getItem() != ItemInit.science_textbook
						&& i.getItem() != ItemInit.math_textbook && i.getItem() != ItemInit.english_textbook
						&& i.getItem() != ItemInit.history_textbook) {
					if (!h.getStackInSlot(0).isEmpty()) {
						if (h.getStackInSlot(1).isEmpty()) {
							h.insertItem(1, new ItemStack(i.getItem(), 1), false);
							te.markDirty();
							i.shrink(1);
						} else if (h.getStackInSlot(2).isEmpty()) {
							h.insertItem(2, new ItemStack(i.getItem(), 1), false);
							te.markDirty();
							i.shrink(1);
						}
					}
				}

			});

			return true;
		}

		return false;
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TileEntityDesk();
	}

}
