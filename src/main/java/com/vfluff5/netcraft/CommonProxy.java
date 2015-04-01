package com.vfluff5.netcraft;

import com.vfluff5.netcraft.tileentities.TileEntityComputer;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void LoadThings() {
		BlocksAndItems.registerComponents();
		GameRegistry.registerTileEntity(TileEntityComputer.class, "Computer");
	}

}
