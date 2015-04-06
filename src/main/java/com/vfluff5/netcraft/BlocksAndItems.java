package com.vfluff5.netcraft;

import com.vfluff5.netcraft.blocks.BlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlocksAndItems {

	public static Block comp;
	public static Block switchb;
	public static Block router;

	public static void registerComponents() {
		comp = new BlockTileEntity(Material.iron, "computer", true, CreativeTabs.tabBlock, "computer");
		switchb = new BlockTileEntity(Material.iron, "switch", false, CreativeTabs.tabBlock, "switch");
		router = new BlockTileEntity(Material.iron, "router", false, CreativeTabs.tabBlock, "router");
	}

}
