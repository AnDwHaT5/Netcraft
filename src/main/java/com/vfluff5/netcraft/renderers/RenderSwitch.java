package com.vfluff5.netcraft.renderers;

import com.vfluff5.netcraft.Netcraft;
import com.vfluff5.netcraft.blocks.BlockTileEntity;
import com.vfluff5.netcraft.models.ModelSwitch;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderSwitch extends TileEntitySpecialRenderer {

	ResourceLocation texture = new ResourceLocation(Netcraft.MODID + ":textures/blocks/switch.png");

	//The model of your block
	private final ModelSwitch model;

	public RenderSwitch() {
		this.model = new ModelSwitch();
	}

	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage) {
		int j;

		if (!te.hasWorldObj())
		{
			j = 0;
		}
		else
		{
			Block block = te.getBlockType();
			j = te.getBlockMetadata();

			if (block instanceof BlockTileEntity && j == 0)
			{
				j = te.getBlockMetadata();
			}
		}
		this.bindTexture(texture);
		GlStateManager.pushMatrix();
		GlStateManager.enableRescaleNormal();
		GlStateManager.translate((float) x + 0.5f, (float) y + 1.7F, (float) z + 0.5F);
		GlStateManager.scale(1.0F, -1.0F, -1.0F);

		short short1 = 0;

		if (j == 2)
		{
			short1 = 180;
		}

		if (j == 3)
		{
			short1 = 0;
		}

		if (j == 4)
		{
			short1 = 90;
		}

		if (j == 5)
		{
			short1 = -90;
		}

		GlStateManager.rotate((float)short1, 0.0F, 1.0F, 0.0F);

		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0700F);

		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
	}

}
