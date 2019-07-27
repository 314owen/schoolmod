package net.schoolmod.blocks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.schoolmod.init.TileEntityInit;

public class TileEntityDesk extends TileEntity {
	
	private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);
	
	public TileEntityDesk() {
		super(TileEntityInit.DESK);
	}
	
	@Override
	public void read(CompoundNBT compound) {
		CompoundNBT invTag = compound.getCompound("inventory");
        handler.ifPresent(h -> ((INBTSerializable<CompoundNBT>)h).deserializeNBT(invTag));
		super.read(compound);
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
		handler.ifPresent(h -> {
            CompoundNBT tag = ((INBTSerializable<CompoundNBT>)h).serializeNBT();
            compound.put("inventory", tag);
        });
		return super.write(compound);
	}
	
	@Override
	public CompoundNBT getUpdateTag() {
		return this.write(new CompoundNBT());
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		this.read(pkt.getNbtCompound());
	}
	
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.pos, 0, this.getUpdateTag());
	}
	
	private IItemHandler createHandler() {
        return new ItemStackHandler(3);
    }
	
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }
}
