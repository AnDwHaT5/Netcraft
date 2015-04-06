package com.vfluff5.netcraft.tileentities;


import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRouter extends TileEntity {

	public TileEntityRouter() {
		NBTTagCompound a = new NBTTagCompound();
		a.setString("IP fe0/0", "");
		a.setString("IP fe0/1", "");
		a.setString("IP fe0/3", "");
		a.setString("IP fe0/4", "");
		a.setString("SubnetMask fe0/1", "");
		a.setString("SubnetMask fe0/2", "");
		a.setString("SubnetMask fe0/3", "");
		a.setString("SubnetMask fe0/4", "");
		a.setString("Hostname", "Router");
		a.setString("Username", "");
		a.setString("Password", "");
		writeToNBT(a);
	}

}
