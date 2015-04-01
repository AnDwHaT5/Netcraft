package com.vfluff5.netcraft;

import java.lang.reflect.Field;

import com.vfluff5.generic.BulletRenderer;
import com.vfluff5.generic.GenericBullet;
import com.vfluff5.netcraft.renderers.RenderComputer;
import com.vfluff5.netcraft.tileentities.TileEntityComputer;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void LoadThings() {
			  ItemModelMesher itemModelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
			  try {
			   for (Field field : BlocksAndItems.class.getFields()) {
			    if (field.get(null) instanceof Block) {
			     Block block = (Block) field.get(null);
			     if(block != null)
			      itemModelMesher.register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Netcraft.MODID + ":" + block.getUnlocalizedName(), "inventory"));
			    } else
			    if (field.get(null) instanceof Item) {
			     Item item = (Item) field.get(null);
			     if(item != null)
			      itemModelMesher.register(item, 0, new ModelResourceLocation(Netcraft.MODID + ":" + item.getUnlocalizedName(), "inventory"));
			     System.out.println(new ModelResourceLocation(Netcraft.MODID + ":" + item.getUnlocalizedName(), "inventory").toString());
			    }
			  } 
			  }catch (Exception e) {
			   e.printStackTrace();
			  }
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityComputer.class, new RenderComputer());
			 }

}
