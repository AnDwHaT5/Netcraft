package com.vfluff5.netcraft;

import com.vfluff5.netcraft.renderers.RenderComputer;
import com.vfluff5.netcraft.renderers.RenderRouter;
import com.vfluff5.netcraft.renderers.RenderSwitch;
import com.vfluff5.netcraft.tileentities.TileEntityComputer;
import com.vfluff5.netcraft.tileentities.TileEntityRouter;
import com.vfluff5.netcraft.tileentities.TileEntitySwitch;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import java.lang.reflect.Field;

public class ClientProxy extends CommonProxy {

	@Override
	public void LoadThings() {
		super.LoadThings();
		registerModels();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityComputer.class, new RenderComputer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySwitch.class, new RenderSwitch());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRouter.class, new RenderRouter());
	}

	public void registerModels() {
		ItemModelMesher itemModelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		try {
			for (Field field : BlocksAndItems.class.getFields()) {
				if (field.get(null) instanceof Block) {
					Block block = (Block) field.get(null);
					if (block != null)
						itemModelMesher.register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Netcraft.MODID + ":" + block.getUnlocalizedName(), "inventory"));
				} else if (field.get(null) instanceof Item) {
					Item item = (Item) field.get(null);
					if (item != null)
						itemModelMesher.register(item, 0, new ModelResourceLocation(Netcraft.MODID + ":" + item.getUnlocalizedName(), "inventory"));
					System.out.println(new ModelResourceLocation(Netcraft.MODID + ":" + item.getUnlocalizedName(), "inventory").toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
