package net.schoolmod.blocks.alphabet;

import net.minecraft.block.Block;

public abstract class BlockAlphabet extends Block{
	
	public BlockAlphabet(Properties properties) {
		super(properties);
	}

	public abstract char getLetter();
}
