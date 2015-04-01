package com.vfluff5.netcraft.renderers;

import com.vfluff5.netcraft.Netcraft;
import com.vfluff5.netcraft.models.ModelComputer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderComputer extends TileEntitySpecialRenderer {

	ResourceLocation texture = new ResourceLocation(Netcraft.MODID + ":textures/blocks/computer.png");

	//The model of your block
	private final ModelComputer model;

	public RenderComputer() {
		this.model = new ModelComputer();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage) {
		this.bindTexture(texture);
		GlStateManager.enableRescaleNormal();
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x + 0.5F, (float) y + 1.7F, (float) z + 0.5F);
		GlStateManager.rotate(180F, 0.0F, 0.0F, 1.0F);
		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0700F);
		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
	}

}
