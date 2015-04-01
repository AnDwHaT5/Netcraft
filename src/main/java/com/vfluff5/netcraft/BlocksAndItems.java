package com.vfluff5.netcraft;

import com.vfluff5.netcraft.blocks.BlockComputer;
import net.minecraft.block.Block;

public class BlocksAndItems {

	public static Block comp;

	public static void registerComponents() {
		comp = new BlockComputer();
	}

}
