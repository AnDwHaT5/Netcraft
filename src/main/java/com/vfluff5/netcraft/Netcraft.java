package com.vfluff5.netcraft;

import com.vfluff5.netcraft.tileentities.TileEntityComputer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(name = Netcraft.NAME, modid = Netcraft.MODID, version = Netcraft.VERSION)
public class Netcraft {

	@SidedProxy(clientSide = "com.vfluff5.netcraft.ClientProxy", serverSide = "com.vfluff5.netcraft.CommonProxy")
	public static CommonProxy proxy;

	public static final String NAME = "Netcraft";
	public static final String MODID = "netcraft";
	public static final String VERSION = "1.0 DEV";


	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.LoadThings();
	}

	@EventHandler
	public void load(FMLLoadEvent event) {
	}


}
